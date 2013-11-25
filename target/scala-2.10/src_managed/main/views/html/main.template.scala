
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Boolean,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(isLogged: Boolean)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.51*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png"))),format.raw/*9.97*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*10.74*/("""" type="text/javascript"></script>
    </head>
    <body>
    	<p><a href="/">Home</a>&nbsp;<a href="/secured">Secured pagee</a></p>
        """),_display_(Seq[Any](/*14.10*/content)),format.raw/*14.17*/("""
    </body>
</html>
"""))}
    }
    
    def render(title:String,isLogged:Boolean,content:Html): play.api.templates.Html = apply(title)(isLogged)(content)
    
    def f:((String) => (Boolean) => (Html) => play.api.templates.Html) = (title) => (isLogged) => (content) => apply(title)(isLogged)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 25 11:20:01 CET 2013
                    SOURCE: /Users/mac/projects/play/stormpath_sample/app/views/main.scala.html
                    HASH: 765bd049e5657afa2a9c0ba55561efdf50954d50
                    MATRIX: 517->1|643->50|731->103|757->108|854->170|868->176|923->210|1019->271|1033->277|1086->309|1147->334|1162->340|1229->385|1407->527|1436->534
                    LINES: 19->1|22->1|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|35->14|35->14
                    -- GENERATED --
                */
            