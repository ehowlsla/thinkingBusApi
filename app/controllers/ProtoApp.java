package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import model.AppDownloadURL;
import model.Contents;
import model.Recommands;
import model.Replies;
import model.Users;

import org.h2.util.IOUtils;

import play.mvc.Controller;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import responseObj.CheckUpdateObj;
import responseObj.ContentsObj;
import responseObj.RecommandsObj;
import responseObj.RepliesObj;
import responseObj.ReturnMsg;
import responseObj.UsersObj;
import utils.ThumbnailGenerator;

import com.google.gson.Gson;

public class ProtoApp extends Controller {

	

	public static Result urlUpdate(String user_idx, String ver, String url) {
		if (AppDownloadURL.updateURL(ver, url)) {
			return ok(new Gson().toJson(new ReturnMsg("Y", "ver=" + ver + ", url=" + url)));
		} else
			return ok(new Gson().toJson(new ReturnMsg("N", "failed, check ver.")));
	}

	public static Result checkUpdate(String user_idx, String udid, String ver) {
		Users user = Users.getUserId(user_idx, udid);
		AppDownloadURL appURL = AppDownloadURL.getAppURL(ver);
		CheckUpdateObj checkUpdateObj = new CheckUpdateObj(
				String.valueOf(user.id), appURL.ver == null ? "" : appURL.ver,
				appURL.downloadURL == null ? "" : appURL.downloadURL);

		return ok(new Gson().toJson(checkUpdateObj));
	}

	public static Result contentList(String user_idx, String udid,
			String content_idx, String pSize) {
		List<Contents> data = Contents.getContentList(user_idx, udid,
				content_idx, pSize);
		List<ContentsObj> result = new LinkedList<ContentsObj>();
		for (Contents model : data) {
			result.add(new ContentsObj(model));
		}
		return ok(new Gson().toJson(result));
	}

	public static Result contentDetail(String user_idx, String udid,
			String content_idx) {
		return ok(new Gson().toJson(new ContentsObj(Contents.getContentDetail(
				user_idx, udid, content_idx))));
	}

	public static Result contentReplies(String user_idx, String udid,
			String content_idx, String laReDate, String rSize) {
		DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdFormat.parse(rSize);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Replies> replies = Replies.getContentReplies(user_idx, udid,
				content_idx, date, rSize);
		List<RepliesObj> result = new LinkedList<RepliesObj>();
		for (Replies reply : replies) {
			result.add(new RepliesObj(reply));
		}
		return ok(new Gson().toJson(result));
	}

	public static Result contentUpload(String user_idx, String udid,
			String title, String content, String busTag, String isNotice) {
		if(request().body().asMultipartFormData() != null) {
			List<FilePart> uploadFiles = request().body().asMultipartFormData().getFiles();
			int imageNum = 1;
			String imageURL = null;
			String s_imageURL = null;
			int startIndex = 0;
			int endIndex = 0;
			int checkIndex = 0;
			StringBuilder sb = new StringBuilder();
			for (FilePart part : uploadFiles) {
				if (part != null) {
					File file = part.getFile();
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
					imageURL = "Images/Contents/" + user_idx + "_"+ format.format(date) + "_" + String.valueOf(imageNum) + ".JPG";
					s_imageURL = "Images/Contents/s_" + user_idx + "_"+ format.format(date) + "_" + String.valueOf(imageNum) +".JPG";
					File saveFile = new File(imageURL);
					FileInputStream is;
					try {
						is = new FileInputStream(file);
						IOUtils.copy(is, new FileOutputStream(saveFile));
						ThumbnailGenerator generator = new ThumbnailGenerator();
						generator.transform(imageURL, s_imageURL, 320, 320, 1);
						imageNum++;
						
						//content의 내용을 변경해야 한다.
						int tempStartIndex = startIndex;
						startIndex = content.indexOf("#image-", tempStartIndex);
						endIndex = content.indexOf("-image#", tempStartIndex);
						
						if(checkIndex < startIndex) {
							sb.append(content.substring(startIndex));
						}
						
						sb.append("#image-" + s_imageURL + "-image#");
						startIndex = endIndex + "-image#".length();
						checkIndex = startIndex;
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					content = sb.toString();
				}
			}
		}
		
		Contents contents = Contents.upload(user_idx, udid, title, content, busTag, isNotice);
		if(contents == null)
			return ok(new Gson().toJson(new ReturnMsg("N","Already Uploaded.")));
		else
			return ok(new Gson().toJson(new ContentsObj(contents)));
	}

	public static Result replyUpload(String user_idx, String udid,
			String content_idx, String content) {
		Replies replies = Replies.upload(user_idx, udid, content_idx, content);
		if(replies == null)
			return ok(new Gson().toJson(new ReturnMsg("N", "Already Uploaded.")));
		else
			return ok(new Gson().toJson(new RepliesObj(replies)));
	}

	public static Result profileUpload (String user_idx, String udid, String nickname, String gender, String memo) {
		String imageURL = null;
		String s_imageURL = null;
		if(request().body().asMultipartFormData() != null) {
			List<FilePart> uploadFiles = request().body().asMultipartFormData().getFiles();
			
			
			for (FilePart part : uploadFiles) {
				if (part != null) {
					File file = part.getFile();
					imageURL = "Images/Profile/" + user_idx + ".JPG";
					s_imageURL = "Images/Profile/s_" + user_idx + ".JPG";
					File saveFile = new File(imageURL);
					FileInputStream is;
					try {
						is = new FileInputStream(file);
						IOUtils.copy(is, new FileOutputStream(saveFile));
						ThumbnailGenerator generator = new ThumbnailGenerator();
						generator.transform(imageURL, s_imageURL, 90, 90, 1);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		

		UsersObj user = new UsersObj(Users.update(user_idx, udid, nickname, gender, memo, s_imageURL));
		return ok(new Gson().toJson(user));
	}
	

	public static Result search(String user_idx, String udid, String content_idx, String word,
			String mode, String pSize) {
		// 버스노선 1
		// 내용기반 2
		// 최신순 3
		// 추천순 4
		// 내가 쓴 글 보기 5
		List<Contents> data = Contents.getContentListBySearch(user_idx, udid, content_idx, word, mode, pSize);
		List<ContentsObj> result = new LinkedList<ContentsObj>();
		for (Contents model : data) {
			result.add(new ContentsObj(model));
		}
		
		return ok(new Gson().toJson(result));
	}

	public static Result recommand(String user_idx, String udid,
			String content_idx) {
		Recommands recommands = Recommands.addRecommands(user_idx, content_idx);
		if (recommands == null)
			return ok();
		else {
			RecommandsObj result = new RecommandsObj(recommands);
			return ok(new Gson().toJson(result));
		}
	}

	public static Result recommandCancel(String user_idx, String udid,
			String content_idx) {
		if (Recommands.removeRecommands(user_idx, content_idx))
			return ok(new Gson().toJson(new ReturnMsg("Y", "Success")));
		else
			return ok(new Gson().toJson(new ReturnMsg("N", "failed")));
	}

	public static Result contentUpdate(String user_idx, String udid,
			String content_idx, String title, String content, String busTag,
			String isNotice) {
		Contents contents = Contents.update(user_idx, udid, content_idx, title,
				content, busTag, isNotice);
		ContentsObj result = new ContentsObj(contents);
		return ok(new Gson().toJson(result));
	}

	public static Result contentDelete(String user_idx, String udid,
			String content_idx) {
		Contents content = Contents.delete(user_idx, udid, content_idx);
		ContentsObj result = new ContentsObj(content);
		return ok(new Gson().toJson(result));
	}

	public static Result replyDelete(String user_idx, String udid,
			String content_idx, String reDate) {
		Replies reply = Replies.delete(user_idx, udid, content_idx, reDate);
		RepliesObj result = new RepliesObj(reply);
		return ok(new Gson().toJson(result));
	}
}
