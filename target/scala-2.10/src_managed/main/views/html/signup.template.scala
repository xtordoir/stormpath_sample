
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
object signup extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Signup],Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(signupForm: Form[Signup])(implicit flash: Flash):play.api.templates.Html = {
        _display_ {import views.html.helper._

implicit def /*3.2*/implicitField/*3.15*/ = {{ FieldConstructor(field.f) }};
Seq[Any](format.raw/*1.51*/("""
"""),format.raw/*3.48*/("""

"""),_display_(Seq[Any](/*5.2*/main("Signup")/*5.16*/(false)/*5.23*/ {_display_(Seq[Any](format.raw/*5.25*/("""
  
  <form method="POST">
    <h2>Sign up!</h2>
    """),_display_(Seq[Any](/*9.6*/flash/*9.11*/.get("error").map/*9.28*/ { msg =>_display_(Seq[Any](format.raw/*9.37*/("""
        <div style="color: #FF0000">"""),_display_(Seq[Any](/*10.38*/msg)),format.raw/*10.41*/("""</div>
    """)))})),format.raw/*11.6*/("""
    """),_display_(Seq[Any](/*12.6*/inputText(signupForm("firstname"), '_label -> "Firstname"))),format.raw/*12.64*/("""
    """),_display_(Seq[Any](/*13.6*/inputText(signupForm("lastname"), '_label -> "Lastname"))),format.raw/*13.62*/("""
    """),_display_(Seq[Any](/*14.6*/inputText(signupForm("email"), '_label -> "email"))),format.raw/*14.56*/("""
    """),_display_(Seq[Any](/*15.6*/if(signupForm.errors("password"))/*15.39*/ {_display_(Seq[Any](format.raw/*15.41*/("""
    	<div style="color: #FF0000">"""),_display_(Seq[Any](/*16.35*/signupForm/*16.45*/.errors("password").head.message)),format.raw/*16.77*/("""</div>
    """)))})),format.raw/*17.6*/("""
    """),_display_(Seq[Any](/*18.6*/inputPassword(signupForm("password.main"), '_label -> "Password"))),format.raw/*18.71*/("""
    """),_display_(Seq[Any](/*19.6*/inputPassword(signupForm("password.confirm"), '_label -> "Confirm password"))),format.raw/*19.82*/("""
		<button type="submit">Sign up</button>
    <button type="reset">cancel</button>
  </form>
  <p><a href="/login">login</a></p>
""")))})))}
    }
    
    def render(signupForm:Form[Signup],flash:Flash): play.api.templates.Html = apply(signupForm)(flash)
    
    def f:((Form[Signup]) => (Flash) => play.api.templates.Html) = (signupForm) => (flash) => apply(signupForm)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Nov 21 21:34:43 CET 2013
                    SOURCE: /Users/mac/projects/play/stormpath_sample/app/views/signup.scala.html
                    HASH: 6771e42ee286b7ad9e572457bfa2e5490f1755a0
                    MATRIX: 518->1|663->80|684->93|747->50|775->126|812->129|834->143|849->150|888->152|976->206|989->211|1014->228|1060->237|1134->275|1159->278|1202->290|1243->296|1323->354|1364->360|1442->416|1483->422|1555->472|1596->478|1638->511|1678->513|1749->548|1768->558|1822->590|1865->602|1906->608|1993->673|2034->679|2132->755
                    LINES: 19->1|22->3|22->3|23->1|24->3|26->5|26->5|26->5|26->5|30->9|30->9|30->9|30->9|31->10|31->10|32->11|33->12|33->12|34->13|34->13|35->14|35->14|36->15|36->15|36->15|37->16|37->16|37->16|38->17|39->18|39->18|40->19|40->19
                    -- GENERATED --
                */
            