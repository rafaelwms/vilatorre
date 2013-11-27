package dados;

import basicas.*;

public interface IDAOEstoque extends IDAOGenerico<Estoque>{
	
	public void deduzirEstoque(Estoque estoque, double qtd) throws Exception;
	
	public void alimentarEstoque(Estoque estoque, double qtd) throws Exception;

}
