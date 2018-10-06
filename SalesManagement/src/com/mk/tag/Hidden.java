package com.mk.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Hidden extends SimpleTagSupport {
	 private String name;
	 private String value;
	 private String cssClass;
	 
	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
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

	    str +=" <input type=\"hidden\"";
		if (this.getName() != null && !this.getName().isEmpty()) {
			str += " id=\"" + this.getName() + "\"";
			str += " name=\"" + this.getName() + "\"";
		}
	    if (this.getValue()!=null && !this.getValue().isEmpty()) {
	    	str += " value=\"" + this.getValue() + "\"";
		}else{
			str += " value=\"\"";
		}
	    str += " class=\"form-control"  ;
	    if (this.getCssClass()!=null && !this.getCssClass().isEmpty()) {
	    	str += " " + this.getCssClass() ;
		}
	    str += "\"/>";
	    out.println(str);
	  }
	}