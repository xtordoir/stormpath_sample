// @SOURCE:/Users/mac/projects/play/stormpath_sample/conf/routes
// @HASH:c3542403c0cad89720aa917e44b09b9dc7b26cc8
// @DATE:Mon Nov 25 11:17:52 CET 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_secured1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("secured"))))
        

// @LINE:9
private[this] lazy val controllers_Account_login2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:10
private[this] lazy val controllers_Account_authenticate3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:11
private[this] lazy val controllers_Account_logout4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:13
private[this] lazy val controllers_Account_signup5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
        

// @LINE:14
private[this] lazy val controllers_Account_doSignup6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
        

// @LINE:16
private[this] lazy val controllers_Account_verify7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("account/verify"))))
        

// @LINE:20
private[this] lazy val controllers_Assets_at8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """secured""","""controllers.Application.secured"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Account.login"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Account.authenticate"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Account.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.Account.signup"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.Account.doSignup"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """account/verify""","""controllers.Account.verify(sptoken:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_secured1(params) => {
   call { 
        invokeHandler(controllers.Application.secured, HandlerDef(this, "controllers.Application", "secured", Nil,"GET", """""", Routes.prefix + """secured"""))
   }
}
        

// @LINE:9
case controllers_Account_login2(params) => {
   call { 
        invokeHandler(controllers.Account.login, HandlerDef(this, "controllers.Account", "login", Nil,"GET", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:10
case controllers_Account_authenticate3(params) => {
   call { 
        invokeHandler(controllers.Account.authenticate, HandlerDef(this, "controllers.Account", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:11
case controllers_Account_logout4(params) => {
   call { 
        invokeHandler(controllers.Account.logout, HandlerDef(this, "controllers.Account", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:13
case controllers_Account_signup5(params) => {
   call { 
        invokeHandler(controllers.Account.signup, HandlerDef(this, "controllers.Account", "signup", Nil,"GET", """""", Routes.prefix + """signup"""))
   }
}
        

// @LINE:14
case controllers_Account_doSignup6(params) => {
   call { 
        invokeHandler(controllers.Account.doSignup, HandlerDef(this, "controllers.Account", "doSignup", Nil,"POST", """""", Routes.prefix + """signup"""))
   }
}
        

// @LINE:16
case controllers_Account_verify7(params) => {
   call(params.fromQuery[String]("sptoken", None)) { (sptoken) =>
        invokeHandler(controllers.Account.verify(sptoken), HandlerDef(this, "controllers.Account", "verify", Seq(classOf[String]),"GET", """""", Routes.prefix + """account/verify"""))
   }
}
        

// @LINE:20
case controllers_Assets_at8(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        