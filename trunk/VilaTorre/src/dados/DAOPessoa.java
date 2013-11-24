package dados;

import javax.persistence.TypedQuery;

import basicas.Pessoa;

public class DAOPessoa extends DAOGenerico<Pessoa> implements IDAOPessoa{

	@Override
	public Pessoa logarPessoa(String login, String senha) {
		TypedQuery<Pessoa> query = entityManager.createQuery("from Pessoa p where p.usuario.login = :loginn and p.usuario.senha= : senhaa", Pessoa.class);
		query.setParameter("loginn", login);
		query.setParameter("senhaa", senha);
		return (Pessoa) query.getSingleResult();
	}

	@Override
	public Pessoa verificarLogin(String login) throws Exception {
		TypedQuery<Pessoa> query = entityManager.createQuery("from Pessoa p where p.usuario.login = :loginn", Pessoa.class);
		query.setParameter("loginn", login);
		return (Pessoa)query.getSingleResult();
	}

	@Override
	public Pessoa verificarFone(String fone) throws Exception {
		TypedQuery<Pessoa> query = entityManager.createQuery("from Pessoa p where p.fone = :fone", Pessoa.class);
		query.setParameter("fone", fone);
		return (Pessoa)query.getSingleResult();
	}

	@Override
	public Pessoa verificarCpf(String cpf) throws Exception {
		TypedQuery<Pessoa> query = entityManager.createQuery("from Pessoa p where p.cpf = :cpff", Pessoa.class);
		query.setParameter("cpff", cpf);
		return (Pessoa)query.getSingleResult();
	}

	@Override
	public Pessoa verificarRg(String rg) throws Exception {
		TypedQuery<Pessoa> query = entityManager.createQuery("from Pessoa p where p.rg = :rgg", Pessoa.class);
		query.setParameter("rgg", rg);
		return (Pessoa)query.getSingleResult();
	}





}
