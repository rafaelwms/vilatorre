package dados;

import basicas.Pessoa;


public interface IDAOPessoa extends IDAOGenerico<Pessoa> {

	public Pessoa logarPessoa(String login, String senha);

	public void mudarSenha(Pessoa pessoa, String novaSenha);

}
