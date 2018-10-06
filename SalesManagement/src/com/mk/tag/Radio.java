package com.mk.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Radio extends SimpleTagSupport {
	private String name;
	private String cssClass;
	private String value;
	private String label;
	private String id;
	private String checked;
	private String disabled;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		String str = "";


		str += " <input type=\"radio\" id=\"" + this.getId() + "\"";
		str += " name=\"" + this.getName() + "\"";

		if (this.getValue() != null) {

			if (!this.getValue().isEmpty()) {
				str += " value=\"" + this.getValue() + "\"";
			}

		}
		str += " class=\"";
		if (this.getCssClass() != null) {
			str += this.getCssClass();
		}
		
		str += "\"";
		if (this.getDisabled() != null) {
			str += " disabled=\"" + this.getDisabled() + "\"";
		}
		
		str += "\"";
		if (this.getChecked() != null && !this.getChecked().isEmpty() && this.getChecked().equals(this.getValue())) {
			str += " checked=\"checked\"";
		}
		str += " />";

		if (this.getLabel() != null && !this.getLabel().isEmpty()) {
			str += "<label class=\"control-label\" for=\"" + this.getId() + "\" >" + this.getLabel() + "</label>";
		} else {
			str += "<label class=\"control-label\" for=\"" + this.getId() + "\" ></label>";
		}
		out.print(str);
	}
}