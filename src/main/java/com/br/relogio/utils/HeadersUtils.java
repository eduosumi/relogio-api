package com.br.relogio.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class HeadersUtils {

	private static final String CONTENT_TYPE = "Content-Type";
	private static final String ACCEPT = "Accept";
	
	public static HttpHeaders createDefaultHeaders() {
		
		HttpHeaders header = new HttpHeaders();
		header.set(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		header.set(ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		return header;
	}
	
}
