package negocio;

public class ValidacoesDeTela {
	
	public static void validarString(String texto, String objeto, String atributo, int de, int ate, String artigoObjeto, String artigoAtributo) throws Exception {
		if (de == ate) {

			if (texto.trim().length() != ate) {

				throw new Exception(artigoAtributo.toUpperCase() + " "
						+ atributo + " d" + artigoObjeto.toLowerCase() + " "
						+ objeto + " deve conter " + de + " caracteres.");
			}

		} else {

			if ((texto.trim().length() < de) || (texto.trim().length() > ate)) {

				throw new Exception(artigoAtributo.toUpperCase() + " "
						+ atributo + " d" + artigoObjeto.toLowerCase() + " "
						+ objeto + " deve conter de " + de + " a " + ate
						+ " caracteres.");
			}
		}
		
	}
	

	public static void validarEmail(String email, String objeto, String artigo)throws Exception{ 
		if ((!email.trim().contains("@")) && (!email.trim().contains("."))){
			throw new Exception("O e-mail d"+artigo+" "+objeto+" inválido.");
		}
	}

}
