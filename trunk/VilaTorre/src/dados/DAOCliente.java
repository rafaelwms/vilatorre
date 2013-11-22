package dados;

import java.util.List;

import javax.persistence.TypedQuery;

import basicas.Cliente;


public class DAOCliente extends DAOGenerico<Cliente> implements IDAOCliente{

	@Override
	public Cliente localizarClientePeloFone(String fone){	
		TypedQuery<Cliente> query = entityManager.createQuery("from Cliente c where c.fone = :fonep", Cliente.class);
		query.setParameter("fonep", fone);
		return (Cliente) query.getSingleResult();		
	}

	@Override
	public List<Cliente> localizarClientePeloNome(String nome){
		TypedQuery<Cliente> query = entityManager.createQuery("from Cliente c where c.nome = :name", Cliente.class);
		query.setParameter("name", nome);
		return query.getResultList();	
	}

	@Override
	public Cliente localizarClientePeloCpf(String cpf){	
		TypedQuery<Cliente> query = entityManager.createQuery("from Cliente c where c.cpf = :cpff", Cliente.class);
		query.setParameter("cpff", cpf);
		return (Cliente) query.getSingleResult();
	}
	
	

}
