// @SOURCE:/Users/mac/projects/play/stormpath_sample/conf/routes
// @HASH:c3542403c0cad89720aa917e44b09b9dc7b26cc8
// @DATE:Mon Nov 25 11:17:52 CET 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:20
// @LINE:16
// @LINE:14
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
package controllers {

// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def secured(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "secured")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:20
class ReverseAssets {
    

// @LINE:20
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:16
// @LINE:14
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseAccount {
    

// @LINE:13
def signup(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "signup")
}
                                                

// @LINE:9
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:16
def verify(sptoken:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "account/verify" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("sptoken", sptoken)))))
}
                                                

// @LINE:11
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:14
def doSignup(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "signup")
}
                                                

// @LINE:10
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          
}
                  


// @LINE:20
// @LINE:16
// @LINE:14
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def secured : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.secured",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "secured"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:20
class ReverseAssets {
    

// @LINE:20
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:16
// @LINE:14
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseAccount {
    

// @LINE:13
def signup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Account.signup",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        

// @LINE:9
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Account.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:16
def verify : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Account.verify",
   """
      function(sptoken) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "account/verify" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("sptoken", sptoken)])})
      }
   """
)
                        

// @LINE:11
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Account.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:14
def doSignup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Account.doSignup",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        

// @LINE:10
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Account.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:20
// @LINE:16
// @LINE:14
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def secured(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.secured(), HandlerDef(this, "controllers.Application", "secured", Seq(), "GET", """""", _prefix + """secured""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:20
class ReverseAssets {
    

// @LINE:20
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:16
// @LINE:14
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseAccount {
    

// @LINE:13
def signup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Account.signup(), HandlerDef(this, "controllers.Account", "signup", Seq(), "GET", """""", _prefix + """signup""")
)
                      

// @LINE:9
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Account.login(), HandlerDef(this, "controllers.Account", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      

// @LINE:16
def verify(sptoken:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Account.verify(sptoken), HandlerDef(this, "controllers.Account", "verify", Seq(classOf[String]), "GET", """""", _prefix + """account/verify""")
)
                      

// @LINE:11
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Account.logout(), HandlerDef(this, "controllers.Account", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:14
def doSignup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Account.doSignup(), HandlerDef(this, "controllers.Account", "doSignup", Seq(), "POST", """""", _prefix + """signup""")
)
                      

// @LINE:10
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Account.authenticate(), HandlerDef(this, "controllers.Account", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      
    
}
                          
}
                  
      