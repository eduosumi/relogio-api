package com.br.relogio.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import com.br.relogio.api.EnderecoMarcaDto;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelogioResponse implements Serializable {

	private static final long serialVersionUID = -6847817585845393885L;

	private Long id;
	
	private String marca; 
	
	private String modelo;
	
	private String tipoPulseira;
	
	private BigDecimal valor;
	
	private boolean isSmartWatch;
	
	private EnderecoMarcaDto[] enderecos;

	public RelogioResponse(Long id, String marca, String modelo, String tipoPulseira, BigDecimal valor,
			boolean isSmartWatch) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.tipoPulseira = tipoPulseira;
		this.valor = valor;
		this.isSmartWatch = isSmartWatch;
	}

	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getTipoPulseira() {
		return tipoPulseira;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public boolean isSmartWatch() {
		return isSmartWatch;
	}

	public EnderecoMarcaDto[] getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(EnderecoMarcaDto[] enderecos) {
		this.enderecos = enderecos;
	}
	
}
