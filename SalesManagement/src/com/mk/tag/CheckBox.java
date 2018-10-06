package com.mk.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CheckBox extends SimpleTagSupport {
	private String name;
	private String cssClass;
	private String value;
	private String label;
	private String color;
	private String disabled;

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
	// {!! Form::checkbox('ec_member', 1, $emp->ec_member, array('id' =>
	// 'ec_member')) !!}
	// {!! Form::label('ec_member', 'EC Member' , array('class' =>
	// 'control-label')) !!}

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		String str = "";
		str += "<div class=\"";
		if (this.getColor() != null) {
			if (!this.getColor().isEmpty()) {
				str += "clip-check check-" + this.getColor() + "\">";
			} else {
				str += "clip-check check-primary\">";
			}
		} else {
			str += "clip-check check-primary\">";
		}

		str += " <input type=\"checkbox\" id=\"" + this.getName() + "\"";
		str += " name=\"" + this.getName() + "\"";

		if (this.getValue() != null) {

			if (!this.getValue().isEmpty()) {

				if (this.getValue().equals("true") || this.getValue().equals("1")) {
					str += " checked ";
				}

			}

		}
		if (this.getDisabled()!= null) {

			if (!this.getDisabled().isEmpty()) {

				if (this.getDisabled().equals("true")) {
				
					str += " disabled=\"disabled\" ";
				}
				

			}

		}
		str += " class=\"";
		if (this.getCssClass() != null) {
			str += " " + this.getCssClass();
		}
		str += "\">";

		if (this.getLabel() != null && !this.getLabel().isEmpty()) {
			str += "<label class=\"control-label\" for=\"" + this.getName() + "\" >" + this.getLabel() + "</label>";
		} else {
			str += "<label class=\"control-label\" for=\"" + this.getName() + "\" ></label>";
		}
		str += "<input type=\"hidden\"  name=\"ch_" + this.getName() + "\"";

		if (this.getValue() != null) {
			if (!this.getValue().isEmpty()) {
				if (this.getValue().equals("true") || this.getValue().equals("1")) {
					str += " value=\"true\"/>";
				} else {
					str += " value=\"false\"/>";
				}
			} else {
				str += " value=\"false\"/>";
			}
		} else {
			str += " value=\"false\"/>";
		}
		
		str += "<script>";
		str += "InitHandlers(); ";
		str += "$(\"[name='" + this.getName() + "'\").on(\"click\",function(){";
		str += "if( $(this).prop(\"checked\") == true){";
		str += "$(this).closest(\".clip-check\").find(\"input[type='hidden']\").val(\"true\");";
		str += "}else{";
		str += "$(this).closest(\".clip-check\").find(\"input[type='hidden']\").val(\"false\");}});";
		str += "</script>";		

		str += "</div>";
		
		out.println(str);
	}
}