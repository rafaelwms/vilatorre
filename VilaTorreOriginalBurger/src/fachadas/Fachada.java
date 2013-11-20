package fachadas;

import java.util.ArrayList;
import java.util.List;

import negocio.NegocioCliente;

import basicasHumana.*;

public class Fachada implements IFachada {

	private static IFachada fachada;
	private NegocioCliente execCliente;

	public static IFachada getInstancia() {
		if (fachada == null) {
			fachada = new Fachada();
		}
		return fachada;
	}

	@Override
	public void inserirCliente(Cliente cliente) {
		try {
			execCliente.inserir(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterarCliente(Cliente cliente) {
		try {
			execCliente.alterar(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removerCliente(Cliente cliente) {
		try {
			execCliente.remover(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Cliente> consultarTodosCliente() {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			lista = execCliente.consultarTodos();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Cliente consultarPorIdCliente(Integer id) {
		Cliente cliente = new Cliente();
		try {
			cliente = execCliente.consultarPorId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public Cliente localizarClientePeloFone(String fone) {
		Cliente cliente = new Cliente();
		try {
			cliente = execCliente.localizarClientePeloFone(fone);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public List<Cliente> localizarClientePeloNome(String nome) {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			lista = execCliente.localizarClientePeloNome(nome);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Cliente localizarClientePeloCpf(String cpf) {
		Cliente cliente = new Cliente();
		try {
			cliente = execCliente.localizarClientePeloCpf(cpf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
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