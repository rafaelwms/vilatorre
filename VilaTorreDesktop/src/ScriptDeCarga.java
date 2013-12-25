import util.Datas;
import dados.DAOCargo;
import dados.DAOFornecedor;
import dados.DAOFuncionario;
import dados.DAOIngrediente;
import dados.DAOMateriaPrima;
import dados.DAOProduto;
import basicas.*;
import basicas.Usuario.TipoUser;


public class ScriptDeCarga {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			DAOFuncionario daoFunc = new DAOFuncionario();
			DAOCargo daoCargo = new DAOCargo();
			
			TipoUser tipo = TipoUser.ADMINISTRADOR;
			
			Usuario user1 = new Usuario();
			user1.setLogin("rafaelwms");
			user1.setSenha("wms1978");
			user1.setTipoUser(tipo);
			
			Cargo cargo = new Cargo();
			cargo.setNome("Analista");
			daoCargo.inserir(cargo);
			
			
			Endereco endereco = new Endereco();
			endereco.setLogradouro("Rua José Bonifácio");
			endereco.setNumero("1356");
			endereco.setComplemento("101 C");
			endereco.setBairro("Torre");
			endereco.setCidade("Recife");
			endereco.setUf("PE");
			
			Funcionario func1 = new Funcionario();
			func1.setId(null);
			func1.setNome("Rafael WMS");
			func1.setFone("(81)9925-2751");
			func1.setId(null);
			func1.setNasc(Datas.criarData("11/04/1978"));
			func1.setAdmissao(Datas.criarData("28/12/2013"));
			func1.setRg("232323232");
			func1.setCpf("232.323.232-32");
			func1.setUsuario(user1);
			func1.setEndereco(endereco);
			func1.setCargo(cargo);
			
			daoFunc.inserir(func1);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
