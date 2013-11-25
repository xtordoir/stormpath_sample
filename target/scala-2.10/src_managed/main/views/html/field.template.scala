
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
object field extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[helper.FieldElements,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(elements: helper.FieldElements):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.34*/("""

<div class="control-group">
	<label class="control-label" for=""""),_display_(Seq[Any](/*4.37*/elements/*4.45*/.id)),format.raw/*4.48*/("""">"""),_display_(Seq[Any](/*4.51*/elements/*4.59*/.label)),format.raw/*4.65*/("""</label>
	<div class="controls">
		"""),_display_(Seq[Any](/*6.4*/elements/*6.12*/.input)),format.raw/*6.18*/("""
		<span style="color: #FF0000">"""),_display_(Seq[Any](/*7.33*/elements/*7.41*/.errors.mkString(", "))),format.raw/*7.63*/("""</span>
	</div>
</div>
"""))}
    }
    
    def render(elements:helper.FieldElements): play.api.templates.Html = apply(elements)
    
    def f:((helper.FieldElements) => play.api.templates.Html) = (elements) => apply(elements)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Nov 21 21:17:36 CET 2013
                    SOURCE: /Users/mac/projects/play/stormpath_sample/app/views/field.scala.html
                    HASH: 0a17a9853c29044d042d7ab4a0f31b7d28427eb9
                    MATRIX: 519->1|628->33|729->99|745->107|769->110|807->113|823->121|850->127|920->163|936->171|963->177|1031->210|1047->218|1090->240
                    LINES: 19->1|22->1|25->4|25->4|25->4|25->4|25->4|25->4|27->6|27->6|27->6|28->7|28->7|28->7
                    -- GENERATED --
                */
            