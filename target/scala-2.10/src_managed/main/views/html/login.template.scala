
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object login extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Option[Form[Login]],Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(formWithErrors: Option[Form[Login]] = None)(implicit flash: Flash):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.69*/("""

"""),_display_(Seq[Any](/*3.2*/main("Login page")/*3.20*/(false)/*3.27*/ {_display_(Seq[Any](format.raw/*3.29*/("""

<form method="POST">
    <h2>Please log in</h2>
        """),_display_(Seq[Any](/*7.10*/flash/*7.15*/.get("error")/*7.28*/ match/*7.34*/ {/*8.10*/case Some(str: String) =>/*8.35*/ {_display_(Seq[Any](format.raw/*8.37*/("""
       			<div style="color: #FF0000">
        			"""),_display_(Seq[Any](/*10.13*/flash/*10.18*/.get("error").get)),format.raw/*10.35*/("""
				</div>
			""")))}/*13.4*/case ee @ _ =>/*13.18*/ {_display_(Seq[Any](format.raw/*13.20*/("""
 				"""),_display_(Seq[Any](/*14.7*/{println(ee)})),format.raw/*14.20*/("""
        	""")))}})),format.raw/*16.10*/("""
	<input type="text" placeholder="Email address" name="email">
	<input type="password" placeholder="Password" name="password">
	<button type="submit">Log in</button>
	<button type="reset">cancel</button>
</form>

<p><a href="/signup">signup</a></p>
""")))})))}
    }
    
    def render(formWithErrors:Option[Form[Login]],flash:Flash): play.api.templates.Html = apply(formWithErrors)(flash)
    
    def f:((Option[Form[Login]]) => (Flash) => play.api.templates.Html) = (formWithErrors) => (flash) => apply(formWithErrors)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Nov 21 21:17:36 CET 2013
                    SOURCE: /Users/mac/projects/play/stormpath_sample/app/views/login.scala.html
                    HASH: cce8371f0911212603b30b763bcd1c66d2e1271c
                    MATRIX: 524->1|668->68|705->71|731->89|746->96|785->98|879->157|892->162|913->175|927->181|937->193|970->218|1009->220|1097->272|1111->277|1150->294|1184->314|1207->328|1247->330|1289->337|1324->350|1368->371
                    LINES: 19->1|22->1|24->3|24->3|24->3|24->3|28->7|28->7|28->7|28->7|28->8|28->8|28->8|30->10|30->10|30->10|32->13|32->13|32->13|33->14|33->14|34->16
                    -- GENERATED --
                */
            