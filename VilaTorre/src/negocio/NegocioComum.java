package negocio;

import java.util.List;

import javax.persistence.NoResultException;

import basicas.Cargo;
import basicas.Cliente;
import basicas.Funcionario;
import basicas.Pessoa;
import dados.*;

public class NegocioComum {

	private IDAOCliente daoCliente;
	private IDAOPessoa daoPessoa;
	private IDAOFuncionario daoFuncionario;
	private IDAOCargo daoCargo;
	
	public NegocioComum() {
		this.daoCliente = new DAOCliente();
		this.daoPessoa = new DAOPessoa();
		this.daoFuncionario = new DAOFuncionario();
		this.daoCargo = new DAOCargo();
	}

	

	/*
	 * *********************************
	 * MÉTODOS REFERENTE SO CLIENTE 
	 * *********************************
	 */

	public void inserirCliente(Cliente entidade) throws Exception {
		try {
			if (daoPessoa.verificarCpf(entidade.getCpf()) != null) {
				throw new Exception("O CPF \"" + entidade.getCpf()
						+ "\" já está cadastrado.");
			}
			if (daoPessoa.verificarRg(entidade.getRg()) != null) {
				throw new Exception("O RG \"" + entidade.getRg()
						+ "\" já está cadastrado.");
			}
			if (daoCliente.verificarEmail(entidade.getEmail()) != null){
				throw new Exception("O e-mail \"" + entidade.getEmail() + "\" já está cadastrado.");
			}
			if (!entidade.getUsuario().getLogin().trim().equals("")) {
				if (daoPessoa.verificarLogin(entidade.getUsuario().getLogin()) != null){
					throw new Exception("O login \"" + entidade.getUsuario().getLogin() + "\" já está cadastrado.");
				}
			}
			if(daoPessoa.verificarFone(entidade.getFone()) != null){
				throw new Exception("O fone \"" + entidade.getFone()
						+ "\" já está cadastrado.");
			}
			
			this.daoCliente.inserir(entidade);
			
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}

	public void alterarCliente(Cliente entidade) throws Exception {
		try {
			if (!entidade.getUsuario().getLogin().trim().equals("")) {
				this.verificarLogin(entidade.getUsuario().getLogin());
			}
		} catch (NoResultException ex) {
			daoCliente.alterar(entidade);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}

	public void remover(Cliente entidade) throws Exception {
		try {
			daoCliente.remover(entidade);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}

	}

	public Cliente consultarPorId(Integer id) throws Exception {
		try {
			return daoCliente.consultarPorId(id);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}

	public List<Cliente> consultarTodosClientes() throws Exception {
		try {
			return daoCliente.consultarTodos();
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}

	public Cliente localizarClientePeloFone(String fone) throws Exception {
		try {
			return daoCliente.localizarClientePeloFone(fone);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}

	public List<Cliente> localizarClientePeloNome(String nome) throws Exception {
		try {
			return daoCliente.localizarClientePeloNome(nome);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}
	
	public Cliente verificarEmail(String email) throws Exception {
		try{
		return daoCliente.verificarEmail(email);
			}catch (NoResultException x){
				return null;
			}			
		}

	/*
	 * **********************************
	 * MÉTODOS REFERENTES AO FUNCIONÁRIO 
	 * **********************************
	 */

	public Cliente localizarClientePeloCpf(String cpf) throws Exception {
		try {
			return daoCliente.localizarClientePeloCpf(cpf);
		} catch (NoResultException x) {
			return null;
		}
	}

	public void inserirFuncionario(Funcionario entidade) throws Exception {
		try {
			this.verificarCpf(entidade.getCpf());
			this.verificarRg(entidade.getRg());
			if (!entidade.getUsuario().getLogin().trim().equals("")) {
				this.verificarLogin(entidade.getUsuario().getLogin());
			}
			daoFuncionario.inserir(entidade);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}

	}

	public void alterarFuncionario(Funcionario entidade) throws Exception {
		try {
			this.verificarCpf(entidade.getCpf());
			this.verificarRg(entidade.getRg());
			if (!entidade.getUsuario().getLogin().trim().equals("")) {
				this.verificarLogin(entidade.getUsuario().getLogin());
			}

			daoFuncionario.alterar(entidade);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}

	}

	public void removerFuncionario(Funcionario entidade) throws Exception {
		try {
			daoFuncionario.remover(entidade);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}

	}

	public List<Funcionario> consultarTodosFuncioinarios() throws Exception {
		try {
			return daoFuncionario.consultarTodos();

		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}

	public Funcionario consultarFuncionarioPorId(Integer id) throws Exception {

		try {
			return daoFuncionario.consultarPorId(id);

		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}

	/*
	 * **********************************
	 * MÉTODOS REFERENTES A PESSOA 
	 * **********************************
	 */

	public Pessoa logarPessoa(String login, String senha) throws Exception {
		try {
			return daoPessoa.logarPessoa(login, senha);
		} catch (NoResultException e) {
			return null;
		}
	}

	public Pessoa verificarFone(String fone) throws Exception {
		try {
			return daoPessoa.verificarFone(fone);
		} catch (NoResultException x) {
			return null;
		}
	}

	public Pessoa verificarCpf(String cpf) throws Exception {
		try {
			return daoPessoa.verificarCpf(cpf);
		} catch (Exception x) {
			return null;
		}
	}

	public Pessoa verificarRg(String rg) throws Exception {
		try {
			return daoPessoa.verificarRg(rg);
		} catch (Exception x) {
			return null;
		}
	}

	public Pessoa verificarLogin(String login) {
			try {
				return daoPessoa.verificarLogin(login);
			} catch (Exception e) {
				return null;
			}
	
	}
	/*
	 * **********************************
	 *   MÉTODOS REFERENTES A CARGO
	 * **********************************
	 */
	
	
	public void inserirCargo(Cargo cargo)throws Exception{
		try {
			daoCargo.inserir(cargo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public void alterarCargo(Cargo cargo)throws Exception{
		try {
			daoCargo.alterar(cargo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}	
	public void removerCargo(Cargo cargo)throws Exception{
		try {
			daoCargo.remover(cargo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public List<Cargo> consultarTodosCargo()throws Exception{
		try {
			return daoCargo.consultarTodos();
		} catch (Exception e) {
			return null;
		}
	}
	public Cargo consultarPorIdCargo(Integer id)throws Exception{
		try {
			return daoCargo.consultarPorId(id);
		} catch (Exception e) {
			return null;
		}
	}

}
