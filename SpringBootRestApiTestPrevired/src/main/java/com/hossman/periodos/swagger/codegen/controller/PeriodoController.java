package com.hossman.periodos.swagger.codegen.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hossman.periodos.service.PeriodosService;
import com.hossman.periodos.swagger.codegen.exception.ApiException;
import com.hossman.periodos.swagger.codegen.exception.ServiceException;
import com.hossman.periodos.swagger.codegen.model.Periodo;
import com.hossman.periodos.swagger.codegen.responses.ApiResponseMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class PeriodoController implements PeriodosApi {

	@Autowired
	PeriodosService periodoService; 

	@Autowired
	private Environment env;

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public PeriodoController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public Optional<ObjectMapper> getObjectMapper() {
		return Optional.ofNullable(objectMapper);
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	/**
	 * @author Hossman Escobar (H.E)
	 * Metodo REST expuesto
	 *     * 
	 * @throws Exception */
	@CrossOrigin // Para ser llamada por IBM Api Connect
	@Override
	public ResponseEntity<Periodo> getPeriodos() throws ApiException {	
		if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) { 
				try {
					return new ResponseEntity<Periodo>(periodoService.getPeriodosExternos(objectMapper,env), HttpStatus.OK);	
				} catch (ServiceException e) {
					log.error(e.getMessage(),e);
					//Se gatilla el handler de spring pero se recomienda hacer un propio handler 
					throw new ApiException(ApiResponseMessage.ERROR, "El micro-servicio de periodos falló ",e);   
				}		
			}
		}
		else {
			log.warn("ObjectMapper or HttpServletRequest not configured in default DefaultApi interface so no example is generated");
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
}
