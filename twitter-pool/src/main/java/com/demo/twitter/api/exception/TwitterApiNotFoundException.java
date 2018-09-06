package com.demo.twitter.api.exception;

public class TwitterApiNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TwitterApiNotFoundException(String message) {
		super(message);
	}
	
	public TwitterApiNotFoundException(String message, Throwable e) {
		super(message, e);
	}
}