package com.stefanini.desafio.rest.exceptions;

public class NegocioException extends Exception {

	private static final long serialVersionUID = 1L;

	public NegocioException(final String msg) {
		super(msg);
	}

	public NegocioException(final Throwable t) {
		super(t);
	}

	public NegocioException(final String msg, final Throwable t) {
		super(msg, t);
	}

}
