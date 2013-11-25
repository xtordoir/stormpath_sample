package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import global.Global

// case classes to represent login and Signup forms
case class Login(email: String, password: String)
case class Signup(firstname: String, lastname: String, email: String, password: String)

// Anything related to account management...
object Account extends Controller {
 
  // login form 
  val loginForm = Form(
    mapping(
      "email" -> email,
      "password" -> text.verifying(nonEmpty)
    )(Login.apply)(Login.unapply)
  )

  // signup form, with some validation...
  val signupForm = Form(
    mapping(
      "firstname" -> text.verifying(nonEmpty),
      "lastname"  -> text.verifying(nonEmpty),
      "email"     -> email,
      "password" -> tuple(
          "main" -> text(minLength=4, maxLength=16),
            "confirm" -> text
      ).verifying(
            // Add an additional constraint: both passwords must match
            "Passwords don't match", password => password._1 == password._2
      ).transform(
      	{case (main, confirm) => main },
      	(main: String) => ("", "")
      )
    )
    (Signup.apply)(Signup.unapply)
    )


  // login page view action
	def login = Action { implicit request =>
    	Ok(views.html.login())
  }

  // logout action
  def logout = Action { implicit request =>
		Redirect(routes.Application.index).withNewSession.flashing(
    	"success" -> "You've been logged out"
   	)
 	}

  // authentication action (POST login form)
  def authenticate = Action { implicit request => 

    loginForm.bindFromRequest.fold(
     	// binding failure, you retrieve the form containing errors,
     	formWithErrors => {
       	val flash = new Flash( Map[String, String]("error" -> "Incorrect email password combination."))
         	BadRequest(views.html.login(Some(formWithErrors))(flash))
       },
      // binding success, you get the actual value 
     	value => {
     		try {
       		import com.stormpath.sdk.authc._
         	val request = new UsernamePasswordRequest(value.email,value.password)
       		val result = Global.app.authenticateAccount(request)

          // from the result instance we get the authenticated Account
          val account = result.getAccount()

          // we put the email in the session as username
          Redirect(routes.Application.index).withSession("email" -> account.getEmail).flashing("success" -> "Login successful") 
        } catch {
        	case e: Exception => {
    		    val flash = new Flash( Map[String, String]("error" -> e.getMessage))
            BadRequest(views.html.login(Some(loginForm))(flash)).flashing("error" -> e.getMessage)
        	}
        }
      }
    )
  }

  // sign-up page action
 	def signup = Action { implicit request =>
   	Ok(views.html.signup(signupForm))
 	}

  // sign-up action (POST signup FORM)
 	def doSignup = Action {implicit request =>
  	signupForm.bindFromRequest.fold(
   		formWithErrors => {
 	    	BadRequest(views.html.signup(formWithErrors))
   		},
   		signup => {
     		val account = Global.client.getDataStore().instantiate(classOf[com.stormpath.sdk.account.Account]);
     		account.setGivenName(signup.firstname);
     		account.setSurname(signup.lastname);
     		account.setUsername(signup.email);
     		account.setEmail(signup.email); 
     		account.setMiddleName("");
     		account.setPassword(signup.password);
     		try {
     			Global.directory.createAccount(account)
     			Redirect(routes.Application.index).flashing("success" -> "Please check your email (including spam folders) to confirm your account creation.")
     		} catch {
     			case e: Exception => {
           	val flash = new Flash( Map[String, String]("error" -> e.getMessage))
   		    	BadRequest(views.html.signup(signupForm)(flash)).flashing("error" -> e.getMessage)
     			}
     		}         
   		}
   	) 
 	}

  // verify email address token
 	def verify(sptoken: String) = Action { implicit request =>
 		try {
   		val tenant = Global.client.getCurrentTenant()
   		val account = tenant.verifyAccountEmail(sptoken)
   		Redirect(routes.Application.index).flashing("success" -> "Your account is now activated, and you can login.")
   	} catch {
     	case e: Exception => {
     		Redirect(routes.Application.index).flashing("error" -> "This token is invalid, either it timed out or the account is already activated. If you cannot login, please contact the support.")
     	}
   	}
  }
}