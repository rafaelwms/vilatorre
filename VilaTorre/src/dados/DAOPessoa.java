package dados;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import basicas.Pessoa;

public class DAOPessoa extends DAOGenerico<Pessoa> implements IDAOPessoa {

	@Override
	public Pessoa logarPessoa(String login, String senha) {
		try {
			TypedQuery<Pessoa> query = entityManager
					.createQuery(
							"from Pessoa p where p.usuario.login = :log and p.usuario.senha = :sen",
							Pessoa.class);
			query.setParameter("log", login);
			query.setParameter("sen", senha);
			return (Pessoa) query.getSingleResult();
		} catch (NoResultException x) {
			return null;
		}
	}

	@Override
	public Pessoa verificarLogin(String login) throws Exception {
		try {
			TypedQuery<Pessoa> query = entityManager.createQuery(
					"from Pessoa p where p.usuario.login = :loginn",
					Pessoa.class);
			query.setParameter("loginn", login);
			return (Pessoa) query.getSingleResult();
		} catch (NoResultException x) {
			return null;
		}
	}

	@Override
	public Pessoa verificarFone(String fone) throws Exception {
		try {
			TypedQuery<Pessoa> query = entityManager.createQuery(
					"from Pessoa p where p.fone = :fone", Pessoa.class);
			query.setParameter("fone", fone);
			return (Pessoa) query.getSingleResult();
		} catch (NoResultException x) {
			return null;
		}
	}

	@Override
	public Pessoa verificarCpf(String cpf) throws Exception {
		try {
			TypedQuery<Pessoa> query = entityManager.createQuery(
					"from Pessoa p where p.cpf = :cpff", Pessoa.class);
			query.setParameter("cpff", cpf);
			return (Pessoa) query.getSingleResult();
		} catch (NoResultException x) {
			return null;
		}
	}

	@Override
	public Pessoa verificarRg(String rg) throws Exception {
		try {
			TypedQuery<Pessoa> query = entityManager.createQuery(
					"from Pessoa p where p.rg = :rgg", Pessoa.class);
			query.setParameter("rgg", rg);
			return (Pessoa) query.getSingleResult();
		} catch (NoResultException x) {
			return null;
		}
	}

}
