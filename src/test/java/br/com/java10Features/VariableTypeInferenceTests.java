package br.com.java10Features;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VariableTypeInferenceTests {

/* 
		var valorInteiro = 100;
		var valorString = "Teste com var!";
		var valorDouble = getNome();
		var valorByte = new ByteArrayInputStream(null);
		
		var list = List.of("Teste", "com", "var!");
		for (var elemento : list) {
		}
		for (var j = 0; j < 50; j++) {
		}
		
		var lista = new ArrayList<String>();

		var httpClient = HttpClient.newBuilder().build();

 */
 
	@Test
	void var_retornaInteiro_quandoSucesso() {
		var valorInteiro = 100;
		assertEquals(100, valorInteiro);
	}

	@Test
	void var_retornaString_quandoSucesso() {
		var valorString = "Teste com var!";
		assertEquals("Teste com var!", valorString);
	}

	@Test
	void var_retornaDouble_quandoSucesso() {
		var valorDouble = getValor();
		assertEquals(10.50, valorDouble);
	}

	public double getValor() {
		return 10.50;
	}

	@Test
	void var_retornaByte_quandoSucesso() {
		var valorByte = new ByteArrayInputStream(new byte[2]);
		assertEquals(valorByte, valorByte);
	}

	@Test
	void var_retornaList_quandoSucesso() {
		var list = List.of("Teste", "com", "var!");
		assertEquals("[Teste, com, var!]", list.toString());
	}

	@Test
	void var_retornaString_varDeclaradoDentroDoForEach_quandoSucesso() {
		var retorno = "";
		var list = List.of("Teste", "com", "var!");
		for (var elemento : list) {
			retorno = retorno + " " + elemento;
		}
		assertEquals(" Teste com var!", retorno);
	}

	@Test
	void var_retornaString_varDeclaradoDentroDoFor_quandoSucesso() {
		var retorno = 0;
		for (var j = 0; j < 3; j++) {
			retorno = retorno + j;
		}
		assertEquals(3, retorno);
	}

	@Test
	void var_retornaArrayList_quandoSucesso() {
		var lista = new ArrayList<String>();
		lista.add("Teste com var!");
		assertEquals("Teste com var!", lista.get(0));
	}

	@Test
	void var_retornaHttpClient_quandoSucesso() {
		var httpClient = HttpClient.newBuilder().build();
		assertEquals(httpClient, httpClient);
	}

}
