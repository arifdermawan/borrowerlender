package com.merdeka.borrowerlenderuserservices.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;


public abstract class BaseResponse {
	
	private Integer httpCode;
	private String message;
	public Integer getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BaseResponse() {
		super();
	} 
	
	
}
