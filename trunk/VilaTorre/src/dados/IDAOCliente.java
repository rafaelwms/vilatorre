package dados;

import java.util.*;

import dados.IDAOGenerico;
import basicas.*;

public interface IDAOCliente extends IDAOGenerico<Cliente> {

	
	public Cliente localizarClientePeloFone(String fone);
	
	public List<Cliente> localizarClientePeloNome(String nome);
	
	public Cliente localizarClientePeloCpf(String cpf);
	
	
	
}
