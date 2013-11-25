package dados;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import basicas.*;

public class DAOFornecimento extends DAOGenerico<Fornecimento> implements IDAOFornecimento{

	@Override
	public List<Fornecimento> localizarFornecimentoMateria(MateriaPrima materia) throws Exception{
	try{	
		TypedQuery<Fornecimento> query = entityManager.createQuery("from Fornecimento fm where fm.materia = :mat", Fornecimento.class);
		query.setParameter("mat", materia.getId());
		return  query.getResultList();
		}catch(NoResultException x){
			return null;
		}
	}

	@Override
	public List<Fornecimento> localizarMateriasFornecedor(Fornecedor fornecedor) throws Exception{
	try{	
		TypedQuery<Fornecimento> query = entityManager.createQuery("from Fornecimento fm where fm.fornecedor = :forn", Fornecimento.class);
		query.setParameter("forn", fornecedor.getId());
		return  query.getResultList();
		}catch(NoResultException x){
			return null;
		}
	}

	@Override
	public List<Fornecimento> localizarMateriasRangePreco(MateriaPrima materia, double de, double ate) throws Exception {
		try{	
			TypedQuery<Fornecimento> query = entityManager.createQuery("from Fornecimento fm where fm.materia = :mat and fm.preco between :inicio and :fim", Fornecimento.class);
			query.setParameter("mat", materia.getId());
			query.setParameter("inicio", de);
			query.setParameter("fim", ate);
			return  query.getResultList();
			}catch(NoResultException x){
				return null;
			}
	}

}
