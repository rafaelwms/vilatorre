package fachadas;

import java.util.List;

import negocio.NegocioComum;

import basicas.*;

public class Fachada implements IFachada {

	private static IFachada fachada;
	private  NegocioComum negocioComum;

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
	public void inserirCliente(Cliente cliente) throws Exception {
	
			try {
				negocioComum.inserirCliente(cliente);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new Exception(e.getMessage());
			}
	
	}

	@Override
	public void alterarCliente(Cliente cliente) throws Exception {
	
			negocioComum.alterarCliente(cliente);
	
	}

	@Override
	public void removerCliente(Cliente cliente) throws Exception {
	
			negocioComum.remover(cliente);
	
	}

	@Override
	public List<Cliente> consultarTodosCliente() throws Exception {

			return negocioComum.consultarTodosClientes();
	

	}

	public Cliente consultarPorIdCliente(Integer id) throws Exception {
			return negocioComum.consultarPorId(id);
	}

	@Override
	public Cliente localizarClientePeloFone(String fone) throws Exception {
		return negocioComum.localizarClientePeloFone(fone);
	}

	@Override
	public List<Cliente> localizarClientePeloNome(String nome) throws Exception {
		return negocioComum.localizarClientePeloNome(nome);
	}

	@Override
	public Cliente localizarClientePeloCpf(String cpf) throws Exception {
		return negocioComum.localizarClientePeloCpf(cpf);
	}

	@Override
	public void inserirFuncionario(Funcionario funcionario) throws Exception {
		negocioComum.inserirFuncionario(funcionario);
	}

	@Override
	public void alterarFuncionario(Funcionario funcionario) throws Exception {
		negocioComum.alterarFuncionario(funcionario);
	}

	@Override
	public void removerFuncionario(Funcionario funcionario) throws Exception {
		negocioComum.removerFuncionario(funcionario);
	}

	@Override
	public List<Funcionario> consultarTodos() throws Exception {
		return negocioComum.consultarTodosFuncioinarios();
	}

	@Override
	public Funcionario consultarFuncionarioPorId(Integer id) throws Exception {
		return negocioComum.consultarFuncionarioPorId(id);
	}

	@Override
	public void inserirPessoa(Pessoa pessoa) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void alterarPessoa(Pessoa pessoa) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removerPessoa(Pessoa pessoa) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Pessoa> consultarTodasPèssoas() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa consultarPessoaPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa logarPessoa(String login, String senha) throws Exception {
		// TODO Auto-generated method stub
		return negocioComum.logarPessoa(login, senha);
	}

	@Override
	public Pessoa verificarLogin(String login) throws Exception {
		// TODO Auto-generated method stub
		return negocioComum.verificarLogin(login);
	}

	@Override
	public Pessoa verificarFone(String fone) throws Exception {
		// TODO Auto-generated method stub
		return negocioComum.verificarFone(fone);
	}

	@Override
	public Pessoa verificarCpf(String cpf) throws Exception {
		// TODO Auto-generated method stub
		return negocioComum.verificarCpf(cpf);
	}

	@Override
	public Pessoa verificarRg(String rg) throws Exception {
		// TODO Auto-generated method stub
		return negocioComum.verificarRg(rg);
	}

	@Override
	public void inserirCargo(Cargo cargo) throws Exception {
		// TODO Auto-generated method stub
		negocioComum.inserirCargo(cargo);
	}

	@Override
	public void alterarCargo(Cargo cargo) throws Exception {
		// TODO Auto-generated method stub
		negocioComum.alterarCargo(cargo);
	}

	@Override
	public void removerCargo(Cargo cargo) throws Exception {
		// TODO Auto-generated method stub
		negocioComum.removerCargo(cargo);
	}

	@Override
	public List<Cargo> consultarTodosCargo() throws Exception {
		// TODO Auto-generated method stub
		return negocioComum.consultarTodosCargo();
	}

	@Override
	public Cargo consultarCargoPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return negocioComum.consultarPorIdCargo(id);
	}

}