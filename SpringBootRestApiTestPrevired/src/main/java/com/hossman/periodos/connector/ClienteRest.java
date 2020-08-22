package com.hossman.periodos.connector;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hossman.periodos.swagger.codegen.constants.ApiConstants;
import com.hossman.periodos.swagger.codegen.exception.ApiException;
import com.hossman.periodos.swagger.codegen.exception.ClienteRestException;
import com.hossman.periodos.swagger.codegen.model.Periodo;

import org.apache.commons.lang3.StringUtils;

public class ClienteRest {

	Logger log = LoggerFactory.getLogger(ClienteRest.class);

	private Environment env;

	public ClienteRest(Environment env) {
		this.env = env;
	}

	/**
	 * @author Hossman Escobar (H.E)
	 * Conector Simple Para Una ApiRest externa.
	 * @param tipoMetodoHttp = tipoMetodo http a invocar.
	 * @param nombreApiConectar = nombre de la api con la que se va a conectar.
	 *     * 
	 * @throws ApiException */
	public ResponseEntity<String> conectorApiRestExterna(HttpMethod tipoMetodoHttp, String nombreApiConectar) throws ClienteRestException {


		String uri = "";

		if(validaPropiedades(nombreApiConectar)) {
			uri = generardorUri(nombreApiConectar);
		
		} else {
			throw new ClienteRestException( "Api no configurada");  
		}

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		//Podría implementar un null-patern object
		ResponseEntity<String> result = new ResponseEntity<String>(StringUtils.EMPTY, HttpStatus.SERVICE_UNAVAILABLE);	

		try {
			log.info("Conectandose a: " +  uri);
			result = restTemplate.exchange(uri, tipoMetodoHttp, entity, String.class); 			
		} catch (Exception e) {
			throw new ClienteRestException("Error al conectarse al servicio de periodos externo",e);  
		}

		return result;

	}

	
	/** @author Hossman Escobar (H.E).
      @param nombreApiConsumir = nombre de la api que queremos validar las propiedades, distintas apis podrian tener otros properties, o se pueden querer incoporar mas validaciones. **/	
	private boolean validaPropiedades(String nomberApiValidar) {

		/* H.E Filtro cada una de las properties, para que no vuelva a desarrollo la incidencia y producción pueda configurar */
		if(nomberApiValidar.equals(ApiConstants.API_PERIOD)) {
			if(StringUtils.isEmpty(env.getProperty(ApiConstants.SERVER))) { /* H.E No se utilizan valores por defecto, para no generar compartimientos automaticos */
				log.error("No esta definida la propiedad " + ApiConstants.SERVER + "en el archivo aplication.properties");
				return false;  
			} else if (StringUtils.isEmpty(env.getProperty(ApiConstants.PORT)))  {
				log.error("No esta definida la propiedad " + ApiConstants.PORT +" en el archivo aplication.properties");
				return false;  
			}                	
			else if(StringUtils.isEmpty(env.getProperty(ApiConstants.RESOURCE))) {
				log.error("No esta definida la propiedad" + ApiConstants.RESOURCE +" en el archivo aplication.properties");
				return false;  
			}  		
		}
		return true;
	}

	private String generardorUri(final String nomberApiValidar) {

	
		String uriStr = "";
		if(nomberApiValidar.equals(ApiConstants.API_PERIOD)) {
			/*H.E Stringbuffer por que tiene mejor perfomance, PD: se que para 3 variables es despreciable */
			StringBuffer uri = new StringBuffer();
			uri.append(env.getProperty(ApiConstants.SERVER)).
			append(env.getProperty(ApiConstants.PORT)).
			append(env.getProperty(ApiConstants.RESOURCE));
			return uri.toString();

		}
		return uriStr;
	}
}
