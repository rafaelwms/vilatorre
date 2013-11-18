package dadosHumana;

import java.util.List;

import javax.persistence.TypedQuery;

import basicasHumana.Cliente;
import iDAOHumana.IDAOCliente;
import dados.Generico.DAOGenerico;

public class DAOCliente extends DAOGenerico<Cliente> implements IDAOCliente{

	@Override
	public Cliente localizarClientePeloFone(String fone) {
		try{
		TypedQuery<Cliente> query = entityManager.createQuery("from Cliente p where c.fonePrincipal = :fone", Cliente.class);
		query.setParameter("fone", fone);
		return (Cliente) query.getSingleResult();
		}catch(Exception ex){
			return null;
		}
	}

	@Override
	public List<Cliente> localizarClientePeloNome(String nome) {
		try{
		TypedQuery<Cliente> query = entityManager.createQuery("from Cliente p where c.nome = :nome", Cliente.class);
		query.setParameter("nome", nome);
		return query.getResultList();
		}catch(Exception ex){
			return null;
		}
	}

	@Override
	public Cliente localizarClientePeloCpf(String cpf) {
		try{
		TypedQuery<Cliente> query = entityManager.createQuery("from Cliente p where c.cpf = :cpf", Cliente.class);
		query.setParameter("cpf", cpf);
		return (Cliente) query.getSingleResult();
		}catch(Exception ex){
			return null;
		}
	}
	
	

}
