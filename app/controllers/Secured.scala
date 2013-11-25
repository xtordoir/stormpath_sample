package controllers

import play.api._
import play.api.mvc._
import play.api.mvc.Security

import play.api.mvc.BodyParsers._


trait Secured {
  
  /**
   * Retrieve the connected user email from the session
   */
  private def username(request: RequestHeader): Option[String] = request.session.get("email")

  def isLogged(implicit request: RequestHeader): Boolean = request.session.get("email") match {
    case Some(u: String) => true
    case _ => false
  }

  /**
   * Redirect to login if the user in not authorized.
   */
  private def onUnauthorized(request: RequestHeader) = {
    //Results.Ok(views.html.index(""))
    Results.Redirect(routes.Account.login)
  }
  /** 
   * Action for authenticated users.
   */
  def IsAuthenticated(f: => String => Request[AnyContent] => Result) = Security.Authenticated(username, onUnauthorized) { user =>
    Action(request => f(user)(request))
  }
  /*
  * Action for authenticated users with a body parser
  */
  def IsAuthenticated(b: BodyParser[Any] = parse.anyContent)(f: => String => Request[Any] => Result) = {
    Security.Authenticated(username, onUnauthorized) { user =>
    Action(b)(request => f(user)(request))
    }
  }

}
