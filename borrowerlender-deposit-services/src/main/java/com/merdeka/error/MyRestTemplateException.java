package com.merdeka.error;

import org.springframework.http.HttpStatus;

public class MyRestTemplateException extends RuntimeException {
	
	 	private String api;
	  private HttpStatus statusCode;
	  private String error;

	  public MyRestTemplateException(HttpStatus statusCode, String error) {
	    super(error);
	    this.statusCode = statusCode;
	    this.error = error;
	  }

}
