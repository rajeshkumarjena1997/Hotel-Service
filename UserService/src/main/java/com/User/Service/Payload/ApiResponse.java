package com.User.Service.Payload;

import org.springframework.http.HttpStatus;

public class ApiResponse {
	private String message;
	private boolean success;
	private HttpStatus status;

	// Constructors
	public ApiResponse() {
	}

	public ApiResponse(String message, boolean success, HttpStatus status) {
		this.message = message;
		this.success = success;
		this.status = status;
	}

	// Getter and Setter methods
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	// Builder class
	public static ApiResponseBuilder builder() {
		return new ApiResponseBuilder();
	}

	// Builder class
	public static class ApiResponseBuilder {
		private String message;
		private boolean success;
		private HttpStatus status;

		private ApiResponseBuilder() {
		}

		public ApiResponseBuilder message(String message) {
			this.message = message;
			return this;
		}

		public ApiResponseBuilder success(boolean success) {
			this.success = success;
			return this;
		}

		public ApiResponseBuilder status(HttpStatus status) {
			this.status = status;
			return this;
		}

		public ApiResponse build() {
			return new ApiResponse(message, success, status);
		}
	}

}
