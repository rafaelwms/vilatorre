package dados;

import java.util.List;

import javax.persistence.TypedQuery;

import basicas.ItemPedido;
import basicas.Pedido;

public class DAOItemPedido extends DAOGenerico<ItemPedido> implements IDAOItemPedido{

	@Override
	public List<ItemPedido> listarItemsDoPedido(Pedido pedido) throws Exception {
	TypedQuery<ItemPedido> query = entityManager.createQuery("from ItemPedido i where i.pedido = :ped", ItemPedido.class);
	query.setParameter("ped", pedido);
	return query.getResultList();
	}

}
