package fachadas;

import java.util.List;

import basicasHumana.*;




public interface IFachada{
	
	//métodos pertinentes a classe Cliente
	public void inserirCliente(Cliente cliente);
	public void alterarCliente(Cliente cliente);	
	public void removerCliente(Cliente cliente);
	public List<Cliente> consultarTodosCliente();
	public Cliente consultarPorIdCliente(Integer id);
	public Cliente localizarClientePeloFone(String fone);	
	public List<Cliente> localizarClientePeloNome(String nome);
	public Cliente localizarClientePeloCpf(String cpf);	
	
	//mpetodos pertinentas a classe Funcionario
	public void inserirFuncionario(Funcionario funcionario);
	public void alterarFuncionario(Funcionario funcionario);	
	public void removerFuncionario(Funcionario funcionario);
	public List<Funcionario> consultarTodos();
	public Funcionario consultarFuncionarioPorId(Integer id);
	
	

}
