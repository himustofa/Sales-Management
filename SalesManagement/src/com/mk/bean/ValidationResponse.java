package com.mk.bean;

public class ValidationResponse {
	private String outcome;
	private String message;
	private String[] data;
	
	

	public ValidationResponse(String outcome, String message, String[] data) {
		super();
		this.outcome = outcome;
		this.message = message;
		this.data = data;
	}

	public ValidationResponse() {
		super();
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getData() {
		return data;
	}
	
	public String getStringData() {
		for (int i = 0; i < data.length; i++) {
			return data[i]+",";
		}
		return message;
		
	}

	public void setData(String[] data) {
		this.data = data;
	}

	public WSResponse toWsResponse(){		
		WSResponse wsResponse = new WSResponse();
		wsResponse.setOutcome(this.outcome);
		wsResponse.setData(this.data);
		return wsResponse;		
	}

}
