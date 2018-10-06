package com.mk.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class AjaxFormTag extends TagSupport {

	private String name;
	private String action;
	private String dataHandler;
	private String cssClass;
	private String formEnctype;
	private String modelAttribute;
	
	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getDataHandler() {
		return dataHandler;
	}

	public void setDataHandler(String dataHandler) {
		this.dataHandler = dataHandler;
	}

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
	
	public String getFormEnctype() {
		return formEnctype;
	}

	public void setFormEnctype(String formEnctype) {
		this.formEnctype = formEnctype;
	}
	
	public String getModelAttribute() {
		return modelAttribute;
	}

	public void setModelAttribute(String modelAttribute) {
		this.modelAttribute = modelAttribute;
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
		
		if (this.getCssClass() != null && !this.getCssClass().isEmpty()) {
			str += " class=\"ajax "+ this.getCssClass()+"\"";
			
		}else{
			str += " class=\"ajax \""; 
		}
		
		//str += " class=\"ajax\"";
		if (this.getDataHandler() != null && !this.getDataHandler().isEmpty()) {
			str += " data-handler=\"" + this.getDataHandler() + "\"";
		}
		
		
		if (this.getFormEnctype() != null && !this.getFormEnctype().isEmpty()) {
			str += " enctype=\"" + this.getFormEnctype() + "\"";
		}
		
		if (this.getModelAttribute() != null && !this.getModelAttribute().isEmpty()) {
			str += " modelAttribute=\"" + this.getModelAttribute() + "\"";
		}
		
		str += " data-validator=\"validate\"";
		str += " action=\"" + this.getAction() + "\">";
		System.out.println(str);
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