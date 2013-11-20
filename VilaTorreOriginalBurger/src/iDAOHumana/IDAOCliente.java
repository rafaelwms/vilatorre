package iDAOHumana;

import java.util.*;

import dados.Generico.IDAOGenerico;
import basicasHumana.*;

public interface IDAOCliente extends IDAOGenerico<Cliente> {

	
	public Cliente localizarClientePeloFone(String fone) throws Exception;
	
	public List<Cliente> localizarClientePeloNome(String nome) throws Exception;
	
	public Cliente localizarClientePeloCpf(String cpf) throws Exception;
	
	
	
}
