package dados;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import basicas.Ingrediente;
import basicas.Produto;


public class DAOProduto extends DAOGenerico<Produto> implements IDAOProduto{

	@Override
	public List<Produto> procurarProdutosPorIngrediente(Ingrediente ingrediente) throws Exception {
		
		try{	
			TypedQuery<Produto> query = entityManager.createQuery("from Produto p where p.ingrediente = :mat", Produto.class);
			query.setParameter("mat", ingrediente.getId());
			return  query.getResultList();
			}catch(NoResultException x){
				return null;
			}
	}

	@Override
	public List<Produto> procurarProdutoPorPreco(double preco) throws Exception {
		try{	
			TypedQuery<Produto> query = entityManager.createQuery("from Produto p where p.preco <= :mat", Produto.class);
			query.setParameter("mat", preco);
			return  query.getResultList();
			}catch(NoResultException x){
				return null;
			}
	}

	@Override
	public List<Produto> procurarProdutosPorCategoria(String cat) throws Exception{
	try{	
		TypedQuery<Produto> query = entityManager.createQuery("from Produto p where p.categoria = :mat", Produto.class);
		query.setParameter("mat", cat);
		return  query.getResultList();
		}catch(NoResultException x){
			return null;
		}
	}

}
