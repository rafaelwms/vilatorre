package negociosComum;

import comum.Pessoa;
import dadosHumana.DAOPessoa;

public class negocioLogin {

	public Pessoa login(String login, String senha) throws Exception {
		try {
			DAOPessoa daop = new DAOPessoa();
			if (login.trim().equals("") || login.isEmpty()) {
				throw new Exception("� necess�rio preencher o campo login.");
			}
			if (senha.trim().equals("") || senha.isEmpty()) {
				throw new Exception("� necess�rio preencher o campo senha.");
			}
			if (daop.logarPessoa(login, senha) == null) {
				throw new Exception("Usu�rio ou senha inv�lidos.");
			} else
				return daop.logarPessoa(login, senha);
		} catch (Exception ex) {
			throw new Exception("Excess�o Gen�rica.");
		}

	}

}
