package com.br.relogio.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.relogio.exception.ExceptionMessageEnum;
import com.br.relogio.utils.HeadersUtils;

@Service
public class MarcaEnderecoApi {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${externo.api.marca.host}")
	private String host;
	
	@Value("${externo.api.marca.paths.listar-enderecos}")
	private String pathListarEnredecos;
	
	public EnderecoMarcaDto[] listarEndereco(final String codigoMarca) {
		
		HttpHeaders headers = HeadersUtils.createDefaultHeaders();
		
		HttpEntity<?> payload = new HttpEntity<>(headers);
		
		String codigo = codigoMarca;
		
		StringBuilder uri = new StringBuilder(host).append(String.format(pathListarEnredecos, codigo));
		
		EnderecoMarcaDto[] lista = null;
		
		try {
			ResponseEntity<EnderecoMarcaDto[]> response = restTemplate.getForEntity(uri.toString(), EnderecoMarcaDto[].class, payload);
			
			lista = response.getBody();
		} catch (Exception e) {
			ExceptionMessageEnum.ERRO_INESPERADO_DO_SISTEMA.raise();
		}
		
		return lista;
	}
	
}
