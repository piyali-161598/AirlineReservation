package com.lti.dto;

public class Status {

	private StatusType status; // success or failure
	private String message;   // show some report

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
