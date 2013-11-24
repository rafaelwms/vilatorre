package negocio;



import java.util.List;

import javax.persistence.NoResultException;

import basicas.Cliente;
import basicas.Funcionario;
import basicas.Pessoa;
import dados.*;

public class NegocioComum{
	
	private IDAOCliente daoCliente;
	private IDAOPessoa daoPessoa;
	private IDAOFuncionario daoFuncionario;
	public NegocioComum(){
		this.daoCliente = new DAOCliente();
		this.daoPessoa = new DAOPessoa();
		this.daoFuncionario = new DAOFuncionario();
	}


	
	public void verificarCpf(String cpf) throws Exception{
		if(daoPessoa.verificarCpf(cpf)!= null){
			throw new Exception("O CPF \""+cpf+"\" já está cadastrado.");
		}
	}
	
	public void verificarRg(String rg) throws Exception{
		if(daoPessoa.verificarRg(rg)!= null){
			throw new Exception("O RG \""+rg+"\" já está cadastrado.");
		}
	}
	
	
	public void verificarLogin(String login) throws Exception{
		if(daoPessoa.verificarLogin(login)!= null){
			throw new Exception("O login \""+login+"\" já está cadastrado.");
		}
	}
	
	public void verificarEmail(String email) throws Exception{
		if(daoCliente.verificarEmail(email)!= null){
			throw new Exception("O e-mail \""+email+"\" já está cadastrado.");
		}
	}
	
	/*
	 * *********************************
	 *  MÉTODOS REFERENTE SO CLIENTE
	 * *********************************
	 * */

	public void inserirCliente(Cliente entidade)throws Exception {
		try{
			this.verificarCpf(entidade.getCpf());
			this.verificarRg(entidade.getRg());
			this.verificarEmail(entidade.getEmail());
			if(!entidade.getUsuario().getLogin().trim().equals("")){
			this.verificarLogin(entidade.getUsuario().getLogin());
			}
		}catch(NoResultException ex){
			daoCliente.inserir(entidade);
		}catch(Exception x){
			throw new Exception(x.getMessage());
		}
	}

	public void alterarCliente(Cliente entidade) throws Exception{
		try{
			if(!entidade.getUsuario().getLogin().trim().equals("")){
			this.verificarLogin(entidade.getUsuario().getLogin());
			}
		}catch(NoResultException ex){
		daoCliente.alterar(entidade);
		}catch(Exception x){
			throw new Exception(x.getMessage());
		}
	}


	public void remover(Cliente entidade)throws Exception{
		try{
			daoCliente.remover(entidade);
			}catch(Exception x){
				throw new Exception(x.getMessage());
			}
		
	}


	public Cliente consultarPorId(Integer id)throws Exception{
		try{
			return daoCliente.consultarPorId(id);
			}catch(Exception x){
				throw new Exception(x.getMessage());
			}
	}


	public List<Cliente> consultarTodosClientes() throws Exception{
		try{
			return daoCliente.consultarTodos();
			}catch(Exception x){
				throw new Exception(x.getMessage());
			}
	}


	public Cliente localizarClientePeloFone(String fone) throws Exception{
		try{
			return daoCliente.localizarClientePeloFone(fone);
			}catch(Exception x){
				throw new Exception(x.getMessage());
			}
	}


	public List<Cliente> localizarClientePeloNome(String nome) throws Exception{
		try{
			return daoCliente.localizarClientePeloNome(nome);
			}catch(Exception x){
				throw new Exception(x.getMessage());
			}
	}


	public Cliente localizarClientePeloCpf(String cpf) throws Exception{
		try{
			return daoCliente.localizarClientePeloCpf(cpf);
			}catch(Exception x){
				throw new Exception(x.getMessage());
			}
	}

	
	/*
	 * **********************************
	 *  MÉTODOS REFERENTES AO FUNCIONÁRIO
	 * **********************************
	 * */



	public void inserir(Funcionario entidade) throws Exception {
		try{
			this.verificarCpf(entidade.getCpf());
			this.verificarRg(entidade.getRg());
			if(!entidade.getUsuario().getLogin().trim().equals("")){
			this.verificarLogin(entidade.getUsuario().getLogin());
			}
		}catch(NoResultException ex){
			daoFuncionario.inserir(entidade);
		}catch(Exception x){
			throw new Exception(x.getMessage());
		}
		
	}

	public void alterar(Funcionario entidade) throws Exception {
		try{
			this.verificarCpf(entidade.getCpf());
			this.verificarRg(entidade.getRg());
			if(!entidade.getUsuario().getLogin().trim().equals("")){
			this.verificarLogin(entidade.getUsuario().getLogin());
			}
		}catch(NoResultException ex){
			daoFuncionario.alterar(entidade);
		}catch(Exception x){
			throw new Exception(x.getMessage());
		}
		
	}


	public void remover(Funcionario entidade) throws Exception {
		try{
			daoFuncionario.remover(entidade);
		}catch(Exception x){
			throw new Exception(x.getMessage());
		}
		
	}




	public List<Funcionario> consultarTodos() throws Exception {
	try{	
		return daoFuncionario.consultarTodos();
		
	}catch(Exception x){
			throw new Exception(x.getMessage());
		}
	}
	
	/*
	 * **********************************
	 *  MÉTODOS REFERENTES AO FUNCIONÁRIO
	 * **********************************
	 * */

}
