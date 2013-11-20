package negocio;

import java.util.List;

import dadosHumana.DAOCliente;

import basicasHumana.Cliente;
import iDAOHumana.IDAOCliente;

public class NegocioCliente extends NegocioComum implements IDAOCliente {

	DAOCliente dados = new DAOCliente();
	@Override
	public void inserir(Cliente entidade) throws Exception{
		try {
			
			this.validarString(entidade.getNome(), "cliente", "nome", 10, 130, "o", "o");
			this.validarString(entidade.getCpf(), "cliente", "cpf", 14, 14, "o", "o");
			this.validarString(entidade.getRg(), "cliente", "rg", 7, 12, "o", "o");
			this.validarString(entidade.getFonePrincipal(), "cliente", "fone princiapal", 13, 13, "o", "o");
			this.validarString(entidade.getUsuario().getLogin(), "cliente", "login", 6, 30, "o", "o");
			this.validarString(entidade.getUsuario().getSenha(), "cliente", "senha", 6, 30, "o", "a");
			this.validarString(entidade.getEndereco().getLogradouro(), "endereço", "logradouro", 10, 200, "o", "o");
			this.validarString(entidade.getEndereco().getCidade(), "endereço", "cidade", 4, 30, "o", "a");
			this.validarString(entidade.getEndereco().getBairro(), "endereço", "bairro", 4, 30, "o", "o");
			
			if(dados.localizarClientePeloCpf(entidade.getCpf()) != null){
				throw new Exception("Cpf já cadastrado no sistema.");
			}		
			
			if(dados.localizarClientePeloFone(entidade.getFonePrincipal()) != null){
				throw new Exception("Fone principal já cadastrado no sistema.");
			}
			

			
			dados.inserir(entidade);
			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}

	}

	@Override
	public void alterar(Cliente entidade) throws Exception{
		try {
			
			this.validarString(entidade.getNome(), "cliente", "nome", 10, 130, "o", "o");
			this.validarString(entidade.getCpf(), "cliente", "cpf", 14, 14, "o", "o");
			this.validarString(entidade.getRg(), "cliente", "rg", 7, 12, "o", "o");
			this.validarString(entidade.getFonePrincipal(), "cliente", "fone princiapal", 13, 13, "o", "o");
			this.validarString(entidade.getUsuario().getLogin(), "cliente", "login", 6, 30, "o", "o");
			this.validarString(entidade.getUsuario().getSenha(), "cliente", "senha", 6, 30, "o", "a");
			this.validarString(entidade.getEndereco().getLogradouro(), "endereço", "logradouro", 10, 200, "o", "o");
			this.validarString(entidade.getEndereco().getCidade(), "endereço", "cidade", 4, 30, "o", "a");
			this.validarString(entidade.getEndereco().getBairro(), "endereço", "bairro", 4, 30, "o", "o");
			
			if(dados.localizarClientePeloCpf(entidade.getCpf()).getCpf() != null){
				throw new Exception("Cpf já cadastrado no sistema.");
			}		
			
			if(dados.localizarClientePeloFone(entidade.getFonePrincipal()) != null){
				throw new Exception("Fone principal já cadastrado no sistema.");
			}
			
			
			dados.alterar(entidade);
			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}

	}

	@Override
	public void remover(Cliente entidade) throws Exception{
		// TODO Auto-generated method stub
		try{
			
			if((entidade == null) || (entidade.getId() < 1)){
				throw new Exception("Cliente não selecionado.");
			}
			
			dados.remover(entidade);
			
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}

	}

	@Override
	public Cliente consultarPorId(Integer id) throws Exception{
		try{
			return dados.consultarPorId(id);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public List<Cliente> consultarTodos() throws Exception{
		try{
			return dados.consultarTodos();
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public Cliente localizarClientePeloFone(String fone) throws Exception {
		try{
			return dados.localizarClientePeloFone(fone);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public List<Cliente> localizarClientePeloNome(String nome) throws Exception {
		try{
			return dados.localizarClientePeloNome(nome);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public Cliente localizarClientePeloCpf(String cpf) throws Exception {
		try{
			return dados.localizarClientePeloCpf(cpf);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

}
