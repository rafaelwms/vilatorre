package jUnit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import util.Datas;

import basicas.Cliente;
import basicas.Endereco;

public class TesteCLiente {
	private Endereco endereco;	
	private Cliente cli;
	Date esperadoNasc; 
	Date esperadoCadastro;
	Date nascCliente;
	Date cadastroCliente;
	
	@Before
	public void setUp(){
		
//		endereco.setLogradouro("Rua José Bonifácio");
//		endereco.setNumero("1356");
//		endereco.setComplemento("101 - C");
//		endereco.setCidade("Recife");
//		endereco.setUf("PE");
		cli = new Cliente("Rafael WMS", 11, 04, 1978, "030.328.534-00", "123456-SDSPE", "(81)9925.2751", "rafael.wms@msn.com", endereco);
		esperadoNasc = Datas.criarData("11/04/1978");
		esperadoCadastro = new Date();
		nascCliente = cli.getNasc();
		cadastroCliente = cli.getCadastro(); 
		
		esperadoNasc = cli.getNasc();
	}
	@Test
	public void testDataNasc() {
		
		
		assertEquals(esperadoNasc,  cli.getNasc());
		
		assertEquals(esperadoCadastro, (Date) cli.getCadastro());
		
		
		//fail("Not yet implemented");
	}

}
