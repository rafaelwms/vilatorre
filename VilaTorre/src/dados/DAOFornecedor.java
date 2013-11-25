package dados;

import java.util.List;

import javax.persistence.TypedQuery;

import basicas.Cliente;
import basicas.Fornecedor;
import basicas.Fornecimento;
import basicas.MateriaPrima;
import basicas.Produto;

public class DAOFornecedor extends DAOGenerico<Fornecedor> implements IDAOFornecedor{

	@Override
	public List<Fornecedor> listarFornecedoresPorProduto(MateriaPrima materia ){
	TypedQuery<Fornecedor> query = entityManager.createQuery("from Fornecedor f inner join Fornecimento fm on fm.fornecedor = f.id_fornecedor where fm.materia  = :materia", Fornecedor.class);
	query.setParameter("materia", materia.getId());
	return query.getResultList();
	}

}
