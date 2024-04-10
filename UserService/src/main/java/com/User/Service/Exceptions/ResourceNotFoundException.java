package com.User.Service.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException() {
        super("Resourse not found Exception");
	}
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
