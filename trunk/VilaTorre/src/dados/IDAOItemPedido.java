package dados;

import java.util.List;

import basicas.*;

public interface IDAOItemPedido {
	
	public List<ItemPedido> listarItemsDoPedido(Pedido pedido) throws Exception;
	

}
