package com.br.relogio.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.br.relogio.domain.RelogioEntity;
import com.br.relogio.domain.RelogioRequest;
import com.br.relogio.domain.RelogioResponse;
import com.br.relogio.enums.Marca;
import com.br.relogio.enums.Modelo;
import com.br.relogio.enums.TipoPulseira;
import com.br.relogio.exception.WebException;
import com.br.relogio.repository.RelogioRepository;

@RunWith(MockitoJUnitRunner.class)
public class RelogioServiceTest {

	@Mock
	private RelogioRepository relogioRepository;

	@InjectMocks
	private RelogioService relogioService;

	private static final Long IDENTIFICADOR_RELOGIO = 1l;
	private RelogioEntity relogioEntity;
	private static final RelogioRequest relogioRequest = new RelogioRequest(Marca.APPLE, Modelo.MODELO1,
			TipoPulseira.ACRILICO, new BigDecimal(349.99), true);

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void before() {
		relogioEntity = new RelogioEntity();
		relogioEntity.setId(IDENTIFICADOR_RELOGIO);
		relogioEntity.setMarca(Marca.APPLE);
		relogioEntity.setModelo(Modelo.MODELO1);
		relogioEntity.setSmartWatch(true);
		relogioEntity.setTipoPulseira(TipoPulseira.ACRILICO);
		relogioEntity.setValor(new BigDecimal(349.99));

	}

	private void mock_salvar_alterar_entity_sucesso() {
		when(relogioRepository.save(Mockito.any(RelogioEntity.class))).thenReturn(relogioEntity);
	}

	@Test
	public void salvarRequest() {

		mock_salvar_alterar_entity_sucesso();

		Long retorno = relogioService.salvarRequest(relogioRequest);

		assertNotNull(retorno);
		assertEquals(IDENTIFICADOR_RELOGIO, retorno);
	}

	private void mock_existe_registro() {
		when(relogioRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(relogioEntity));
	}

	@Test
	public void autenticar_Sucesso() {

		mock_existe_registro();

		RelogioEntity retorno = relogioService.autenticar(IDENTIFICADOR_RELOGIO);

		assertNotNull(retorno);
		assertEquals(retorno.getId(), IDENTIFICADOR_RELOGIO);
	}

	private void mock_nao_existe_registro() {
		when(relogioRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
	}

	@Test
	public void autenticar_NaoEncontrado() {

		expectedException.expect(WebException.class);
		expectedException.expectMessage("Relogio nao encontrado");

		mock_nao_existe_registro();

		relogioService.autenticar(IDENTIFICADOR_RELOGIO);
	}

	@Test
	public void alterarRequest_Sucesso() {

		mock_existe_registro();

		mock_salvar_alterar_entity_sucesso();

		RelogioResponse retorno = relogioService.alterarRequest(IDENTIFICADOR_RELOGIO, relogioRequest);

		assertNotNull(retorno);
		assertEquals(retorno.getId(), IDENTIFICADOR_RELOGIO);
	}

	@Test
	public void listarResponse_Com_Dados() {

		Set<RelogioEntity> lista = new LinkedHashSet<RelogioEntity>();
		lista.add(relogioEntity);

		int qtd_relogios_esperado = lista.size();

		when(relogioRepository.findAll()).thenReturn(lista);

		Set<RelogioResponse> retorno = relogioService.listarResponse();

		assertNotNull(retorno);
		assertEquals(qtd_relogios_esperado, retorno.size());
	}

	@Test
	public void listarResponse_Sem_Dados() {

		int qtd_relogios_esperado = 0;

		when(relogioRepository.findAll()).thenReturn(new ArrayList<RelogioEntity>());

		Set<RelogioResponse> retorno = relogioService.listarResponse();

		assertNotNull(retorno);
		assertEquals(qtd_relogios_esperado, retorno.size());
	}

	@Test
	public void deletar() {

		mock_existe_registro();

		relogioService.deletar(IDENTIFICADOR_RELOGIO);

	}

}
