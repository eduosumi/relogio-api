package com.br.relogio.controller;

import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.br.relogio.domain.RelogioRequest;
import com.br.relogio.domain.RelogioResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Gerenciamento dos relógios")
interface RelogioSwagger {

	@ApiOperation(value = "Listar os relogios")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Sucesso", response = RelogioResponse.class)
		, @ApiResponse(code = 500, message = "Erro interno")
	})
	ResponseEntity<Set<RelogioResponse>> listar();
	
	@ApiOperation(value = "Armazenar um relogio")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Criado")
		, @ApiResponse(code = 400, message = "Marca é obrigatorio")
		, @ApiResponse(code = 400, message = "Marca nao existe")
		, @ApiResponse(code = 400, message = "Modelo é obrigatio")
		, @ApiResponse(code = 400, message = "Modelo nao existe")
		, @ApiResponse(code = 400, message = "TipoPulseira é obrigatorio")
		, @ApiResponse(code = 400, message = "TipoPulseira nao existe")
		, @ApiResponse(code = 400, message = "Valor deve ser maior que zero")
		, @ApiResponse(code = 500, message = "Erro interno")
	})
	ResponseEntity<Long> salvar(RelogioRequest relogioPersist);
	
	@ApiOperation(value = "Alterar um relogio")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Criado")
		, @ApiResponse(code = 400, message = "Marca é obrigatorio")
		, @ApiResponse(code = 400, message = "Marca nao existe")
		, @ApiResponse(code = 400, message = "Modelo é obrigatio")
		, @ApiResponse(code = 400, message = "Modelo nao existe")
		, @ApiResponse(code = 400, message = "TipoPulseira é obrigatorio")
		, @ApiResponse(code = 400, message = "TipoPulseira nao existe")
		, @ApiResponse(code = 400, message = "Valor deve ser maior que zero")
		, @ApiResponse(code = 404, message = "Relogio nao encontrado")
		, @ApiResponse(code = 500, message = "Erro interno")
	})
	ResponseEntity<RelogioResponse> alterar(Long id, RelogioRequest relogioRequest);
	
	@ApiOperation(value = "Deleta um relogio")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Criado")
		, @ApiResponse(code = 400, message = "Marca é obrigatorio")
		, @ApiResponse(code = 400, message = "Marca nao existe")
		, @ApiResponse(code = 400, message = "Modelo é obrigatio")
		, @ApiResponse(code = 400, message = "Modelo nao existe")
		, @ApiResponse(code = 400, message = "TipoPulseira é obrigatorio")
		, @ApiResponse(code = 400, message = "TipoPulseira nao existe")
		, @ApiResponse(code = 400, message = "Valor deve ser maior que zero")
		, @ApiResponse(code = 404, message = "Relogio nao encontrado")
		, @ApiResponse(code = 500, message = "Erro interno")
	})
	ResponseEntity<String> deletar(Long id);
	
	
}
