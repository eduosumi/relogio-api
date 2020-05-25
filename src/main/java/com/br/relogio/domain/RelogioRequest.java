package com.br.relogio.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.br.relogio.enums.Marca;
import com.br.relogio.enums.Modelo;
import com.br.relogio.enums.TipoPulseira;

public class RelogioRequest implements Serializable {

	private static final long serialVersionUID = -2619338550707330510L;

	@NotNull
	private Marca marca; 
	
	@NotNull
	private Modelo modelo;
	
	@NotNull
	private TipoPulseira tipoPulseira;
	
	@DecimalMin(value = "0.01")
	private BigDecimal valor;
	
	private boolean isSmartWatch;

	public RelogioRequest(@NotNull Marca marca, @NotNull Modelo modelo, @NotNull TipoPulseira tipoPulseira,
			@DecimalMin("0.01") BigDecimal valor, boolean isSmartWatch) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.tipoPulseira = tipoPulseira;
		this.valor = valor;
		this.isSmartWatch = isSmartWatch;
	}

	public Marca getMarca() {
		return marca;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public TipoPulseira getTipoPulseira() {
		return tipoPulseira;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public boolean isSmartWatch() {
		return isSmartWatch;
	}
	
}
