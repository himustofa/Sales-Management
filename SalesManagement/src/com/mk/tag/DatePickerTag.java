package com.mk.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DatePickerTag extends SimpleTagSupport {
	 private String name;
	 private String cssClass;
	 private String value;
	 private String label;
	 private String readonly;
	 
	  public String getCssClass() {
		return cssClass;
	}

	public String getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	public void doTag() throws JspException, IOException {
	    JspWriter out = getJspContext().getOut();
	    String str = "";

	    str=" <input type=\"text\" id=\"" + this.getName() + "\"";
	    str += " name=\"" + this.getName() + "\"";
	    if (this.getValue()!=null && !this.getValue().isEmpty()) {
	    	str += " value=\"" + this.getValue() + "\"";
		}else{
			str += " value=\"\"";
		}
	    str += " class=\"form-control datepicker "  ;
	    if (this.getCssClass()!=null && !this.getCssClass().isEmpty()) {
	    	str += " " + this.getCssClass() ;
		}
	    str += "\"/>";

	   		
		 out.print("<label for=\"" + this.getName() + "\" class=\"control-label \">"+this.getLabel()+"</label>");
	    out.print(str);
	  }
	
	}