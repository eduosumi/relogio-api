package com.br.relogio.mock.enderecoMarca;

import java.io.Serializable;

public class EnderecoMarcaResponseMock implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String cep;

	private String endereco;

	public EnderecoMarcaResponseMock(Long id, String cep, String endereco) {
		super();
		this.id = id;
		this.cep = cep;
		this.endereco = endereco;
	}

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
