package dados;

import negocio.NegocioCalculos;
import basicas.ItemPedido;
import basicas.Pedido;

public class DAOPedido extends DAOGenerico<Pedido> implements IDAOPedido{
	
	DAOItemPedido daoItem = new DAOItemPedido();


	@Override
	public void removerItemPedido(Pedido pedido, ItemPedido item) throws Exception {
		try{
		pedido.getLista_itens().remove(item);
		item.setPedido(null);
		daoItem.alterar(item);
		NegocioCalculos.calcularPedido(pedido);
		this.alterar(pedido);
		daoItem.remover(item);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public void adicionarItemPedido(Pedido pedido, ItemPedido item)	throws Exception {
		try{
			pedido.getLista_itens().add(item);
			NegocioCalculos.calcularPedido(pedido);
			this.alterar(pedido);
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		
	}

}
