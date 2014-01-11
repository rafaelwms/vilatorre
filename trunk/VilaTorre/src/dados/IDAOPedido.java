package dados;

import basicas.*;

public interface IDAOPedido extends IDAOGenerico<Pedido>{
	
	public void removerItemPedido(Pedido pedido, ItemPedido item) throws Exception;
	
	public void adicionarItemPedido(Pedido pedido, ItemPedido item) throws Exception;

}
