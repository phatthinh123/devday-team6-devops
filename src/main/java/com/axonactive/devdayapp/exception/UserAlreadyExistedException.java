package com.axonactive.devdayapp.exception;

public class UserAlreadyExistedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserAlreadyExistedException(String msg) {
		super(msg);
	}

	public UserAlreadyExistedException(String msg, Throwable t) {
		super(msg, t);
	}
}
