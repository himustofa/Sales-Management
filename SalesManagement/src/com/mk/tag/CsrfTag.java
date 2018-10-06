package com.mk.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CsrfTag extends SimpleTagSupport {
	private String type;
	private String name;
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void doTag() throws JspException, IOException {

		JspWriter out = getJspContext().getOut();
		String str = "";
		str = " <input type=\"" + this.getType() + "\"";
		str += " name=\"" + this.getName() + "\"";
		str += " value=\"" + this.getValue() + "\">";
		
		out.println(str);
	}
}