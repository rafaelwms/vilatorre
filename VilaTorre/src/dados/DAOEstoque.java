package dados;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import basicas.Cliente;
import basicas.Estoque;
import basicas.MateriaPrima;

public class DAOEstoque extends DAOGenerico<Estoque> implements IDAOEstoque{

	@Override
	public void deduzirEstoque(Estoque estoque, double qtd) throws Exception {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void alimentarEstoque(Estoque estoque, double qtd) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Estoque localizarEstoqueMateria(MateriaPrima materia) throws Exception {
	try{
		TypedQuery<Estoque> query = entityManager.createQuery("from Estoque e where e.materia = :mat", Estoque.class);
		query.setParameter("mat", materia);
		return (Estoque) query.getSingleResult();
		}catch(NoResultException x){
			return null;
		}
	}


	
}
