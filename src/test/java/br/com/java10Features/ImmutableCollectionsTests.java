package br.com.java10Features;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImmutableCollectionsTests {

/* 
		*Immutable Collections

		- List.copyOf
		- Set.copyOf
		- Map.copyOf
		- toUnmodifiableList
		- toUnmodifiableSet
		- toUnmodifiableMap
 */
 
	/* List.copyOf */
	@Test
	void list_copyOf_retornaListaInalteravel_quandoSucesso() {
		var lista = List.of(1,2,3);
		List<Integer> listaInalteravel = List.copyOf(lista);
		assertEquals(List.of(1,2,3), listaInalteravel);
	}
 
	@Test
	void list_copyOf_retornaExcecaoAoInserirValorNaListaInalteravel_quandoErro() {
		var lista = List.of(1,2,3);
		List<Integer> listaInalteravel = List.copyOf(lista);
		assertThrows(UnsupportedOperationException.class, () -> adicionaValorNaLista(listaInalteravel).orElseThrow());
	}

	public Optional<List<Integer>> adicionaValorNaLista(List<Integer> listaInalteravel){
		listaInalteravel.add(10);
		return Optional.of(listaInalteravel);
	}

	/* Set.copyOf */
	@Test
	void set_copyOf_retornaListaInalteravel_quandoSucesso() {
		var set = Set.of(1,2,3);
		Set<Integer> setInalteravel = Set.copyOf(set);
		assertEquals(Set.of(1,2,3), setInalteravel);
	}
	
	@Test
	void set_copyOf_retornaExcecaoAoInserirValorNaListaInalteravel_quandoErro() {
		var set = Set.of(1,2,3);
		Set<Integer> setInalteravel = Set.copyOf(set);
		assertThrows(UnsupportedOperationException.class, () -> adicionaValorNaLista(setInalteravel).orElseThrow());
	}

	public Optional<Set<Integer>> adicionaValorNaLista(Set<Integer> setInalteravel){
		setInalteravel.add(10);
		return Optional.of(setInalteravel);
	}
	
	/* Map.copyOf */
	@Test
	void map_copyOf_retornaListaInalteravel_quandoSucesso() {
		var map = Map.of("um",1);
		Map<String, Integer> mapInalteravel = Map.copyOf(map);
		assertEquals("{um=1}", mapInalteravel.toString());
	}
	
	@Test
	void map_copyOf_retornaExcecaoAoInserirValorNaListaInalteravel_quandoErro() {
		var map = Map.of("um",1);
		Map<String, Integer> mapInalteravel = Map.copyOf(map);
		assertThrows(UnsupportedOperationException.class, () -> adicionaValorNaLista(mapInalteravel).orElseThrow());
	}

	public Optional<Map<String, Integer>> adicionaValorNaLista(Map<String, Integer> mapInalteravel){
		mapInalteravel.put("dois", 2);
		return Optional.of(mapInalteravel);
	}
}
