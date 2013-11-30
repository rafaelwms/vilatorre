package jUnit;

import static org.junit.Assert.*;

import negocio.NegocioCalculos;

import org.junit.Before;
import org.junit.Test;

import basicas.Estoque;

public class TesteAlimentarEstoque {
	 Estoque estoqueCalculo; 
	 Estoque estoqueEsperado; 


	@Before
	public void setUp() throws Exception {
		estoqueCalculo = new Estoque();
		estoqueEsperado = new Estoque();
		estoqueCalculo.setId_materia(null);
		estoqueEsperado.setId_materia(null);
		estoqueCalculo.setQuantidade(250.00);
		estoqueEsperado.setQuantidade(284.75);
	}

	@Test
	public void testAlimentarEstoque() {
		assertEquals(estoqueEsperado, NegocioCalculos.alimentarEstoque(estoqueCalculo, 34.75));
	}

}
