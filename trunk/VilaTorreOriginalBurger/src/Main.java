import comum.Endereco;
import dadosHumana.DAOCliente;
import dados.Generico.*;
import basicasHumana.Cliente;




public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endereco end = new Endereco();
		end.setLogradouro("Rua");
		end.setNumero("13");
		end.setCidade("hellcife");
		end.setUf("Fu");
		Cliente cli = new Cliente("Rafa", 11, 4, 78, "030.328.534-60", "5307268", "(81)9925.2751", "rafael@rafael", end);
		
		DAOCliente dao = new DAOCliente();
		try{
		dao.inserir(cli);
		}catch(Exception x){
			System.out.println(x.getMessage());
		}
		
		
	}

}
