package com.mk.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LabelTag extends SimpleTagSupport {
	private String name;
	private String labelFor;

	private String cssClass;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabelFor() {
		return labelFor;
	}

	public void setLabelFor(String labelFor) {
		this.labelFor = labelFor;
	}


	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		String str = "";

		if (this.getLabelFor() != null && !this.getLabelFor().isEmpty()) {
			str += "<label for=\"" + this.getLabelFor() + "\"";
		} else {
			str += " for=\"\"";
		}
		str += " class=\"control-label";
		if (this.getCssClass() != null && !this.getCssClass().isEmpty()) {
			str += " " + this.getCssClass();
		}
		str += "\">";
		str += this.getName() + "</label>";
		
		out.println(str);
	}
}