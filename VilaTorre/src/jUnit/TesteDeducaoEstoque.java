package jUnit;

import static org.junit.Assert.*;

import negocio.NegocioCalculos;

import org.junit.Before;
import org.junit.Test;

import basicas.Estoque;

public class TesteDeducaoEstoque {
	
	 Estoque estoqueCalculo; 
	 Estoque estoqueEsperado; 


	@Before
	public void setUp() throws Exception {
		estoqueCalculo = new Estoque();
		estoqueEsperado = new Estoque();
		estoqueCalculo.setId_materia(null);
		estoqueEsperado.setId_materia(null);
		estoqueCalculo.setQuantidade(250.00);
		estoqueEsperado.setQuantidade(100);
	}

	@Test
	public void testDeducaoEstoque() {

		
		assertEquals(estoqueEsperado, NegocioCalculos.deduzirEstoque(estoqueCalculo, 150));
		

	}

}
