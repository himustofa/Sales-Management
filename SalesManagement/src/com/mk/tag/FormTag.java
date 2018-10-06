package com.mk.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class FormTag extends TagSupport {

	private String name;
	private String action;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();
		String str = "";
		str += " <form";
		if (this.getName() != null && !this.getName().isEmpty()) {
			str += " id=\"" + this.getName() + "\"";
			str += " name=\"" + this.getName() + "\"";
		}
		str += " method=\"POST\"";
		str += " action=\"" + this.getAction() + "\">";

		try {
			out.print(str);
		} catch (IOException e) {
			throw new JspException(e.toString());
		}

		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {

		JspWriter out = pageContext.getOut();
		String str = "</form>";
		try {
			out.print(str);
		} catch (IOException e) {
			throw new JspException(e.toString());
		}

		return EVAL_PAGE;
	}

}