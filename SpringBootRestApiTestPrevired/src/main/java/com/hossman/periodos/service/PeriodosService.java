package com.hossman.periodos.service;
import org.springframework.core.env.Environment;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hossman.periodos.swagger.codegen.exception.ServiceException;
import com.hossman.periodos.swagger.codegen.model.Periodo;

public interface PeriodosService {
	/**
	 * Envia a calcular las fechas faltantes
	 * **/
	Periodo calculaFechasFaltantes(Periodo periodo);
	/**
	 *Obtiene los periodos desde otro micro-servicio
	 * **/
	Periodo getPeriodosExternos(ObjectMapper objectMapper, Environment env) throws ServiceException;
}
