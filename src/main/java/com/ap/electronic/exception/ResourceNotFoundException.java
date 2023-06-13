package com.ap.electronic.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException() {
		super("Resource not found");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	

}
