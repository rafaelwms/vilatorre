package fachadas;

import java.util.List;

import basicas.*;




public interface IFachada{
	
	//métodos pertinentes a classe Cliente
	public void inserirCliente(Cliente cliente)throws Exception;
	public void alterarCliente(Cliente cliente)throws Exception;	
	public void removerCliente(Cliente cliente)throws Exception;
	public List<Cliente> consultarTodosCliente()throws Exception;
	public Cliente consultarPorIdCliente(Integer id)throws Exception;
	public Cliente localizarClientePeloFone(String fone)throws Exception;	
	public List<Cliente> localizarClientePeloNome(String nome)throws Exception;
	public Cliente localizarClientePeloCpf(String cpf)throws Exception;	
	
	//mpetodos pertinentas a classe Funcionario
	public void inserirFuncionario(Funcionario funcionario)throws Exception;
	public void alterarFuncionario(Funcionario funcionario)throws Exception;	
	public void removerFuncionario(Funcionario funcionario)throws Exception;
	public List<Funcionario> consultarTodos()throws Exception;
	public Funcionario consultarFuncionarioPorId(Integer id)throws Exception;
	
	

}
