package com.br.relogio.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.relogio.domain.RelogioRequest;
import com.br.relogio.domain.RelogioResponse;
import com.br.relogio.service.RelogioService;

@RestController
@RequestMapping(value = "/relogios", produces = MediaType.APPLICATION_JSON_VALUE)
public class RelogioController implements RelogioSwagger {

	@Autowired
	private RelogioService relogioService;
	
	@PostMapping
	public ResponseEntity<Long> salvar(@Valid @RequestBody RelogioRequest relogioRequest) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(relogioService.salvarRequest(relogioRequest));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<RelogioResponse> alterar(@PathVariable(value = "id") Long id, @Valid @RequestBody RelogioRequest relogioRequest) {
		
		return ResponseEntity.ok(relogioService.alterarRequest(id, relogioRequest));
	}
	
	@GetMapping
	public ResponseEntity<Set<RelogioResponse>> listar() {
		
		return ResponseEntity.ok(relogioService.listarResponse());
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletar(@PathVariable(value = "id") Long id) {
		
		relogioService.deletar(id);
		
		return ResponseEntity.ok("Relogio deletado com sucesso");
	}
	
}
