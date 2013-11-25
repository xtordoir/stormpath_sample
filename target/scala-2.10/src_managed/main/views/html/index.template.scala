
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Boolean,Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(message: String)(isLogged: Boolean)(implicit flash: Flash):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.61*/("""

"""),_display_(Seq[Any](/*3.2*/main("Welcome ...")/*3.21*/(isLogged)/*3.31*/ {_display_(Seq[Any](format.raw/*3.33*/("""
    <h2>welcome to a sample stormpath app</h2>
    """),_display_(Seq[Any](/*5.6*/flash/*5.11*/.get("success").map/*5.30*/ { msg =>_display_(Seq[Any](format.raw/*5.39*/("""
        <div style="color: #00FF00">"""),_display_(Seq[Any](/*6.38*/msg)),format.raw/*6.41*/("""</div>
    """)))})),format.raw/*7.6*/("""
    """),_display_(Seq[Any](/*8.6*/flash/*8.11*/.get("error").map/*8.28*/ { msg =>_display_(Seq[Any](format.raw/*8.37*/("""
        <div style="color: #FF0000">"""),_display_(Seq[Any](/*9.38*/msg)),format.raw/*9.41*/("""</div>
    """)))})),format.raw/*10.6*/("""

    """),_display_(Seq[Any](/*12.6*/if(isLogged)/*12.18*/ {_display_(Seq[Any](format.raw/*12.20*/("""
    	<p>Looks like you are logged !</p>
    	<p><a href="/logout">logout</a></p>
	""")))}/*15.4*/else/*15.9*/{_display_(Seq[Any](format.raw/*15.10*/("""
		<p>Welcome, want to see more?</p>
    	<p><a href="/login">login</a></p>
    	<p><a href="/signup">signup</a></p>
	""")))})),format.raw/*19.3*/("""
""")))})),format.raw/*20.2*/("""
"""))}
    }
    
    def render(message:String,isLogged:Boolean,flash:Flash): play.api.templates.Html = apply(message)(isLogged)(flash)
    
    def f:((String) => (Boolean) => (Flash) => play.api.templates.Html) = (message) => (isLogged) => (flash) => apply(message)(isLogged)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Nov 21 21:24:34 CET 2013
                    SOURCE: /Users/mac/projects/play/stormpath_sample/app/views/index.scala.html
                    HASH: 30b1b6894b6995ae5f97fde331dd711babbf6d6d
                    MATRIX: 519->1|655->60|692->63|719->82|737->92|776->94|863->147|876->152|903->171|949->180|1022->218|1046->221|1088->233|1128->239|1141->244|1166->261|1212->270|1285->308|1309->311|1352->323|1394->330|1415->342|1455->344|1557->429|1569->434|1608->435|1758->554|1791->556
                    LINES: 19->1|22->1|24->3|24->3|24->3|24->3|26->5|26->5|26->5|26->5|27->6|27->6|28->7|29->8|29->8|29->8|29->8|30->9|30->9|31->10|33->12|33->12|33->12|36->15|36->15|36->15|40->19|41->20
                    -- GENERATED --
                */
            