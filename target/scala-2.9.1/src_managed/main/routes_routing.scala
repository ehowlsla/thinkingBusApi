// @SOURCE:/Users/rupy1014/Documents/workspace_play/thinkingBus/conf/routes
// @HASH:25321af0ffe54b0b37abc79f4822d1978315ac5a
// @DATE:Fri Sep 28 19:50:46 KST 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:9
val controllers_Assets_at1 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    

// @LINE:12
val controllers_ProtoApp_urlUpdate2 = Route("GET", PathPattern(List(StaticPart("/urlUpdate/"),DynamicPart("user_idx", """.+"""),StaticPart("/"),DynamicPart("ver", """.+"""),StaticPart("/"),DynamicPart("url", """.+"""))))
                    

// @LINE:16
val controllers_Application_checkUpdate3 = Route("POST", PathPattern(List(StaticPart("/checkUpdate"))))
                    

// @LINE:17
val controllers_ProtoApp_checkUpdate4 = Route("GET", PathPattern(List(StaticPart("/checkUpdate/"),DynamicPart("user_idx", """.+"""),StaticPart("/"),DynamicPart("udid", """.+"""),StaticPart("/"),DynamicPart("ver", """.+"""))))
                    

// @LINE:20
val controllers_Application_contentList5 = Route("POST", PathPattern(List(StaticPart("/contentList"))))
                    

// @LINE:21
val controllers_ProtoApp_contentList6 = Route("GET", PathPattern(List(StaticPart("/contentList/"),DynamicPart("user_idx", """.+"""),StaticPart("/"),DynamicPart("udid", """.+"""),StaticPart("/"),DynamicPart("content_idx", """.+"""),StaticPart("/"),DynamicPart("pSize", """.+"""))))
                    

// @LINE:24
val controllers_Application_contentDetail7 = Route("POST", PathPattern(List(StaticPart("/contentDetail"))))
                    

// @LINE:27
val controllers_Application_contentReplies8 = Route("POST", PathPattern(List(StaticPart("/contentReplies"))))
                    

// @LINE:28
val controllers_ProtoApp_contentReplies9 = Route("GET", PathPattern(List(StaticPart("/contentReplies/"),DynamicPart("user_idx", """.+"""),StaticPart("/"),DynamicPart("udid", """.+"""),StaticPart("/"),DynamicPart("content_idx", """.+"""),StaticPart("/"),DynamicPart("laReDate", """.+"""),StaticPart("/"),DynamicPart("rSize", """.+"""))))
                    

// @LINE:31
val controllers_Application_contentUpload10 = Route("POST", PathPattern(List(StaticPart("/contentUpload"))))
                    

// @LINE:32
val controllers_ProtoApp_contentUpload11 = Route("GET", PathPattern(List(StaticPart("/contentUpload/"),DynamicPart("user_idx", """.+"""),StaticPart("/"),DynamicPart("udid", """.+"""),StaticPart("/"),DynamicPart("title", """.+"""),StaticPart("/"),DynamicPart("content", """.+"""),StaticPart("/"),DynamicPart("busTag", """.+"""),StaticPart("/"),DynamicPart("isNotice", """.+"""))))
                    

// @LINE:35
val controllers_Application_replyUpload12 = Route("POST", PathPattern(List(StaticPart("/replyUpload"))))
                    

// @LINE:36
val controllers_ProtoApp_replyUpload13 = Route("GET", PathPattern(List(StaticPart("/replyUpload/"),DynamicPart("user_idx", """.+"""),StaticPart("/"),DynamicPart("udid", """.+"""),StaticPart("/"),DynamicPart("content_idx", """.+"""),StaticPart("/"),DynamicPart("content", """.+"""))))
                    

// @LINE:40
val controllers_Application_profileUpload14 = Route("POST", PathPattern(List(StaticPart("/profileUpload"))))
                    

// @LINE:41
val controllers_ProtoApp_profileUpload15 = Route("GET", PathPattern(List(StaticPart("/profileUpload/"),DynamicPart("user_idx", """.+"""),StaticPart("/"),DynamicPart("udid", """.+"""),StaticPart("/"),DynamicPart("nickname", """.+"""),StaticPart("/"),DynamicPart("gender", """.+"""),StaticPart("/"),DynamicPart("memo", """.+"""))))
                    

// @LINE:47
val controllers_Application_recommand16 = Route("POST", PathPattern(List(StaticPart("/recommand"))))
                    

// @LINE:50
val controllers_Application_contentUpdate17 = Route("POST", PathPattern(List(StaticPart("/contentUpdate"))))
                    

// @LINE:51
val controllers_ProtoApp_contentUpdate18 = Route("GET", PathPattern(List(StaticPart("/contentUpdate"))))
                    

// @LINE:57
val controllers_Application_replyDelete19 = Route("POST", PathPattern(List(StaticPart("/replyDelete"))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.index()"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""","""/urlUpdate/$user_idx<.+>/$ver<.+>/$url<.+>""","""controllers.ProtoApp.urlUpdate(user_idx:String, ver:String, url:String)"""),("""POST""","""/checkUpdate""","""controllers.Application.checkUpdate()"""),("""GET""","""/checkUpdate/$user_idx<.+>/$udid<.+>/$ver<.+>""","""controllers.ProtoApp.checkUpdate(user_idx:String, udid:String, ver:String)"""),("""POST""","""/contentList""","""controllers.Application.contentList(user_idx:String, udid:String, content_idx:String, pSize:String)"""),("""GET""","""/contentList/$user_idx<.+>/$udid<.+>/$content_idx<.+>/$pSize<.+>""","""controllers.ProtoApp.contentList(user_idx:String, udid:String, content_idx:String, pSize:String)"""),("""POST""","""/contentDetail""","""controllers.Application.contentDetail(user_idx:String, udid:String, content_idx:String)"""),("""POST""","""/contentReplies""","""controllers.Application.contentReplies(user_idx:String, udid:String, content_idx:String, laReDate:String, rSize:String)"""),("""GET""","""/contentReplies/$user_idx<.+>/$udid<.+>/$content_idx<.+>/$laReDate<.+>/$rSize<.+>""","""controllers.ProtoApp.contentReplies(user_idx:String, udid:String, content_idx:String, laReDate:String, rSize:String)"""),("""POST""","""/contentUpload""","""controllers.Application.contentUpload(user_idx:String, udid:String, title:String, content:String, busTag:String, isNotice:String)"""),("""GET""","""/contentUpload/$user_idx<.+>/$udid<.+>/$title<.+>/$content<.+>/$busTag<.+>/$isNotice<.+>""","""controllers.ProtoApp.contentUpload(user_idx:String, udid:String, title:String, content:String, busTag:String, isNotice:String)"""),("""POST""","""/replyUpload""","""controllers.Application.replyUpload(user_idx:String, udid:String, content_idx:String, content:String)"""),("""GET""","""/replyUpload/$user_idx<.+>/$udid<.+>/$content_idx<.+>/$content<.+>""","""controllers.ProtoApp.replyUpload(user_idx:String, udid:String, content_idx:String, content:String)"""),("""POST""","""/profileUpload""","""controllers.Application.profileUpload(user_idx:String, udid:String, nickname:String, gender:String, memo:String)"""),("""GET""","""/profileUpload/$user_idx<.+>/$udid<.+>/$nickname<.+>/$gender<.+>/$memo<.+>""","""controllers.ProtoApp.profileUpload(user_idx:String, udid:String, nickname:String, gender:String, memo:String)"""),("""POST""","""/recommand""","""controllers.Application.recommand(user_idx:String, udid:String, content_idx:String)"""),("""POST""","""/contentUpdate""","""controllers.Application.contentUpdate(user_idx:String, udid:String, title:String, content:String, busTag:String, isNotice:String)"""),("""GET""","""/contentUpdate""","""controllers.ProtoApp.contentUpdate(user_idx:String, udid:String, title:String, content:String, busTag:String, isNotice:String)"""),("""POST""","""/replyDelete""","""controllers.Application.replyDelete(user_idx:String, udid:String, content_idx:String, reDate:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:9
case controllers_Assets_at1(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    

// @LINE:12
case controllers_ProtoApp_urlUpdate2(params) => {
   call(params.fromPath[String]("user_idx", None), params.fromPath[String]("ver", None), params.fromPath[String]("url", None)) { (user_idx, ver, url) =>
        invokeHandler(_root_.controllers.ProtoApp.urlUpdate(user_idx, ver, url), HandlerDef(this, "controllers.ProtoApp", "urlUpdate", Seq(classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:16
case controllers_Application_checkUpdate3(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.checkUpdate(), HandlerDef(this, "controllers.Application", "checkUpdate", Nil))
   }
}
                    

// @LINE:17
case controllers_ProtoApp_checkUpdate4(params) => {
   call(params.fromPath[String]("user_idx", None), params.fromPath[String]("udid", None), params.fromPath[String]("ver", None)) { (user_idx, udid, ver) =>
        invokeHandler(_root_.controllers.ProtoApp.checkUpdate(user_idx, udid, ver), HandlerDef(this, "controllers.ProtoApp", "checkUpdate", Seq(classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:20
case controllers_Application_contentList5(params) => {
   call(params.fromQuery[String]("user_idx", None), params.fromQuery[String]("udid", None), params.fromQuery[String]("content_idx", None), params.fromQuery[String]("pSize", None)) { (user_idx, udid, content_idx, pSize) =>
        invokeHandler(_root_.controllers.Application.contentList(user_idx, udid, content_idx, pSize), HandlerDef(this, "controllers.Application", "contentList", Seq(classOf[String], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:21
case controllers_ProtoApp_contentList6(params) => {
   call(params.fromPath[String]("user_idx", None), params.fromPath[String]("udid", None), params.fromPath[String]("content_idx", None), params.fromPath[String]("pSize", None)) { (user_idx, udid, content_idx, pSize) =>
        invokeHandler(_root_.controllers.ProtoApp.contentList(user_idx, udid, content_idx, pSize), HandlerDef(this, "controllers.ProtoApp", "contentList", Seq(classOf[String], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:24
case controllers_Application_contentDetail7(params) => {
   call(params.fromQuery[String]("user_idx", None), params.fromQuery[String]("udid", None), params.fromQuery[String]("content_idx", None)) { (user_idx, udid, content_idx) =>
        invokeHandler(_root_.controllers.Application.contentDetail(user_idx, udid, content_idx), HandlerDef(this, "controllers.Application", "contentDetail", Seq(classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:27
case controllers_Application_contentReplies8(params) => {
   call(params.fromQuery[String]("user_idx", None), params.fromQuery[String]("udid", None), params.fromQuery[String]("content_idx", None), params.fromQuery[String]("laReDate", None), params.fromQuery[String]("rSize", None)) { (user_idx, udid, content_idx, laReDate, rSize) =>
        invokeHandler(_root_.controllers.Application.contentReplies(user_idx, udid, content_idx, laReDate, rSize), HandlerDef(this, "controllers.Application", "contentReplies", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:28
case controllers_ProtoApp_contentReplies9(params) => {
   call(params.fromPath[String]("user_idx", None), params.fromPath[String]("udid", None), params.fromPath[String]("content_idx", None), params.fromPath[String]("laReDate", None), params.fromPath[String]("rSize", None)) { (user_idx, udid, content_idx, laReDate, rSize) =>
        invokeHandler(_root_.controllers.ProtoApp.contentReplies(user_idx, udid, content_idx, laReDate, rSize), HandlerDef(this, "controllers.ProtoApp", "contentReplies", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:31
case controllers_Application_contentUpload10(params) => {
   call(params.fromQuery[String]("user_idx", None), params.fromQuery[String]("udid", None), params.fromQuery[String]("title", None), params.fromQuery[String]("content", None), params.fromQuery[String]("busTag", None), params.fromQuery[String]("isNotice", None)) { (user_idx, udid, title, content, busTag, isNotice) =>
        invokeHandler(_root_.controllers.Application.contentUpload(user_idx, udid, title, content, busTag, isNotice), HandlerDef(this, "controllers.Application", "contentUpload", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:32
case controllers_ProtoApp_contentUpload11(params) => {
   call(params.fromPath[String]("user_idx", None), params.fromPath[String]("udid", None), params.fromPath[String]("title", None), params.fromPath[String]("content", None), params.fromPath[String]("busTag", None), params.fromPath[String]("isNotice", None)) { (user_idx, udid, title, content, busTag, isNotice) =>
        invokeHandler(_root_.controllers.ProtoApp.contentUpload(user_idx, udid, title, content, busTag, isNotice), HandlerDef(this, "controllers.ProtoApp", "contentUpload", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:35
case controllers_Application_replyUpload12(params) => {
   call(params.fromQuery[String]("user_idx", None), params.fromQuery[String]("udid", None), params.fromQuery[String]("content_idx", None), params.fromQuery[String]("content", None)) { (user_idx, udid, content_idx, content) =>
        invokeHandler(_root_.controllers.Application.replyUpload(user_idx, udid, content_idx, content), HandlerDef(this, "controllers.Application", "replyUpload", Seq(classOf[String], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:36
case controllers_ProtoApp_replyUpload13(params) => {
   call(params.fromPath[String]("user_idx", None), params.fromPath[String]("udid", None), params.fromPath[String]("content_idx", None), params.fromPath[String]("content", None)) { (user_idx, udid, content_idx, content) =>
        invokeHandler(_root_.controllers.ProtoApp.replyUpload(user_idx, udid, content_idx, content), HandlerDef(this, "controllers.ProtoApp", "replyUpload", Seq(classOf[String], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:40
case controllers_Application_profileUpload14(params) => {
   call(params.fromQuery[String]("user_idx", None), params.fromQuery[String]("udid", None), params.fromQuery[String]("nickname", None), params.fromQuery[String]("gender", None), params.fromQuery[String]("memo", None)) { (user_idx, udid, nickname, gender, memo) =>
        invokeHandler(_root_.controllers.Application.profileUpload(user_idx, udid, nickname, gender, memo), HandlerDef(this, "controllers.Application", "profileUpload", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:41
case controllers_ProtoApp_profileUpload15(params) => {
   call(params.fromPath[String]("user_idx", None), params.fromPath[String]("udid", None), params.fromPath[String]("nickname", None), params.fromPath[String]("gender", None), params.fromPath[String]("memo", None)) { (user_idx, udid, nickname, gender, memo) =>
        invokeHandler(_root_.controllers.ProtoApp.profileUpload(user_idx, udid, nickname, gender, memo), HandlerDef(this, "controllers.ProtoApp", "profileUpload", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:47
case controllers_Application_recommand16(params) => {
   call(params.fromQuery[String]("user_idx", None), params.fromQuery[String]("udid", None), params.fromQuery[String]("content_idx", None)) { (user_idx, udid, content_idx) =>
        invokeHandler(_root_.controllers.Application.recommand(user_idx, udid, content_idx), HandlerDef(this, "controllers.Application", "recommand", Seq(classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:50
case controllers_Application_contentUpdate17(params) => {
   call(params.fromQuery[String]("user_idx", None), params.fromQuery[String]("udid", None), params.fromQuery[String]("title", None), params.fromQuery[String]("content", None), params.fromQuery[String]("busTag", None), params.fromQuery[String]("isNotice", None)) { (user_idx, udid, title, content, busTag, isNotice) =>
        invokeHandler(_root_.controllers.Application.contentUpdate(user_idx, udid, title, content, busTag, isNotice), HandlerDef(this, "controllers.Application", "contentUpdate", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:51
case controllers_ProtoApp_contentUpdate18(params) => {
   call(params.fromQuery[String]("user_idx", None), params.fromQuery[String]("udid", None), params.fromQuery[String]("title", None), params.fromQuery[String]("content", None), params.fromQuery[String]("busTag", None), params.fromQuery[String]("isNotice", None)) { (user_idx, udid, title, content, busTag, isNotice) =>
        invokeHandler(_root_.controllers.ProtoApp.contentUpdate(user_idx, udid, title, content, busTag, isNotice), HandlerDef(this, "controllers.ProtoApp", "contentUpdate", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:57
case controllers_Application_replyDelete19(params) => {
   call(params.fromQuery[String]("user_idx", None), params.fromQuery[String]("udid", None), params.fromQuery[String]("content_idx", None), params.fromQuery[String]("reDate", None)) { (user_idx, udid, content_idx, reDate) =>
        invokeHandler(_root_.controllers.Application.replyDelete(user_idx, udid, content_idx, reDate), HandlerDef(this, "controllers.Application", "replyDelete", Seq(classOf[String], classOf[String], classOf[String], classOf[String])))
   }
}
                    
}
    
}
                