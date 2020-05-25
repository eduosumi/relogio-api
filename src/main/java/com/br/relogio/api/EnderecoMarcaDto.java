package com.br.relogio.api;

import java.io.Serializable;

public class EnderecoMarcaDto implements Serializable {

	private static final long serialVersionUID = 1934204759107245192L;

	private Long id;

	private String cep;

	private String endereco;
	
	public EnderecoMarcaDto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
