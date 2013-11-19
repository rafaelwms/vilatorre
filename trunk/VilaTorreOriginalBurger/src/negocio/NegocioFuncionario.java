package negocio;

import java.util.List;

import basicasHumana.Funcionario;
import iDAOHumana.IDAOFuncionario;

public class NegocioFuncionario extends NegocioComum implements IDAOFuncionario{

	@Override
	public void inserir(Funcionario entidade) {
		try{
		this.validarString(entidade.getNome(), "Funcionário", "nome", 10, 130, "o", "o");
		this.validarString(entidade.getCpf(), "Funcionário", "cpf", 14, 14, "o", "o");
		
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
