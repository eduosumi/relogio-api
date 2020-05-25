package com.br.relogio.exception;

import org.springframework.http.HttpStatus;

public enum ExceptionMessageEnum {

	USUARIO_NAO_ENCONTRADO(HttpStatus.NOT_FOUND, "Relogio nao encontrado"),
	ERRO_INESPERADO_DO_SISTEMA(HttpStatus.INTERNAL_SERVER_ERROR, "Erro inesperado do sistema, favor entre em contato com o administrador");
	
	private HttpStatus status;
	
	private String mensagem;
	
	ExceptionMessageEnum(HttpStatus status, String mensagem) {
		this.status = status;
		this.mensagem = mensagem;
	}
	
	public void raise() throws WebException {
		throw new WebException(status, mensagem);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMensagem() {
		return mensagem;
	}
	
}
