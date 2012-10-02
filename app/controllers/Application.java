package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.h2.util.IOUtils;

import model.AppDownloadURL;
import model.Contents;
import model.Recommands;
import model.Replies;
import model.Users;

import play.api.mvc.MultipartFormData;
import play.mvc.*;
import play.mvc.Http.MultipartFormData.FilePart;
import responseObj.CheckUpdateObj;
import responseObj.ContentsObj;
import responseObj.RecommandsObj;
import responseObj.RepliesObj;
import responseObj.ReturnMsg;
import responseObj.UsersObj;

import utils.ThumbnailGenerator;
import views.html.*;

import com.google.gson.Gson;

public class Application extends Controller {
  
  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }
  
	public static Result urlUpdate(String user_idx, String ver, String url) {
		if (AppDownloadURL.updateURL(ver, url)) {
			return ok(new Gson().toJson(new ReturnMsg("Y", "ver=" + ver
					+ ", url=" + url)));
		} else
			return ok(new Gson()
					.toJson(new ReturnMsg("N", "failed, check ver.")));
	}
  
  public static Result checkUpdate () {
	    Map<String, String[]> params = request().body().asFormUrlEncoded();
	  

		String user_idx = params.get("user_idx")[0];
		String udid = params.get("udid")[0];
		String ver = params.get("ver")[0];
	
		Users user = Users.getUserId(user_idx, udid);
		AppDownloadURL appURL = AppDownloadURL.getAppURL(ver);
		CheckUpdateObj checkUpdateObj = new CheckUpdateObj(
				String.valueOf(user.id), appURL.ver == null ? "" : appURL.ver,
				appURL.downloadURL == null ? "" : appURL.downloadURL);
		
		return ok(new Gson().toJson(checkUpdateObj));
  } 
  


	 

	public static Result contentList() {
		Map<String, String[]> params = request().body().asFormUrlEncoded();

		String user_idx = params.get("user_idx")[0];
		String udid = params.get("udid")[0];
		String content_idx = params.get("content_idx")[0];
		String pSize = params.get("pSize")[0];
		
		List<Contents> data = Contents.getContentList(user_idx, udid,
				content_idx, pSize);
		List<ContentsObj> result = new LinkedList<ContentsObj>();
		for (Contents model : data) {
			result.add(new ContentsObj(model));
		}
		return ok(new Gson().toJson(result));
	}

	public static Result contentDetail() {
		Map<String, String[]> params = request().body().asFormUrlEncoded();

		String user_idx = params.get("user_idx")[0];
		String udid = params.get("udid")[0];
		String content_idx = params.get("content_idx")[0];
		
		return ok(new Gson().toJson(new ContentsObj(Contents.getContentDetail(
				user_idx, udid, content_idx))));
	}

	public static Result contentReplies() {
		Map<String, String[]> params = request().body().asFormUrlEncoded();

		String user_idx = params.get("user_idx")[0];
		String udid = params.get("udid")[0];
		String content_idx = params.get("content_idx")[0];
		String laReDate = params.get("laReDate")[0];
		String rSize = params.get("rSize")[0];
		
		List<Replies> replies = Replies.getContentReplies(user_idx, udid,
				content_idx, laReDate, rSize);
		List<RepliesObj> result = new LinkedList<RepliesObj>();
		for (Replies reply : replies) {
			result.add(new RepliesObj(reply));
		}
		return ok(new Gson().toJson(result));
	}

	public static Result contentUpload() {
		
		String user_idx = null;
		String udid = null;
		String title = null;
		String content = null;
		String busTag = null;
		String isNotice = null;
		
		if(request().body().asMultipartFormData() != null) {
			Map<String, String[]> params = request().body().asMultipartFormData().asFormUrlEncoded();

			user_idx = params.get("user_idx")[0];
			udid = params.get("udid")[0];
			title = params.get("title")[0];
			content = params.get("content")[0];
			busTag = params.get("busTag")[0];
			isNotice = params.get("isNotice")[0];
			
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

	public static Result replyUpload() {
		Map<String, String[]> params = request().body().asFormUrlEncoded();

		String user_idx = params.get("user_idx")[0];
		String udid = params.get("udid")[0];
		String content_idx = params.get("content_idx")[0];
		String content = params.get("content")[0];
		
		Replies replies = Replies.upload(user_idx, udid, content_idx, content);
		if(replies == null)
			return ok(new Gson().toJson(new ReturnMsg("N", "Already Uploaded.")));
		else
			return ok(new Gson().toJson(new RepliesObj(replies)));
	}

	public static Result profileUpload () {
		Map<String, String[]> params = request().body().asFormUrlEncoded();

		String user_idx = params.get("user_idx")[0];
		String udid = params.get("udid")[0];
		String nickname = params.get("nickname")[0];
		String gender = params.get("gender")[0];
		String memo = params.get("memo")[0];
		
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
	

	// 버스노선 1
	// 내용기반 2
	// 최신순 3
	// 추천순 4
	// 내가 쓴 글 보기 5
	public static Result search() {
		Map<String, String[]> params = request().body().asFormUrlEncoded();

		String user_idx = params.get("user_idx")[0];
		String udid = params.get("udid")[0];
		String content_idx = params.get("content_idx")[0];
		String word = params.get("word")[0];
		String mode = params.get("mode")[0];
		String pSize = params.get("pSize")[0];
		
		List<Contents> data = Contents.getContentListBySearch(user_idx, udid, content_idx, word, mode, pSize);
		List<ContentsObj> result = new LinkedList<ContentsObj>();
		for (Contents model : data) {
			result.add(new ContentsObj(model));
		}
		
		return ok(new Gson().toJson(result));
	}

	public static Result recommand() {
		Map<String, String[]> params = request().body().asFormUrlEncoded();

		String user_idx = params.get("user_idx")[0];
		String udid = params.get("udid")[0];
		String content_idx = params.get("content_idx")[0];
		
		Recommands recommands = Recommands.addRecommands(user_idx, content_idx);
		if (recommands == null)
			return ok();
		else {
			RecommandsObj result = new RecommandsObj(recommands);
			return ok(new Gson().toJson(result));
		}
	}

	public static Result recommandCancel() {
		Map<String, String[]> params = request().body().asFormUrlEncoded();

		String user_idx = params.get("user_idx")[0];
		String udid = params.get("udid")[0];
		String content_idx = params.get("content_idx")[0];
		
		if (Recommands.removeRecommands(user_idx, content_idx))
			return ok(new Gson().toJson(new ReturnMsg("Y", "Success")));
		else
			return ok(new Gson().toJson(new ReturnMsg("N", "failed")));
	}

	public static Result contentUpdate() {
		Map<String, String[]> params = request().body().asFormUrlEncoded();

		String user_idx = params.get("user_idx")[0];
		String udid = params.get("udid")[0];
		String content_idx = params.get("content_idx")[0];
		String title = params.get("title")[0];
		String content = params.get("content")[0];
		String busTag = params.get("busTag")[0];
		String isNotice = params.get("isNotice")[0];
		
		Contents contents = Contents.update(user_idx, udid, content_idx, title,
				content, busTag, isNotice);
		ContentsObj result = new ContentsObj(contents);
		return ok(new Gson().toJson(result));
	}

	public static Result contentDelete() {
		Map<String, String[]> params = request().body().asFormUrlEncoded();

		String user_idx = params.get("user_idx")[0];
		String udid = params.get("udid")[0];
		String content_idx = params.get("content_idx")[0];
		
		Contents content = Contents.delete(user_idx, udid, content_idx);
		ContentsObj result = new ContentsObj(content);
		return ok(new Gson().toJson(result));
	}

	public static Result replyDelete() {
		Map<String, String[]> params = request().body().asFormUrlEncoded();

		String user_idx = params.get("user_idx")[0];
		String udid = params.get("udid")[0];
		String content_idx = params.get("content_idx")[0];
		String reDate = params.get("reDate")[0];
		
		Replies reply = Replies.delete(user_idx, udid, content_idx, reDate);
		RepliesObj result = new RepliesObj(reply);
		return ok(new Gson().toJson(result));
	}
}