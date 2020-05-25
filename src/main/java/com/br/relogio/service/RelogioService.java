package com.br.relogio.service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.relogio.api.EnderecoMarcaDto;
import com.br.relogio.api.MarcaEnderecoApi;
import com.br.relogio.domain.MapperRelogio;
import com.br.relogio.domain.RelogioEntity;
import com.br.relogio.domain.RelogioRequest;
import com.br.relogio.domain.RelogioResponse;
import com.br.relogio.exception.ExceptionMessageEnum;
import com.br.relogio.exception.WebException;
import com.br.relogio.repository.RelogioRepository;

@Service
public class RelogioService {

	@Autowired
	private RelogioRepository relogioRepository;

	@Autowired
	private MarcaEnderecoApi marcaEnderecoApi;

	private RelogioEntity salvarOuAlterar(RelogioEntity relogioEntity) {

		return relogioRepository.save(relogioEntity);
	}

	public Long salvarRequest(RelogioRequest relogioRequest) {

		RelogioEntity relogioEntity = MapperRelogio.convert(relogioRequest);

		relogioEntity = salvarOuAlterar(relogioEntity);

		return relogioEntity.getId();
	}

	public RelogioEntity autenticar(Long idRelogioEntity) {

		Optional<RelogioEntity> optRelogioEntity = relogioRepository.findById(idRelogioEntity);

		WebException.checkThrow(optRelogioEntity.isEmpty(), ExceptionMessageEnum.USUARIO_NAO_ENCONTRADO);

		return optRelogioEntity.get();

	}

	public RelogioResponse alterarRequest(Long idRelogioEntity, RelogioRequest relogioRequest) {

		autenticar(idRelogioEntity);

		RelogioEntity relogioEntity = MapperRelogio.convert(relogioRequest);
		relogioEntity.setId(idRelogioEntity);
		salvarOuAlterar(relogioEntity);

		return MapperRelogio.convert(relogioEntity);

	}

	public Set<RelogioResponse> listarResponse() {

		Iterable<RelogioEntity> relogios = relogioRepository.findAll();

		Set<RelogioResponse> responses = new LinkedHashSet<RelogioResponse>();

		relogios.forEach(r -> {
			
			EnderecoMarcaDto[] enderecosPorMarca = marcaEnderecoApi.listarEndereco(r.getMarca().name());
			
			RelogioResponse response = MapperRelogio.convert(r);
			response.setEnderecos(enderecosPorMarca);
			
			responses.add(response);
			
		});
		
		

		return responses;
	}
	
	public void deletar(Long idRelogioEntity) {
		
		RelogioEntity relogioEntity = autenticar(idRelogioEntity);
		
		relogioRepository.delete(relogioEntity);
	}

}
