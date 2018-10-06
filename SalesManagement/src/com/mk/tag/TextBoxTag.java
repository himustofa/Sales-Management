package com.mk.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TextBoxTag extends SimpleTagSupport {
	private String name;
	private String cssClass;
	private String value;
	private String label;
	private String readonly;
	private String onclick;
	private String onchange;
	private String style;
	private String maxlength;
	private String placeHolder;
	private String title;
	private String pattern;

	
	public String getMaxlength() {
		return maxlength;
	}
	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}
	public String getReadonly() {
		return readonly;
	}
	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getLabel() {
		return label;
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

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getPlaceHolder() {
		return placeHolder;
	}
	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPattern() {
		return pattern;
	}
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	public void doTag() throws JspException, IOException {
	    JspWriter out = getJspContext().getOut();
	    String str = "";

	    str = " <input type=\"text\" id=\"" + this.getName() + "\"";
	    str += " name=\"" + this.getName() + "\"";
	    if (this.getValue()!=null && !this.getValue().isEmpty()) {
	    	str += " value=\"" + this.getValue() + "\"";
		}else{
			str += " value=\"\"";
		}
	    if (this.getMaxlength()!=null && !this.getMaxlength().isEmpty()) {
	    	str += " maxlength=\"" + this.getMaxlength() + "\"";
		}else{
			str += " maxlength=\"\"";
		}
	    str += " class=\"form-control"  ;
	    if (this.getCssClass()!=null && !this.getCssClass().isEmpty()) {
	    	str += " " + this.getCssClass() ;
		}
	    str += "\"";
	    if (this.getReadonly()!=null && !this.getReadonly().isEmpty()) {
	    	str += " Readonly =\"" + this.getReadonly() ;
		}
	    str += "\"";
	    if (this.getStyle()!=null && !this.getStyle().isEmpty()) {
	    	str += " style =\"" + this.getStyle() ;
		}
	    str += "\"";
	    if (this.getPlaceHolder()!=null && !this.getPlaceHolder().isEmpty()) {
	    	str += " placeholder =\"" + this.getPlaceHolder() ;
		}
	    str += "\"";
	    if (this.getTitle()!=null && !this.getTitle().isEmpty()) {
	    	str += " title =\"" + this.getTitle() ;
		}
	    str += "\"";
	    if (this.getPattern()!=null && !this.getPattern().isEmpty()) {
	    	str += " pattern =\"" + this.getPattern() ;
		}
	    str += "\"";
	    if (this.getOnclick()!=null && !this.getOnclick().isEmpty()) {
	    	str += " onclick =\"" + this.getOnclick() ;
		}
	    str += "\"";
	    if (this.getOnchange()!=null && !this.getOnchange().isEmpty()) {
	    	str += " onchange =\"" + this.getOnchange() ;
		}
	    str += "\" />";
	    out.println(str);
	  }
	
	}