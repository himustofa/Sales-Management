package com.mk.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ModalTag extends TagSupport{
	
	private String modalId;
	private String modalTitle;

	public String getModalTitle() {
		return modalTitle;
	}
	public void setModalTitle(String modalTitle) {
		this.modalTitle = modalTitle;
	}

	public String getModalId() {
		return modalId;
	}
	public void setModalId(String modalId) {
		this.modalId = modalId;
	}
	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();
		StringBuffer str = new StringBuffer("");
		
		str.append(" <div class=\"modal\" id=\""+this.modalId+"\" role=\"dialog\" aria-labelledby=\"suiteModal\" aria-hidden=\"true\" style=\"display:none;\">")
			.append("<div class=\"wrap-content\"><div class=\"modal-dialog modal-lg\" style=\"background-color: #00ff00;\">")
			.append("<div class=\"modal-content\"><div class=\"modal-header\"><button type=\"button\" class=\"close\" id=\"btnModalclose\">")
			.append("<span class=\"fa fa-close text-red\"></span></button>")
			.append("<h4 class=\"modal-title\">"+this.modalTitle+"</h4>")
			.append("</div><div class=\"modal-body\"><div class=\"alert alert-block alert-danger alert-modal hidden\"></div>");		

			try {
				out.print(str.toString());
			} catch (IOException e) {
				throw new JspException(e.toString());
			}

		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {

		JspWriter out = pageContext.getOut();
		String str = "</div></div></div></div></div>";
		try {
			out.print(str);
		} catch (IOException e) {
			throw new JspException(e.toString());
		}

		return EVAL_PAGE;
	}

}
