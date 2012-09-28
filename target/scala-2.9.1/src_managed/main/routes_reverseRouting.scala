// @SOURCE:/Users/rupy1014/Documents/workspace_play/thinkingBus/conf/routes
// @HASH:25321af0ffe54b0b37abc79f4822d1978315ac5a
// @DATE:Fri Sep 28 19:50:46 KST 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:57
// @LINE:51
// @LINE:50
// @LINE:47
// @LINE:41
// @LINE:40
// @LINE:36
// @LINE:35
// @LINE:32
// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:24
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:12
// @LINE:9
// @LINE:6
package controllers {

// @LINE:51
// @LINE:41
// @LINE:36
// @LINE:32
// @LINE:28
// @LINE:21
// @LINE:17
// @LINE:12
class ReverseProtoApp {
    


 
// @LINE:17
def checkUpdate(user_idx:String, udid:String, ver:String) = {
   Call("GET", "/checkUpdate/" + implicitly[PathBindable[String]].unbind("user_idx", user_idx) + "/" + implicitly[PathBindable[String]].unbind("udid", udid) + "/" + implicitly[PathBindable[String]].unbind("ver", ver))
}
                                                        
 
// @LINE:41
def profileUpload(user_idx:String, udid:String, nickname:String, gender:String, memo:String) = {
   Call("GET", "/profileUpload/" + implicitly[PathBindable[String]].unbind("user_idx", user_idx) + "/" + implicitly[PathBindable[String]].unbind("udid", udid) + "/" + implicitly[PathBindable[String]].unbind("nickname", nickname) + "/" + implicitly[PathBindable[String]].unbind("gender", gender) + "/" + implicitly[PathBindable[String]].unbind("memo", memo))
}
                                                        
 
// @LINE:12
def urlUpdate(user_idx:String, ver:String, url:String) = {
   Call("GET", "/urlUpdate/" + implicitly[PathBindable[String]].unbind("user_idx", user_idx) + "/" + implicitly[PathBindable[String]].unbind("ver", ver) + "/" + implicitly[PathBindable[String]].unbind("url", url))
}
                                                        
 
// @LINE:28
def contentReplies(user_idx:String, udid:String, content_idx:String, laReDate:String, rSize:String) = {
   Call("GET", "/contentReplies/" + implicitly[PathBindable[String]].unbind("user_idx", user_idx) + "/" + implicitly[PathBindable[String]].unbind("udid", udid) + "/" + implicitly[PathBindable[String]].unbind("content_idx", content_idx) + "/" + implicitly[PathBindable[String]].unbind("laReDate", laReDate) + "/" + implicitly[PathBindable[String]].unbind("rSize", rSize))
}
                                                        
 
// @LINE:36
def replyUpload(user_idx:String, udid:String, content_idx:String, content:String) = {
   Call("GET", "/replyUpload/" + implicitly[PathBindable[String]].unbind("user_idx", user_idx) + "/" + implicitly[PathBindable[String]].unbind("udid", udid) + "/" + implicitly[PathBindable[String]].unbind("content_idx", content_idx) + "/" + implicitly[PathBindable[String]].unbind("content", content))
}
                                                        
 
// @LINE:21
def contentList(user_idx:String, udid:String, content_idx:String, pSize:String) = {
   Call("GET", "/contentList/" + implicitly[PathBindable[String]].unbind("user_idx", user_idx) + "/" + implicitly[PathBindable[String]].unbind("udid", udid) + "/" + implicitly[PathBindable[String]].unbind("content_idx", content_idx) + "/" + implicitly[PathBindable[String]].unbind("pSize", pSize))
}
                                                        
 
// @LINE:51
def contentUpdate(user_idx:String, udid:String, title:String, content:String, busTag:String, isNotice:String) = {
   Call("GET", "/contentUpdate" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("user_idx", user_idx)), Some(implicitly[QueryStringBindable[String]].unbind("udid", udid)), Some(implicitly[QueryStringBindable[String]].unbind("title", title)), Some(implicitly[QueryStringBindable[String]].unbind("content", content)), Some(implicitly[QueryStringBindable[String]].unbind("busTag", busTag)), Some(implicitly[QueryStringBindable[String]].unbind("isNotice", isNotice)))))
}
                                                        
 
// @LINE:32
def contentUpload(user_idx:String, udid:String, title:String, content:String, busTag:String, isNotice:String) = {
   Call("GET", "/contentUpload/" + implicitly[PathBindable[String]].unbind("user_idx", user_idx) + "/" + implicitly[PathBindable[String]].unbind("udid", udid) + "/" + implicitly[PathBindable[String]].unbind("title", title) + "/" + implicitly[PathBindable[String]].unbind("content", content) + "/" + implicitly[PathBindable[String]].unbind("busTag", busTag) + "/" + implicitly[PathBindable[String]].unbind("isNotice", isNotice))
}
                                                        

                      
    
}
                            

// @LINE:57
// @LINE:50
// @LINE:47
// @LINE:40
// @LINE:35
// @LINE:31
// @LINE:27
// @LINE:24
// @LINE:20
// @LINE:16
// @LINE:6
class ReverseApplication {
    


 
// @LINE:16
def checkUpdate() = {
   Call("POST", "/checkUpdate")
}
                                                        
 
// @LINE:57
def replyDelete(user_idx:String, udid:String, content_idx:String, reDate:String) = {
   Call("POST", "/replyDelete" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("user_idx", user_idx)), Some(implicitly[QueryStringBindable[String]].unbind("udid", udid)), Some(implicitly[QueryStringBindable[String]].unbind("content_idx", content_idx)), Some(implicitly[QueryStringBindable[String]].unbind("reDate", reDate)))))
}
                                                        
 
// @LINE:40
def profileUpload(user_idx:String, udid:String, nickname:String, gender:String, memo:String) = {
   Call("POST", "/profileUpload" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("user_idx", user_idx)), Some(implicitly[QueryStringBindable[String]].unbind("udid", udid)), Some(implicitly[QueryStringBindable[String]].unbind("nickname", nickname)), Some(implicitly[QueryStringBindable[String]].unbind("gender", gender)), Some(implicitly[QueryStringBindable[String]].unbind("memo", memo)))))
}
                                                        
 
// @LINE:47
def recommand(user_idx:String, udid:String, content_idx:String) = {
   Call("POST", "/recommand" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("user_idx", user_idx)), Some(implicitly[QueryStringBindable[String]].unbind("udid", udid)), Some(implicitly[QueryStringBindable[String]].unbind("content_idx", content_idx)))))
}
                                                        
 
// @LINE:27
def contentReplies(user_idx:String, udid:String, content_idx:String, laReDate:String, rSize:String) = {
   Call("POST", "/contentReplies" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("user_idx", user_idx)), Some(implicitly[QueryStringBindable[String]].unbind("udid", udid)), Some(implicitly[QueryStringBindable[String]].unbind("content_idx", content_idx)), Some(implicitly[QueryStringBindable[String]].unbind("laReDate", laReDate)), Some(implicitly[QueryStringBindable[String]].unbind("rSize", rSize)))))
}
                                                        
 
// @LINE:35
def replyUpload(user_idx:String, udid:String, content_idx:String, content:String) = {
   Call("POST", "/replyUpload" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("user_idx", user_idx)), Some(implicitly[QueryStringBindable[String]].unbind("udid", udid)), Some(implicitly[QueryStringBindable[String]].unbind("content_idx", content_idx)), Some(implicitly[QueryStringBindable[String]].unbind("content", content)))))
}
                                                        
 
// @LINE:20
def contentList(user_idx:String, udid:String, content_idx:String, pSize:String) = {
   Call("POST", "/contentList" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("user_idx", user_idx)), Some(implicitly[QueryStringBindable[String]].unbind("udid", udid)), Some(implicitly[QueryStringBindable[String]].unbind("content_idx", content_idx)), Some(implicitly[QueryStringBindable[String]].unbind("pSize", pSize)))))
}
                                                        
 
// @LINE:50
def contentUpdate(user_idx:String, udid:String, title:String, content:String, busTag:String, isNotice:String) = {
   Call("POST", "/contentUpdate" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("user_idx", user_idx)), Some(implicitly[QueryStringBindable[String]].unbind("udid", udid)), Some(implicitly[QueryStringBindable[String]].unbind("title", title)), Some(implicitly[QueryStringBindable[String]].unbind("content", content)), Some(implicitly[QueryStringBindable[String]].unbind("busTag", busTag)), Some(implicitly[QueryStringBindable[String]].unbind("isNotice", isNotice)))))
}
                                                        
 
// @LINE:6
def index() = {
   Call("GET", "/")
}
                                                        
 
// @LINE:24
def contentDetail(user_idx:String, udid:String, content_idx:String) = {
   Call("POST", "/contentDetail" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("user_idx", user_idx)), Some(implicitly[QueryStringBindable[String]].unbind("udid", udid)), Some(implicitly[QueryStringBindable[String]].unbind("content_idx", content_idx)))))
}
                                                        
 
// @LINE:31
def contentUpload(user_idx:String, udid:String, title:String, content:String, busTag:String, isNotice:String) = {
   Call("POST", "/contentUpload" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("user_idx", user_idx)), Some(implicitly[QueryStringBindable[String]].unbind("udid", udid)), Some(implicitly[QueryStringBindable[String]].unbind("title", title)), Some(implicitly[QueryStringBindable[String]].unbind("content", content)), Some(implicitly[QueryStringBindable[String]].unbind("busTag", busTag)), Some(implicitly[QueryStringBindable[String]].unbind("isNotice", isNotice)))))
}
                                                        

                      
    
}
                            

// @LINE:9
class ReverseAssets {
    


 
// @LINE:9
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            
}
                    


// @LINE:57
// @LINE:51
// @LINE:50
// @LINE:47
// @LINE:41
// @LINE:40
// @LINE:36
// @LINE:35
// @LINE:32
// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:24
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:51
// @LINE:41
// @LINE:36
// @LINE:32
// @LINE:28
// @LINE:21
// @LINE:17
// @LINE:12
class ReverseProtoApp {
    


 
// @LINE:17
def checkUpdate = JavascriptReverseRoute(
   "controllers.ProtoApp.checkUpdate",
   """
      function(user_idx,udid,ver) {
      return _wA({method:"GET", url:"/checkUpdate/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("user_idx", user_idx) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("udid", udid) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ver", ver)})
      }
   """
)
                                                        
 
// @LINE:41
def profileUpload = JavascriptReverseRoute(
   "controllers.ProtoApp.profileUpload",
   """
      function(user_idx,udid,nickname,gender,memo) {
      return _wA({method:"GET", url:"/profileUpload/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("user_idx", user_idx) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("udid", udid) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("nickname", nickname) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("gender", gender) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("memo", memo)})
      }
   """
)
                                                        
 
// @LINE:12
def urlUpdate = JavascriptReverseRoute(
   "controllers.ProtoApp.urlUpdate",
   """
      function(user_idx,ver,url) {
      return _wA({method:"GET", url:"/urlUpdate/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("user_idx", user_idx) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("ver", ver) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("url", url)})
      }
   """
)
                                                        
 
// @LINE:28
def contentReplies = JavascriptReverseRoute(
   "controllers.ProtoApp.contentReplies",
   """
      function(user_idx,udid,content_idx,laReDate,rSize) {
      return _wA({method:"GET", url:"/contentReplies/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("user_idx", user_idx) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("udid", udid) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("content_idx", content_idx) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("laReDate", laReDate) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("rSize", rSize)})
      }
   """
)
                                                        
 
// @LINE:36
def replyUpload = JavascriptReverseRoute(
   "controllers.ProtoApp.replyUpload",
   """
      function(user_idx,udid,content_idx,content) {
      return _wA({method:"GET", url:"/replyUpload/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("user_idx", user_idx) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("udid", udid) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("content_idx", content_idx) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("content", content)})
      }
   """
)
                                                        
 
// @LINE:21
def contentList = JavascriptReverseRoute(
   "controllers.ProtoApp.contentList",
   """
      function(user_idx,udid,content_idx,pSize) {
      return _wA({method:"GET", url:"/contentList/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("user_idx", user_idx) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("udid", udid) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("content_idx", content_idx) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("pSize", pSize)})
      }
   """
)
                                                        
 
// @LINE:51
def contentUpdate = JavascriptReverseRoute(
   "controllers.ProtoApp.contentUpdate",
   """
      function(user_idx,udid,title,content,busTag,isNotice) {
      return _wA({method:"GET", url:"/contentUpdate" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("user_idx", user_idx), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("udid", udid), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("title", title), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("content", content), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("busTag", busTag), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("isNotice", isNotice)])})
      }
   """
)
                                                        
 
// @LINE:32
def contentUpload = JavascriptReverseRoute(
   "controllers.ProtoApp.contentUpload",
   """
      function(user_idx,udid,title,content,busTag,isNotice) {
      return _wA({method:"GET", url:"/contentUpload/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("user_idx", user_idx) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("udid", udid) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("title", title) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("content", content) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("busTag", busTag) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("isNotice", isNotice)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:57
// @LINE:50
// @LINE:47
// @LINE:40
// @LINE:35
// @LINE:31
// @LINE:27
// @LINE:24
// @LINE:20
// @LINE:16
// @LINE:6
class ReverseApplication {
    


 
// @LINE:16
def checkUpdate = JavascriptReverseRoute(
   "controllers.Application.checkUpdate",
   """
      function() {
      return _wA({method:"POST", url:"/checkUpdate"})
      }
   """
)
                                                        
 
// @LINE:57
def replyDelete = JavascriptReverseRoute(
   "controllers.Application.replyDelete",
   """
      function(user_idx,udid,content_idx,reDate) {
      return _wA({method:"POST", url:"/replyDelete" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("user_idx", user_idx), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("udid", udid), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("content_idx", content_idx), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("reDate", reDate)])})
      }
   """
)
                                                        
 
// @LINE:40
def profileUpload = JavascriptReverseRoute(
   "controllers.Application.profileUpload",
   """
      function(user_idx,udid,nickname,gender,memo) {
      return _wA({method:"POST", url:"/profileUpload" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("user_idx", user_idx), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("udid", udid), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("nickname", nickname), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("gender", gender), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("memo", memo)])})
      }
   """
)
                                                        
 
// @LINE:47
def recommand = JavascriptReverseRoute(
   "controllers.Application.recommand",
   """
      function(user_idx,udid,content_idx) {
      return _wA({method:"POST", url:"/recommand" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("user_idx", user_idx), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("udid", udid), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("content_idx", content_idx)])})
      }
   """
)
                                                        
 
// @LINE:27
def contentReplies = JavascriptReverseRoute(
   "controllers.Application.contentReplies",
   """
      function(user_idx,udid,content_idx,laReDate,rSize) {
      return _wA({method:"POST", url:"/contentReplies" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("user_idx", user_idx), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("udid", udid), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("content_idx", content_idx), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("laReDate", laReDate), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("rSize", rSize)])})
      }
   """
)
                                                        
 
// @LINE:35
def replyUpload = JavascriptReverseRoute(
   "controllers.Application.replyUpload",
   """
      function(user_idx,udid,content_idx,content) {
      return _wA({method:"POST", url:"/replyUpload" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("user_idx", user_idx), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("udid", udid), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("content_idx", content_idx), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("content", content)])})
      }
   """
)
                                                        
 
// @LINE:20
def contentList = JavascriptReverseRoute(
   "controllers.Application.contentList",
   """
      function(user_idx,udid,content_idx,pSize) {
      return _wA({method:"POST", url:"/contentList" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("user_idx", user_idx), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("udid", udid), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("content_idx", content_idx), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("pSize", pSize)])})
      }
   """
)
                                                        
 
// @LINE:50
def contentUpdate = JavascriptReverseRoute(
   "controllers.Application.contentUpdate",
   """
      function(user_idx,udid,title,content,busTag,isNotice) {
      return _wA({method:"POST", url:"/contentUpdate" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("user_idx", user_idx), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("udid", udid), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("title", title), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("content", content), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("busTag", busTag), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("isNotice", isNotice)])})
      }
   """
)
                                                        
 
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"/"})
      }
   """
)
                                                        
 
// @LINE:24
def contentDetail = JavascriptReverseRoute(
   "controllers.Application.contentDetail",
   """
      function(user_idx,udid,content_idx) {
      return _wA({method:"POST", url:"/contentDetail" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("user_idx", user_idx), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("udid", udid), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("content_idx", content_idx)])})
      }
   """
)
                                                        
 
// @LINE:31
def contentUpload = JavascriptReverseRoute(
   "controllers.Application.contentUpload",
   """
      function(user_idx,udid,title,content,busTag,isNotice) {
      return _wA({method:"POST", url:"/contentUpload" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("user_idx", user_idx), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("udid", udid), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("title", title), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("content", content), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("busTag", busTag), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("isNotice", isNotice)])})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:9
class ReverseAssets {
    


 
// @LINE:9
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:57
// @LINE:51
// @LINE:50
// @LINE:47
// @LINE:41
// @LINE:40
// @LINE:36
// @LINE:35
// @LINE:32
// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:24
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.ref {

// @LINE:51
// @LINE:41
// @LINE:36
// @LINE:32
// @LINE:28
// @LINE:21
// @LINE:17
// @LINE:12
class ReverseProtoApp {
    


 
// @LINE:17
def checkUpdate(user_idx:String, udid:String, ver:String) = new play.api.mvc.HandlerRef(
   controllers.ProtoApp.checkUpdate(user_idx, udid, ver), HandlerDef(this, "controllers.ProtoApp", "checkUpdate", Seq(classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:41
def profileUpload(user_idx:String, udid:String, nickname:String, gender:String, memo:String) = new play.api.mvc.HandlerRef(
   controllers.ProtoApp.profileUpload(user_idx, udid, nickname, gender, memo), HandlerDef(this, "controllers.ProtoApp", "profileUpload", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:12
def urlUpdate(user_idx:String, ver:String, url:String) = new play.api.mvc.HandlerRef(
   controllers.ProtoApp.urlUpdate(user_idx, ver, url), HandlerDef(this, "controllers.ProtoApp", "urlUpdate", Seq(classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:28
def contentReplies(user_idx:String, udid:String, content_idx:String, laReDate:String, rSize:String) = new play.api.mvc.HandlerRef(
   controllers.ProtoApp.contentReplies(user_idx, udid, content_idx, laReDate, rSize), HandlerDef(this, "controllers.ProtoApp", "contentReplies", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:36
def replyUpload(user_idx:String, udid:String, content_idx:String, content:String) = new play.api.mvc.HandlerRef(
   controllers.ProtoApp.replyUpload(user_idx, udid, content_idx, content), HandlerDef(this, "controllers.ProtoApp", "replyUpload", Seq(classOf[String], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:21
def contentList(user_idx:String, udid:String, content_idx:String, pSize:String) = new play.api.mvc.HandlerRef(
   controllers.ProtoApp.contentList(user_idx, udid, content_idx, pSize), HandlerDef(this, "controllers.ProtoApp", "contentList", Seq(classOf[String], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:51
def contentUpdate(user_idx:String, udid:String, title:String, content:String, busTag:String, isNotice:String) = new play.api.mvc.HandlerRef(
   controllers.ProtoApp.contentUpdate(user_idx, udid, title, content, busTag, isNotice), HandlerDef(this, "controllers.ProtoApp", "contentUpdate", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:32
def contentUpload(user_idx:String, udid:String, title:String, content:String, busTag:String, isNotice:String) = new play.api.mvc.HandlerRef(
   controllers.ProtoApp.contentUpload(user_idx, udid, title, content, busTag, isNotice), HandlerDef(this, "controllers.ProtoApp", "contentUpload", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]))
)
                              

                      
    
}
                            

// @LINE:57
// @LINE:50
// @LINE:47
// @LINE:40
// @LINE:35
// @LINE:31
// @LINE:27
// @LINE:24
// @LINE:20
// @LINE:16
// @LINE:6
class ReverseApplication {
    


 
// @LINE:16
def checkUpdate() = new play.api.mvc.HandlerRef(
   controllers.Application.checkUpdate(), HandlerDef(this, "controllers.Application", "checkUpdate", Seq())
)
                              
 
// @LINE:57
def replyDelete(user_idx:String, udid:String, content_idx:String, reDate:String) = new play.api.mvc.HandlerRef(
   controllers.Application.replyDelete(user_idx, udid, content_idx, reDate), HandlerDef(this, "controllers.Application", "replyDelete", Seq(classOf[String], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:40
def profileUpload(user_idx:String, udid:String, nickname:String, gender:String, memo:String) = new play.api.mvc.HandlerRef(
   controllers.Application.profileUpload(user_idx, udid, nickname, gender, memo), HandlerDef(this, "controllers.Application", "profileUpload", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:47
def recommand(user_idx:String, udid:String, content_idx:String) = new play.api.mvc.HandlerRef(
   controllers.Application.recommand(user_idx, udid, content_idx), HandlerDef(this, "controllers.Application", "recommand", Seq(classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:27
def contentReplies(user_idx:String, udid:String, content_idx:String, laReDate:String, rSize:String) = new play.api.mvc.HandlerRef(
   controllers.Application.contentReplies(user_idx, udid, content_idx, laReDate, rSize), HandlerDef(this, "controllers.Application", "contentReplies", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:35
def replyUpload(user_idx:String, udid:String, content_idx:String, content:String) = new play.api.mvc.HandlerRef(
   controllers.Application.replyUpload(user_idx, udid, content_idx, content), HandlerDef(this, "controllers.Application", "replyUpload", Seq(classOf[String], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:20
def contentList(user_idx:String, udid:String, content_idx:String, pSize:String) = new play.api.mvc.HandlerRef(
   controllers.Application.contentList(user_idx, udid, content_idx, pSize), HandlerDef(this, "controllers.Application", "contentList", Seq(classOf[String], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:50
def contentUpdate(user_idx:String, udid:String, title:String, content:String, busTag:String, isNotice:String) = new play.api.mvc.HandlerRef(
   controllers.Application.contentUpdate(user_idx, udid, title, content, busTag, isNotice), HandlerDef(this, "controllers.Application", "contentUpdate", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              
 
// @LINE:24
def contentDetail(user_idx:String, udid:String, content_idx:String) = new play.api.mvc.HandlerRef(
   controllers.Application.contentDetail(user_idx, udid, content_idx), HandlerDef(this, "controllers.Application", "contentDetail", Seq(classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:31
def contentUpload(user_idx:String, udid:String, title:String, content:String, busTag:String, isNotice:String) = new play.api.mvc.HandlerRef(
   controllers.Application.contentUpload(user_idx, udid, title, content, busTag, isNotice), HandlerDef(this, "controllers.Application", "contentUpload", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]))
)
                              

                      
    
}
                            

// @LINE:9
class ReverseAssets {
    


 
// @LINE:9
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            
}
                    
                