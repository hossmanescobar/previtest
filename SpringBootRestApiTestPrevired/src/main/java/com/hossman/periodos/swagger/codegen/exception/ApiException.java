package com.hossman.periodos.swagger.codegen.exception;

/* Se manejan excpetions a nivel de capa */

public class ApiException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code;
	
    public ApiException (int code, String msg) {
        super(msg);
        this.setCode(code);
    }
   
	public ApiException (int code,String msg, Throwable t) {
		super(msg,t);
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
