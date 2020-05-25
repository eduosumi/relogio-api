package com.br.relogio.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class WebException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mensagem;
	
	private HttpStatus status;
	
	public WebException(HttpStatus status, String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
		this.status = status;
	}
	
	public static void checkThrow(boolean expressao, ExceptionMessageEnum exceptionMessageEnum) {
		if(Boolean.TRUE.equals(expressao)) {
			throw new WebException(exceptionMessageEnum.getStatus(), exceptionMessageEnum.getMensagem());
		}
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
}
