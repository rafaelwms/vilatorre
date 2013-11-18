package dadosHumana;

import javax.persistence.*;

import iDAOHumana.IDAOPessoa;
import comum.Pessoa;

import dados.Generico.DAOGenerico;

public class DAOPessoa extends DAOGenerico<Pessoa> implements IDAOPessoa{

	@Override
	public Pessoa logarPessoa(String login, String senha) {
		try{
		TypedQuery<Pessoa> query = entityManager.createQuery("from Pessoa p where p.login = :login and p.senha = :senha", Pessoa.class);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		return (Pessoa) query.getSingleResult();
		}catch(Exception ex){
			return null;
		}
	}

	//M�todo desnecess�rio, uma vez que qualquer altera��o pode estar sendo feita pelo alterar gen�rico.
	@Override
	public void mudarSenha(Pessoa pessoa, String novaSenha) {
		pessoa.getUsuario().setSenha(novaSenha);
		this.alterar(pessoa);
	}

}
