import dados.*;
import fachadas.Fachada;
import basicas.*;

public class Testes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			String teste = "1.000,00";
			
			teste = teste.replace(".", "");
			teste = teste.replace("," ,".");
			
			System.out.println(teste);
		
			String   testeString = "Substituir ' por * ";
			String   tempString = testeString.replace( '\'', '*' );
			System.out.println( "Original = " + testeString );
			System.out.println( "Resultado   = " + tempString ); 

		//	Leia mais em: Substituindo e removendo caracteres http://www.devmedia.com.br/substituindo-e-removendo-caracteres/2831#ixzz2m9rNfGWX

	}

}
