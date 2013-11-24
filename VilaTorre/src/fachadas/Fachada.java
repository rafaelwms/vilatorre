package fachadas;

import java.util.List;


import negocio.NegocioComum;

import basicas.*;

public class Fachada implements IFachada {

	private static IFachada fachada;
	private static NegocioComum negocioComum;

	private Fachada() {
		this.negocioComum = new NegocioComum();
	}

	public static IFachada getInstancia() {
		if (fachada == null) {
			fachada = new Fachada();
		}
		return fachada;
	}

	@Override
	public void inserirCliente(Cliente cliente) throws Exception{
		try{
		negocioComum.inserirCliente(cliente);
		}catch (Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public void alterarCliente(Cliente cliente) throws Exception{
		negocioComum.alterarCliente(cliente);
	}

	@Override
	public void removerCliente(Cliente cliente) throws Exception{
		negocioComum.remover(cliente);
	}

	@Override
	public List<Cliente> consultarTodosCliente() throws Exception{
		return negocioComum.consultarTodosClientes();

	}

	public Cliente consultarPorIdCliente(Integer id) throws Exception{
		
		return negocioComum.consultarPorId(id);

	}

	@Override
	public Cliente localizarClientePeloFone(String fone) throws Exception{
		return negocioComum.localizarClientePeloFone(fone);
	}

	@Override
	public List<Cliente> localizarClientePeloNome(String nome) throws Exception{
		return negocioComum.localizarClientePeloNome(nome);
	}

	@Override
	public Cliente localizarClientePeloCpf(String cpf) throws Exception{
		return null;
	}

	@Override
	public void inserirFuncionario(Funcionario funcionario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarFuncionario(Funcionario funcionario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerFuncionario(Funcionario funcionario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Funcionario> consultarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario consultarFuncionarioPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}