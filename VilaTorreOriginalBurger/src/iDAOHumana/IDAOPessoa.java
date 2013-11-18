package iDAOHumana;

import comum.Pessoa;
import dados.Generico.*;

public interface IDAOPessoa extends IDAOGenerico<Pessoa> {

	public Pessoa logarPessoa(String login, String senha);

	public void mudarSenha(Pessoa pessoa, String novaSenha);

}
