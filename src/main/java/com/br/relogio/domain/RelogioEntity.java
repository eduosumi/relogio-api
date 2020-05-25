package com.br.relogio.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.br.relogio.enums.Marca;
import com.br.relogio.enums.Modelo;
import com.br.relogio.enums.TipoPulseira;

@Entity
public class RelogioEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	private Marca marca; 
	
	private Modelo modelo;
	
	private TipoPulseira tipoPulseira;
	
	private BigDecimal valor;
	
	private boolean isSmartWatch;

	public RelogioEntity(Marca marca, Modelo modelo, TipoPulseira tipoPulseira, BigDecimal valor,
			boolean isSmartWatch) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.tipoPulseira = tipoPulseira;
		this.valor = valor;
		this.isSmartWatch = isSmartWatch;
	}
	
	public RelogioEntity(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public TipoPulseira getTipoPulseira() {
		return tipoPulseira;
	}

	public void setTipoPulseira(TipoPulseira tipoPulseira) {
		this.tipoPulseira = tipoPulseira;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public boolean isSmartWatch() {
		return isSmartWatch;
	}

	public void setSmartWatch(boolean isSmartWatch) {
		this.isSmartWatch = isSmartWatch;
	}
	
}
