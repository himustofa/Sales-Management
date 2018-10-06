package com.mk.tag;

import java.io.IOException;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectTag extends SimpleTagSupport {
	 private String name;
	 private String cssClass;
	 private Map<String,String> list;
	 private String value;
	 private String emptyValue;
	 private String onChange;
	 private String disabled;


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


	public Map<String, String> getList() {
		return list;
	}


	public void setList(Map<String, String> list) {
		this.list = list;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

	public String getEmptyValue() {
		return emptyValue;
	}


	public void setEmptyValue(String emptyValue) {
		this.emptyValue = emptyValue;
	}

	 
	 public String getOnChange() {
		return onChange;
	}


	public void setOnChange(String onChange) {
		this.onChange = onChange;
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

		    
		    str +="<select id=\"" + this.getName() + "\" name=\"" + this.getName() + "\"";
		    		    
		    str += " class=\"form-control sync-option-text"  ;
		    if (this.getCssClass() != null) {
		    	str += " " + this.getCssClass() ;
			}
		    
		    if (this.getOnChange()!=null && !this.getOnChange().isEmpty()) {
		    	str += " \" onchange=\""+ this.getOnChange() ;
			}
		    
		    if (this.getDisabled()!=null && !this.getDisabled().isEmpty()) {
		    	str += " \" disabled=\""+ this.getDisabled() ;
			}
		    
		    str += "\"  >";
		    String selectedValue = "";
		    if (this.getValue() != null && !this.getValue().isEmpty()) {
		    	selectedValue = this.getValue() ;
			}
		    

		    if (this.getEmptyValue() != null && !this.getEmptyValue().isEmpty()) {
		    	str += "<option value=\"-1\">";
			    str += this.getEmptyValue() + "</option>";
		    	
			}
		    
		    
		    if(this.getList() != null && !this.getList().isEmpty()){
		    	Map<String, String> list = this.getList();
				for (Map.Entry<String, String> entry : list.entrySet()) {
				    String code = entry.getKey().toString();
				    String name = entry.getValue();
				    
				    str += "<option value=\"" + code + "\"";
				    if(code.equals(selectedValue)){
				    	str +=" selected";
				    }
				    str += ">" + name + "</option>";
				}
		    	
		    }
		    

		    str +="</select>";
		   
		    out.print(str);

	 }
	}