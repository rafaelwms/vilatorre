package dados;

import java.util.List;

import javax.persistence.TypedQuery;

import basicas.Cliente;
import basicas.Fornecedor;
import basicas.MateriaPrima;
import basicas.Produto;

public class DAOFornecedor extends DAOGenerico<Fornecedor> implements IDAOFornecedor{

	@Override
	public List<Fornecedor> listarFornecedoresPorProduto(MateriaPrima ){
	TypedQuery<Fornecedor> query = entityManager.createQuery("from Fornecedor f inner join Fornecimento p on f.id_fornecedor = p.fornecedor where p.   = :name", Fornecedor.class);
	query.setParameter("name", nome);
	return query.getResultList();
	}

}
