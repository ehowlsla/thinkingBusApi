package controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.AppDownloadURL;
import model.Contents;
import model.Replies;
import model.Users; 

import com.google.gson.Gson;

import play.mvc.Controller;
import play.mvc.Result;
import responseObj.CheckUpdateObj;
import responseObj.ContentsObj;
import responseObj.RepliesObj;
import responseObj.UsersObj;
import views.html.index;

public class ProtoApp extends Controller{

	public static Result index() {
	    return ok(index.render("Your new application is ready."));
	  }
	  
	  public static Result test(String name) {
		  //String test =  request().queryString().get("test").toString();
		  System.out.println(name);
		  return ok(name);
		  
	  }
	  
	  public static Result urlUpdate(String user_idx, String ver, String url) {
		  if(AppDownloadURL.updateURL(ver, url)) {
			  return ok("success");
		  } else 
			  return ok("failed");
	  }
	  
	  public static Result checkUpdate (String user_idx, String udid, String ver) {
		   
		  Users user = Users.getUserId(user_idx, udid);
		  AppDownloadURL appURL = AppDownloadURL.getAppURL(ver);
		  
		  System.out.println(user.id);
		  
		  CheckUpdateObj checkUpdateObj = new CheckUpdateObj(
				  String.valueOf(user.id), 
				  appURL.ver == null ? "" : appURL.ver, 
				  appURL.downloadURL == null ? "" : appURL.downloadURL);
		    
		  return ok(new Gson().toJson(checkUpdateObj));
	  } 
	  
	  public static Result contentList (String user_idx, String udid, String content_idx, String pSize) {
//		  return ok(new Gson().toJson(Contents.getContentList(user_idx, udid, content_idx, pSize)));
		  List<Contents> data = Contents.getContentList(user_idx, udid, content_idx, pSize);
		  
		  System.out.println("data = " + data);
		  
		  List<ContentsObj> result = new LinkedList<ContentsObj>();
		  
		  for (Contents model : data) {
			  result.add(new ContentsObj(model));
	    	}
		  return ok(new Gson().toJson(result));
	  }
	  
	  

	  public static Result contentDetail (String user_idx, String udid, String content_idx) {
		  return ok();
	  }
	  

	  public static Result contentReplies (String user_idx, String udid, String content_idx, String laReDate, String rSize) {
		  List<Replies> replies = Replies.getContentReplies(user_idx, udid, content_idx, laReDate, rSize);
		  List<RepliesObj> result = new LinkedList<RepliesObj>();
		  
		  for(Replies reply : replies) {
			  result.add(new RepliesObj(reply));
		  }
		  
		  return ok(new Gson().toJson(result));
	  }
	  
	  public static Result contentUpload (String user_idx, String udid, String title, String content, String busTag, String isNotice) {
		  System.out.println("contents Upload");
		  Contents.upload(user_idx, udid, title, content, busTag, isNotice);
		  return ok();
	  }
	  
	  public static Result replyUpload (String user_idx, String udid, String content_idx, String content) {
		  Replies.upload(user_idx, udid, content_idx, content);
		  return ok();
	  }
	  
	  public static Result profileUpload (String user_idx, String udid, String nickname, String gender, String memo) {
		  //이미지 처리해야함 
		  UsersObj user = new UsersObj(Users.update(user_idx, udid, nickname, gender, memo));
		  return ok(new Gson().toJson(user));
	  }
	  
	  public static Result search (String user_idx, String udid, String word, String mode, String pSize) {
		  //버스노선 1
		  //내용기반 2
		  //최신순 3
		  //추천순 4
		  //내가 쓴 글 보기 5
		  return ok();
	  }
	  public static Result recommand (String user_idx, String udid, String content_idx) {
		  return ok();
	  }
	  
	  public static Result contentUpdate (String user_idx, String udid, String content_idx, String title, String content, String isNotice) {
		  //return ok(new Gson().toJson(Contents.update(user_idx, udid, content_idx, title, content, isNotice)));
		  
		  //busTag 삽입해야
		  return ok();
	  }
	  
	  public static Result contentDelete (String user_idx, String udid, String content_idx) {
		  return ok(new Gson().toJson(Contents.delete(user_idx, udid, content_idx)));
	  }
	  
	  public static Result replyDelete (String user_idx, String udid, String content_idx, String reDate) {
		  return ok();
	  }
}
