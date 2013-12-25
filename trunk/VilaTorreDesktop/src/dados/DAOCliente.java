package dados;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import basicas.Cliente;


public class DAOCliente extends DAOGenerico<Cliente> implements IDAOCliente{

	@Override
	public Cliente localizarClientePeloFone(String fone){
		try{
		TypedQuery<Cliente> query = entityManager.createQuery("from Cliente c where c.fone = :fonep", Cliente.class);
		query.setParameter("fonep", fone);
		return (Cliente) query.getSingleResult();
		}catch(NoResultException x){
			return null;
		}
	}

	@Override
	public List<Cliente> localizarClientePeloNome(String nome){
		try{
		TypedQuery<Cliente> query = entityManager.createQuery("from Cliente c where c.nome = :name", Cliente.class);
		query.setParameter("name", nome);
		return query.getResultList();
		}catch(NoResultException x){
			return null;
		}
	}

	@Override
	public Cliente localizarClientePeloCpf(String cpf){	
		try{
		TypedQuery<Cliente> query = entityManager.createQuery("from Cliente c where c.cpf = :cpff", Cliente.class);
		query.setParameter("cpff", cpf);
		return (Cliente) query.getSingleResult();
		}catch(NoResultException x){
			return null;
		}
	}
	
	@Override
	public Cliente verificarEmail(String email) throws Exception {
		try{
		TypedQuery<Cliente> query = entityManager.createQuery("from Cliente c where c.email = :ema", Cliente.class);
		query.setParameter("ema", email);
		return (Cliente)query.getSingleResult();
		}catch(NoResultException x){
			return null;
		}
	}

}
