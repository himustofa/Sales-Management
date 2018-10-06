package com.mk.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SubmitTag extends SimpleTagSupport {
	private String name;
	private String spanClass;
	private String cssClass;
	private String onclick;
	private String dAjax;
	private String dHref;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSpanClass() {
		return spanClass;
	}
	public void setSpanClass(String spanClass) {
		this.spanClass = spanClass;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public String getOnclick() {
		return onclick;
	}
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}
	public String getdAjax() {
		return dAjax;
	}
	public void setdAjax(String dAjax) {
		this.dAjax = dAjax;
	}
	public String getdHref() {
		return dHref;
	}
	public void setdHref(String dHref) {
		this.dHref = dHref;
	}
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		String str = "";
		
		str += "<button class=\"btn";
		if (this.getCssClass() != null && !this.getCssClass().isEmpty()) {
			str += " btn-"+this.getCssClass();
		}
		str += "\"";
		
		if(this.getdAjax() !=null && !this.getdAjax().isEmpty()){
			str += " data-ajax = \" " + this.getdAjax() + "\"";
		}
		
		if(this.getdHref() !=null && !this.getdHref().isEmpty()){
			str += " data-ajax = \" " + this.getdHref() + "\"";
		}
		
		if (this.getOnclick() != null && !this.getOnclick().isEmpty()) {
			str += " onclick=\"" + this.getOnclick() + "\"";
		}
		

		
		str += " type=\"submit\">";
		
		if (this.getSpanClass() != null && !this.getSpanClass().isEmpty()) {
			str += "<span class=\"fa ";
			str += "fa-"+ this.getSpanClass();
			str += "\"";
			str += "></span> ";
		} 
		
		if (this.getName() != null && !this.getName().isEmpty()) {

			str += this.getName();

		}
		str += "</button>";
		
		out.println(str);
		
	}
}
