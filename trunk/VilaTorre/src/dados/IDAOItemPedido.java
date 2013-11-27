package dados;

import java.util.List;

import basicas.*;

public interface IDAOItemPedido extends IDAOGenerico<ItemPedido>{
	
	public List<ItemPedido> listarItemsDoPedido(Pedido pedido) throws Exception;
	

}
