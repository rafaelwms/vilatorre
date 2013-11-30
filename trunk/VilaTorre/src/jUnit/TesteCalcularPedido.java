package jUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import negocio.NegocioCalculos;

import org.junit.Before;
import org.junit.Test;

import basicas.*;

public class TesteCalcularPedido {
	Pedido pedido;
	Produto produto1;
	Produto produto2;
	Produto produto3;
	ItemPedido item1;
	ItemPedido item2;
	ItemPedido item3;
	List<ItemPedido> listaItems;
	double resultadoEsperado;
	
	@Before
	public void setUp() throws Exception {
		pedido = new Pedido();
		produto1 = new Produto();
		produto2 = new Produto();
		produto3 = new Produto();
		item1 = new ItemPedido();
		item2 = new ItemPedido();
		item3 = new ItemPedido();
		listaItems = new ArrayList<ItemPedido>();
		
		produto1.setPreco(4.50);
		produto2.setPreco(2.00);
		produto3.setPreco(3.75);
		
		item1.setProduto(produto1);
		item1.setQtd(2); // vai dar 9.00
		listaItems.add(item1);
		item2.setProduto(produto2);
		item2.setQtd(5); // vai dar 10.00
		listaItems.add(item2);
		item3.setProduto(produto3);
		item3.setQtd(4);  // vai dar 15
		listaItems.add(item3);
		
		pedido.setLista_itens(listaItems);
		
		resultadoEsperado = 34.00;
		
		
	}

	@Test
	public void testarCalcularPedido() {
		assertEquals(resultadoEsperado, NegocioCalculos.calcularPedido(pedido), 0);
	}

}
