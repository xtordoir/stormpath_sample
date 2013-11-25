package controllers

import play.api._
import play.api.mvc._

object Application extends Controller with Secured {
  
  // index page
  def index = Action { implicit request =>    
    Ok(views.html.index("Welcome")(isLogged))
  }

  def secured = IsAuthenticated { username => implicit request =>     
      Ok(views.html.secured("Secured page")(isLogged))
  }

}