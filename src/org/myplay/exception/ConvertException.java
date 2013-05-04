package org.myplay.exception;

public class ConvertException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	private String description;

	public ConvertException() {
	}

	public ConvertException(String message) {
		this.message = message;
		this.description = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
