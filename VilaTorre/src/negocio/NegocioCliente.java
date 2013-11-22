package negocio;


import java.util.List;

import dados.*;
import basicas.*;


public class NegocioCliente extends NegocioComum implements IDAOCliente {

	DAOCliente dados = new DAOCliente();
	@Override
	public void inserir(Cliente entidade){

			dados.inserir(entidade);

	}

	@Override
	public void alterar(Cliente entidade){
			
			dados.alterar(entidade);
	}

	@Override
	public void remover(Cliente entidade){
		// TODO Auto-generated method stub
			
			dados.remover(entidade);		


	}

	@Override
	public Cliente consultarPorId(Integer id){

			return dados.consultarPorId(id);

	}

	@Override
	public List<Cliente> consultarTodos(){

			return dados.consultarTodos();

	}

	@Override
	public Cliente localizarClientePeloFone(String fone) {
			return dados.localizarClientePeloFone(fone);

	}

	@Override
	public List<Cliente> localizarClientePeloNome(String nome) {

			return dados.localizarClientePeloNome(nome);

	}

	@Override
	public Cliente localizarClientePeloCpf(String cpf){

			return (Cliente) dados.localizarClientePeloCpf(cpf);

	}

}
