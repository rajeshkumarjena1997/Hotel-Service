package com.Hotel.Service.Exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String s) {
		super(s);
	}

	public ResourceNotFoundException() {
		super("Resource not found");
	}
}
