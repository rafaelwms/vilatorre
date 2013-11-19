package fachadas;

import java.util.List;

import negocio.NegocioCliente;

import basicasHumana.*;



public class Fachada implements FachadaCliente{

	@Override
	public Cliente localizarClientePeloFone(String fone) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> localizarClientePeloNome(String nome) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente localizarClientePeloCpf(String cpf) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Cliente entidade) throws Exception {
		try{
			NegocioCliente cliente = new NegocioCliente();
			cliente.inserir(entidade);
			cliente = null;
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public void alterar(Cliente entidade) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Cliente entidade) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente consultarPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> consultarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
