package negocio;

import java.util.List;

import basicasHumana.Funcionario;
import iDAOHumana.IDAOFuncionario;

public class NegocioFuncionario extends NegocioComum implements IDAOFuncionario{

	
	@Override
	public void inserir(Funcionario entidade) {
		try{
			this.validarString(entidade.getNome(), "funcionário", "nome", 10, 130, "o", "o");
			this.validarString(entidade.getCpf(), "funcionário", "cpf", 14, 14, "o", "o");
			this.validarString(entidade.getRg(), "funcionário", "rg", 7, 12, "o", "o");
			this.validarString(entidade.getFone(), "funcionário", "fone princiapal", 13, 13, "o", "o");
			this.validarString(entidade.getUsuario().getLogin(), "funcionário", "login", 6, 30, "o", "o");
			this.validarString(entidade.getEndereco().getLogradouro(), "endereço", "logradouro", 10, 200, "o", "o");
			this.validarString(entidade.getEndereco().getCidade(), "endereço", "cidade", 4, 30, "o", "a");
			this.validarString(entidade.getEndereco().getCidade(), "endereço", "cidade", 4, 30, "o", "a");
		
		}catch(Exception ex){
			
		}
		
	}

	@Override
	public void alterar(Funcionario entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Funcionario entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funcionario consultarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
