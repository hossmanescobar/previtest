package com.hossman.periodos.swagger.codegen.exception;

public class ClienteRestException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteRestException (String msg) {
		super(msg);
	}
	public ClienteRestException (String msg, Throwable t) {
		super(msg,t);
	}
}


