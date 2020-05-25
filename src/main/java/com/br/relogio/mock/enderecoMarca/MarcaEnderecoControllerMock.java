package com.br.relogio.mock.enderecoMarca;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mock/marcas")
public class MarcaEnderecoControllerMock {

	@GetMapping(value = "/{codigo}/enderecos")
	public ResponseEntity<List<EnderecoMarcaResponseMock>> listar(@PathVariable(value = "codigo") String codigoMarca) {
		
		EnderecoMarcaResponseMock end1 = new EnderecoMarcaResponseMock(1l, "04344411", "rua vasconcelos 123");
		EnderecoMarcaResponseMock end2 = new EnderecoMarcaResponseMock(2l, "04343333", "rua dom pedro 123342");
		EnderecoMarcaResponseMock end3 = new EnderecoMarcaResponseMock(3l, "04349999", "av tiradentes 97664");
		
		return ResponseEntity.ok(Arrays.asList(end1, end2, end3));
	}
	
}
