package com.br.relogio.domain;

public class MapperRelogio {

	public static RelogioEntity convert(RelogioRequest request) {
		return new RelogioEntity(request.getMarca(), 
				request.getModelo(), 
				request.getTipoPulseira(), 
				request.getValor(), 
				request.isSmartWatch());
	}
	
	public static RelogioResponse convert(RelogioEntity entity) {
		return new RelogioResponse(
				entity.getId(), 
				entity.getMarca().name(), 
				entity.getModelo().name(), 
				entity.getTipoPulseira().name(), 
				entity.getValor(), 
				entity.isSmartWatch()
				);
	}
	
}
