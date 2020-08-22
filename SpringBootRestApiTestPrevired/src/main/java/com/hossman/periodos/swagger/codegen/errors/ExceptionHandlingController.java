package com.hossman.periodos.swagger.codegen.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hossman.periodos.swagger.codegen.exception.ApiException;
import com.hossman.periodos.swagger.codegen.responses.ApiResponseMessage;

//@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {
	
	/* H.E Aca se deberia manejar los builders de mensajes y las respuesta de error*/
	
	@ExceptionHandler({ApiException.class})
	public ResponseEntity<Object> handleApiException(ApiException ex, WebRequest request){
		//LOG.error(ex.getMessage(),ex);
		/* H.E  El codigo http debiese venir codificado en la exception */
		return new ResponseEntity<>( new ApiResponseMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
 
}
