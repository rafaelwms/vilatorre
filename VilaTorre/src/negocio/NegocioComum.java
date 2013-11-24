package negocio;



import java.util.List;

import basicas.Cliente;
import basicas.Pessoa;
import dados.*;

public class NegocioComum{
	
	private IDAOCliente daoCliente;
	private IDAOPessoa daoPessoa;
	public NegocioComum(){
		this.daoCliente = new DAOCliente();
		this.daoPessoa = new DAOPessoa();
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
	

	public void inserirCliente(Cliente entidade)throws Exception {
		try{
			verificarCpf(entidade.getCpf());
			verificarRg(entidade.getRg());
			verificarEmail(entidade.getEmail());
			if(!entidade.getUsuario().getLogin().trim().equals("")){
			verificarLogin(entidade.getUsuario().getLogin());
			}
		    daoCliente.inserir(entidade);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

	public void alterarCliente(Cliente entidade) throws Exception{
		daoCliente.alterar(entidade);
		
	}


	public void remover(Cliente entidade)throws Exception{
		// TODO Auto-generated method stub
		
	}


	public Cliente consultarPorId(Integer id)throws Exception{
		// TODO Auto-generated method stub
		return null;
	}


	public List<Cliente> consultarTodosClientes() throws Exception{
		return null;
	}


	public Cliente localizarClientePeloFone(String fone) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}


	public List<Cliente> localizarClientePeloNome(String nome) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}


	public Cliente localizarClientePeloCpf(String cpf) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

}
