package edu.mum.estore.rest;

import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RemoteApi {
	protected RestTemplate restTemplate;
	
	public RemoteApi() {
		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	}
	
	public RestTemplate getRestTemplate() {
		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		return restTemplate;
	}

	/*
	*		Set up authentication header
	*		PLUS JSON Accept header
	*/
	public HttpHeaders getHttpHeaders() {

         HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
			return requestHeaders;
	}

	public HttpEntity<?> getHttpEntity() {
		return new HttpEntity(getHttpHeaders());
	}

}
