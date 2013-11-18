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

	//Método desnecessário, uma vez que qualquer alteração pode estar sendo feita pelo alterar genérico.
	@Override
	public void mudarSenha(Pessoa pessoa, String novaSenha) {
		pessoa.getUsuario().setSenha(novaSenha);
		this.alterar(pessoa);
	}

}
