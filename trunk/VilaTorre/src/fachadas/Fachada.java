package fachadas;

import java.util.List;

import negocio.NegocioCliente;
import negocio.NegocioComum;

import basicas.*;

public class Fachada implements IFachada {

	private static IFachada fachada;
	private NegocioComum negocioComum;

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
	public void inserirCliente(Cliente cliente) {
		negocioComum.inserirCliente(cliente);

	}

	@Override
	public void alterarCliente(Cliente cliente) {
		negocioComum.alterarCliente(cliente);
	}

	@Override
	public void removerCliente(Cliente cliente) {
		negocioComum.remover(cliente);
	}

	@Override
	public List<Cliente> consultarTodosCliente() {
		return negocioComum.consultarTodosClientes();

	}

	public Cliente consultarPorIdCliente(Integer id) {

		return negocioComum.consultarPorId(id);

	}

	@Override
	public Cliente localizarClientePeloFone(String fone) {
		return negocioComum.localizarClientePeloFone(fone);
	}

	@Override
	public List<Cliente> localizarClientePeloNome(String nome) {
		return negocioComum.localizarClientePeloNome(nome);
	}

	@Override
	public Cliente localizarClientePeloCpf(String cpf) {
		return null;
	}

	@Override
	public void inserirFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void alterarFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removerFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Funcionario> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario consultarFuncionarioPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}