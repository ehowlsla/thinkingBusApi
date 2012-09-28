package controllers;

import java.util.Map;

import model.AppDownloadURL;
import model.Contents;
import model.Replies;
import model.Users;

import play.mvc.*;
import responseObj.CheckUpdateObj;

import views.html.*;

import com.google.gson.Gson;

public class Application extends Controller {
  
  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }
  
  public static Result test(String name) {
	  //String test =  request().queryString().get("test").toString();
	  System.out.println(name);
	  return ok(name);
	  
  }
  
  public static Result checkUpdate () {
	  Map<String, String[]> params = request().body().asFormUrlEncoded();
	  
//	  String[] user_idx = params.get("user_idx");
//	  System.out.println(user_idx);
	
	  
//	  String[] udid = params.get("udid");
//	  String[] ver = params.get("ver");
	  
//	  if(user_idx == null || udid == null || ver == null)
//		  return ok("");
	  
//	  System.out.println("checkUpdate = user_idx : " + user_idx + ", udid :" + udid + ", ver :" + ver);

	  return ok("");
//	  Users user = Users.getUserId(user_idx[0], udid[0]);
//	  AppDownloadURL appURL = AppDownloadURL.getAppURL(ver[0]);
//	  CheckUpdateObj checkUpdateObj = new CheckUpdateObj(
//			  String.valueOf(user.id), 
//			  appURL.ver, 
//			  appURL.downloadURL);
//	  
//	  return ok(new Gson().toJson(checkUpdateObj));
  } 
  
  public static Result contentList (String user_idx, String udid, String content_idx, String pSize) {
	  return ok(new Gson().toJson(Contents.getContentList(user_idx, udid, content_idx, pSize)));
  }

  public static Result contentDetail (String user_idx, String udid, String content_idx) {
	  return ok();
  }
  

  public static Result contentReplies (String user_idx, String udid, String content_idx, String laReDate, String rSize) {
	  return ok(new Gson().toJson(Replies.getContentReplies(user_idx, udid, content_idx, laReDate, rSize)));
  }
  
  public static Result contentUpload (String user_idx, String udid, String title, String content, String busTag, String isNotice) {
	  Contents.upload(user_idx, udid, title, content, busTag, isNotice);
	  return ok();
  }
  
  public static Result replyUpload (String user_idx, String udid, String content_idx, String content) {
	  Replies.upload(user_idx, udid, content_idx, content);
	  return ok();
  }
  
  public static Result profileUpload (String user_idx, String udid, String nickname, String gender, String memo) {
	  //이미지 처리해야함 
	  return ok(new Gson().toJson(Users.update(user_idx, udid, nickname, gender, memo)));
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