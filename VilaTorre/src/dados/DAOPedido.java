package dados;

import basicas.ItemPedido;
import basicas.Pedido;

public class DAOPedido extends DAOGenerico<Pedido> implements IDAOPedido{

	@Override
	public void removerItemPedido(Pedido pedido, ItemPedido item) throws Exception {
		try{
		pedido.getLista_itens().remove(item);
		this.alterar(pedido);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public void adicionarItemPedido(Pedido pedido, ItemPedido item)	throws Exception {
		try{
			pedido.getLista_itens().add(item);
			this.alterar(pedido);
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		
	}

}
