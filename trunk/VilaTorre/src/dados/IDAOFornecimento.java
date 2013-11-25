package dados;

import java.util.List;


import basicas.*;

public interface IDAOFornecimento extends IDAOGenerico<Fornecimento>{

	 public List<Fornecimento> localizarFornecimentoMateria(MateriaPrima materia)throws Exception;
	 
	 public List<Fornecimento> localizarMateriasFornecedor(Fornecedor fornecedor)throws Exception;
	 
	 public List<Fornecimento> localizarMateriasRangePreco(MateriaPrima materia, double de, double ate)throws Exception;
	
}
