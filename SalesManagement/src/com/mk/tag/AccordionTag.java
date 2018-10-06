package com.mk.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class AccordionTag extends TagSupport {
	
	private String acrId;
	private String panelClass;
	private String panelDataId;
	private String heading;
	
	public String getAcrId() {
		return acrId;
	}
	public void setAcrId(String acrId) {
		this.acrId = acrId;
	}
	public String getPanelClass() {
		return panelClass;
	}
	public void setPanelClass(String panelClass) {
		this.panelClass = panelClass;
	}
	public String getPanelDataId() {
		return panelDataId;
	}
	public void setPanelDataId(String panelDataId) {
		this.panelDataId = panelDataId;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}

	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();
		StringBuffer str = new StringBuffer("");
		str.append(" <div id=\""+this.acrId+"\" class=\"panel-group accordion\">")
			.append("<div class=\"panel panel-light-grey"+((this.panelClass != null && !this.panelClass.isEmpty())?" "+this.panelClass:"")+"\"")
			.append((this.panelDataId != null && !this.panelDataId.isEmpty())?" data-id=\""+this.panelDataId+"\">":">")
			.append("<div class=\"panel-heading\">")
			.append("<h5 class=\"panel-title\">")
			.append("<a class=\"accordion-toggle bold\" data-toggle=\"collapse\" data-parent=\"#accordion\" href=\""+"#"+this.panelClass+this.panelDataId+"\" aria-expanded=\"true\">")
			.append("<i class=\"icon-arrow\"></i>")
			.append("<span class=\""+this.panelClass+"-title\">"+this.heading+"</span></a>")
			.append("</h5>")
			.append("</div>")
			.append("<div id=\""+this.panelClass+this.panelDataId+"\" class=\"panel-collapse collapse in\" aria-expanded=\"true\" style=\"\">")
			.append("<div class=\"panel-body\">");		

			try {
				out.print(str.toString());
			} catch (IOException e) {
				throw new JspException(e.toString());
			}

		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {

		JspWriter out = pageContext.getOut();
		String str = "</div></div></div></div>";
		try {
			out.print(str);
		} catch (IOException e) {
			throw new JspException(e.toString());
		}

		return EVAL_PAGE;
	}
}
