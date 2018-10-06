package com.mk.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TextAreaTag extends SimpleTagSupport {
	 private String name;
	 private String cssClass;
	 private String value;
	 private String rows;
	 private String cols;
	 private String readonly;
	 
	  public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getCols() {
		return cols;
	}

	public void setCols(String cols) {
		this.cols = cols;
	}

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

	    str=" <textarea type=\"text\" id=\"" + this.getName() + "\"";
	    str += " name=\"" + this.getName() + "\"";
	    
	    str += " class=\"form-control"  ;
	    if (this.getCssClass()!=null && !this.getCssClass().isEmpty()) {
	    	str += " " + this.getCssClass() ;
		}
	    str += "\"";
	    if (this.getRows()!=null && !this.getRows().isEmpty()) {
	    	str += " " + this.getRows() ;
		}
	    str += "\"";
	    if (this.getCols()!=null && !this.getCols().isEmpty()) {
	    	str += " " + this.getCols() ;
		}
	    str += "\">";
	    if (this.getValue()!=null && !this.getValue().isEmpty()) {
	    	str +=  this.getValue() +"</textarea>";
		}else{
			 str += "</textarea>";
		}
	   
	    out.println(str);
	  }
	}