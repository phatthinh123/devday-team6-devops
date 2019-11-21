package com.axonactive.devdayapp.exception;

public class InvalidUsernamePasswordException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidUsernamePasswordException(String msg) {
		super(msg);
	}

	public InvalidUsernamePasswordException(String msg, Throwable t) {
		super(msg, t);
	}
}
