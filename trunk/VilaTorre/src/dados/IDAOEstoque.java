package dados;

import basicas.*;

public interface IDAOEstoque extends IDAOGenerico<Estoque>{
	
	public void deduzirEstoque(MateriaPrima mat, double qtd) throws Exception;
	
	public void alimentarEstoque(MateriaPrima mat, double qtd) throws Exception;

}
