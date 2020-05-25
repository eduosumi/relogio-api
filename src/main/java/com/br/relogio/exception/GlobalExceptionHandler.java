package com.br.relogio.exception;

import static java.util.Collections.singletonList;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler({ WebException.class })
	public ResponseEntity<ApiError> handleNotFoundCustom(HttpServletRequest request, WebException ex) {
		return ResponseEntity.status(ex.getStatus()).body(buildErrorInfo(request, ex, singletonList(ex.getMessage())));
	}

	private ApiError buildErrorInfo(HttpServletRequest request, Exception exceptionCdt, List<String> messages) {
		return new ApiError(LocalDateTime.now(), messages, exceptionCdt.getClass().getSimpleName(),
				request.getRequestURI());
	}
}
