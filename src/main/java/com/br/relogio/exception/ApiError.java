package com.br.relogio.exception;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import io.swagger.annotations.ApiModelProperty;

public class ApiError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Data e hora do erro", example = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	public LocalDateTime timestamp;
	
	@ApiModelProperty(value = "Exceção lançada", example = "\"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'\"")
	
	public String exception;
	@ApiModelProperty(value = "Lista de mensagens de erro", example = "[ { \"Requisição inválida.\" } ] ")
	
	public List<String> messages;
	
	@ApiModelProperty(value = "Path da chamada que ocasionou o erro", example = "\\path")
	public String path;

	public ApiError(LocalDateTime timestamp, List<String> messages, String exception, String path) {
		this.timestamp = timestamp;
		this.exception = exception;
		this.messages = messages;
		this.path = path;
	}
	
	
	
}