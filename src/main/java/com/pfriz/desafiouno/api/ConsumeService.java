package com.pfriz.desafiouno.api;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pfriz.desafiouno.model.Periodo;
import com.pfriz.desafiouno.model.PeriodoIn;

public class ConsumeService {

	private String url = "http://localhost";
	private String urlPort8080 = ":8080";
	private String urlPort8090 = ":8090";
	private String urlService = "/periodos/api";
	
	
	public Periodo consumePeriodosApi() {
		RestTemplate restTemplate = new RestTemplate();
		//Servicio restapi a consumir, levantado previamente en el puerto 8080
		String urlAConsumir = url + urlPort8080 + urlService;
		
		// Se modifica el campo accept de la cabecera para que reciba de forma correcta la peticion
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType("application", "json")));
		  
		// Se genera mediante un restTemplate.exchage la peticion con lo parametros,
		// y recibe la respuesta en nuestra clase de parametros
		ResponseEntity<Periodo> response = restTemplate.exchange(
				urlAConsumir, 
				HttpMethod.GET, 
				new HttpEntity<Object>(headers),
				Periodo.class);
		
		System.out.print(response.getStatusCode());
		
		return response.getBody();
	}
	
	public PeriodoIn consumePeriodosApiIn () {
		RestTemplate restTemplate = new RestTemplate();
		//Servicio restapi a consumir, levantado previamente en el puerto 8080
		String urlAConsumir = url + urlPort8080 + urlService;
		
		// Se modifica el campo accept de la cabecera para que reciba de forma correcta la peticion
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType("application", "json")));
		  
		// Se genera mediante un restTemplate.exchage la peticion con lo parametros,
		// y recibe la respuesta en nuestra clase de parametros
		ResponseEntity<PeriodoIn> response = restTemplate.exchange(
				urlAConsumir, 
				HttpMethod.GET, 
				new HttpEntity<Object>(headers),
				PeriodoIn.class);
		
		System.out.print(response.getStatusCode());
		
		return response.getBody();
	}
	

}
