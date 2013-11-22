package negocio;



import java.util.List;

import basicas.Cliente;
import dados.DAOCliente;
import dados.IDAOCliente;

public class NegocioComum{
	
	private IDAOCliente daoCliente;
	
	public NegocioComum(){
		this.daoCliente = new DAOCliente();
	}

	public String validarString(String texto, String objeto, String atributo, int de, int ate, String artigoObjeto, String artigoAtributo) throws Exception {
		if (de == ate) {

			if (texto.trim().length() != ate) {

				return(artigoAtributo.toUpperCase() + " "
						+ atributo + " d" + artigoObjeto.toLowerCase() + " "
						+ objeto + " deve conter " + de + " caracteres.");
			}

		} else {

			if ((texto.trim().length() < de) || (texto.trim().length() > ate)) {

				return(artigoAtributo.toUpperCase() + " "
						+ atributo + " d" + artigoObjeto.toLowerCase() + " "
						+ objeto + " deve conter de " + de + " a " + ate
						+ " caracteres.");
			}
		}
		return null;
	}


	public void inserirCliente(Cliente entidade){
		daoCliente.inserir(entidade);
		
	}

	public void alterarCliente(Cliente entidade) {
		daoCliente.alterar(entidade);
		
	}


	public void remover(Cliente entidade){
		// TODO Auto-generated method stub
		
	}


	public Cliente consultarPorId(Integer id){
		// TODO Auto-generated method stub
		return null;
	}


	public List<Cliente> consultarTodosClientes() {
		return null;
	}


	public Cliente localizarClientePeloFone(String fone){
		// TODO Auto-generated method stub
		return null;
	}


	public List<Cliente> localizarClientePeloNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}


	public Cliente localizarClientePeloCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

}
