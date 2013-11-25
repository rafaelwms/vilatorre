package dados;

import java.util.*;
import basicas.*;
import dados.IDAOGenerico;

public interface IDAOFornecedor extends IDAOGenerico<Fornecedor> {
	
	public List<Fornecedor> listarFornecedoresPorProduto(MateriaPrima materia) throws Exception;
	
	
}
