package negocio;

public class NegocioComum {

	public boolean validarString(String texto, String objeto, String atributo, int de, int ate, String artigoObjeto, String artigoAtributo) throws Exception {
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
		return true;
	}

}
