package com.demo.twitter.api.exception;

public class TwitterApiException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TwitterApiException(String message) {
		super(message);
	}
	
	public TwitterApiException(String message, Throwable e) {
		super(message, e);
	}
}