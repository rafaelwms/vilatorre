package iDAOHumana;

import java.util.*;
import basicasHumana.*;
import basicasMaterial.*;
import dados.Generico.IDAOGenerico;

public interface IDAOFornecedor extends IDAOGenerico<Fornecedor> {
	
	public List<Fornecedor> listarFornecedoresPorProduto(Produto produto) throws Exception;
	
	
}
