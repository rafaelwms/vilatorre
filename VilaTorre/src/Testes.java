import dados.*;
import fachadas.Fachada;
import basicas.*;

public class Testes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		IDAOCargo daoCargo = new DAOCargo();
		IDAOFuncionario daoFunc = new DAOFuncionario();
		IDAOFornecedor daoForn = new DAOFornecedor();
		
		try{
			for(Cargo c : Fachada.getInstancia().consultarTodosCargo()){
				
				System.out.println(c.getNome());
				
			}
			
			
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		
		

	}

}
