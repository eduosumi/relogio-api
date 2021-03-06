package com.br.relogio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.impl.PojoClassFactory;

@RunWith(SpringRunner.class)
public class RelogioApplicationTest {

	public static final String PACKAGE = "com.br.relogio";
	public static final List<String> PACKAGE_EXCLUDES = Arrays.asList(
			"com.br.relogio.RelogioApplication",
			"com.br.relogio.api",
			"com.br.relogio.config",
			"com.br.relogio.controller",
			"com.br.relogio.domain",
			"com.br.relogio.enums",
			"com.br.relogio.exception",
			"com.br.relogio.mock",
			"com.br.relogio.repository",
			"com.br.relogio.utils"
			);
	public static final String SUFIXO = "Test";

	private boolean packageValid(String name) {
		for (String p : PACKAGE_EXCLUDES) {
			if (name.contains(p)) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void testPatternsOfTests() {
		System.out.println("Iniciando a Validação de Testes/Java");
		List<PojoClass> klassesJava = PojoClassFactory.getPojoClassesRecursively(PACKAGE, new PojoClassFilter() {
			@Override
			public boolean include(PojoClass pojoClass) {
				return packageValid(pojoClass.getPackage().getName())
						&& !pojoClass.getSourcePath().contains("/test-classes/") && !pojoClass.isEnum()
						&& !pojoClass.isNestedClass() && !pojoClass.isInterface() && !pojoClass.isAbstract()
						&& Objects.isNull(pojoClass.getAnnotation(Ignore.class));
			}
		});
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Total de Classes Java envolvidas na validação: " + klassesJava.size());
		List<PojoClass> klassesTest = PojoClassFactory.getPojoClassesRecursively(PACKAGE, new PojoClassFilter() {
			@Override
			public boolean include(PojoClass pojoClass) {
				return packageValid(pojoClass.getPackage().getName())
						&& pojoClass.getSourcePath().contains("/test-classes/") && !pojoClass.isEnum()
						&& !pojoClass.isNestedClass() && !pojoClass.isInterface();
			}
		});
		System.out.println("Total de Classes de Teste encontradas no projeto: " + klassesTest.size());
		List<PojoClass> semTest = new ArrayList<>();
		for (PojoClass pj : klassesJava) {
			List<PojoClass> result = klassesTest.stream().filter(k -> k.getName().equals(pj.getName() + SUFIXO))
					.collect(Collectors.toList());
			if (Objects.isNull(result) || result.isEmpty()) {
				semTest.add(pj);
			}
		}
		if (Objects.isNull(semTest) || semTest.isEmpty()) {
			StringBuilder mensagem = new StringBuilder();
			mensagem.append("\n\n\n").append("Atenção: %s ").append(semTest.size())
					.append(" %s sem seu respectivo teste unitário. ")
					.append(" \nÉ obrigatório implementar testes unitários para todas as classes de serviço (business). \n\n\n");
			String[] parametrosMensagem = this.parametrosMensagem(semTest);
			String mensagemFormatada = String.format(mensagem.toString(), parametrosMensagem[0], parametrosMensagem[1]);
			System.out.println("---------------------------------------------------------------------");
			System.out.println(mensagemFormatada);
			for (PojoClass pj : semTest) {
				System.out.println(pj.getName());
			}
			System.out.println("---------------------------------------------------------------------");
		} else {
			System.out.println("---------------------------------------------------------------------");
			System.out.println("Verificação OK: Todas as classes de serviço possuem testes unitários.");
			System.out.println("---------------------------------------------------------------------");
		}
		Assert.assertTrue(semTest.isEmpty());
	}

	private String[] parametrosMensagem(List<PojoClass> classesSemTeste) {
		String[] parametros = new String[2];
		if (CollectionUtils.isEmpty(classesSemTeste)) {
			parametros[0] = "Existe";
			parametros[1] = "classe";
		} else {
			parametros[0] = "Existem";
			parametros[1] = "classes";
		}
		return parametros;
	}
	
}