package iDAOVendas;

import java.util.*;

import basicasHumana.*;
import basicasMaterial.*;
import basicasVendas.*;
import dados.Generico.IDAOGenerico;

public interface interfacePedido extends IDAOGenerico<Pedido> {
	
	//Os métodos abaixo são para o gerenciamento de um Pedido
	public void abrirPedido(ItemPedido itemPedido);
	
	public void adicionarItemPedido(ItemPedido itemPedido);
	
	public void cancelarItemPedido(ItemPedido itemPedido);
	
	public void fecharPedido(Pedido pedido);
	
	public void concederDesconto(Pedido pedido);
	
	//Os métodos abaixo são mais específicos pra o setor Administrativo
	public List<Pedido> localizarPedidoPeloCliente(Cliente cliente);
	
	public List<Pedido> listarPedidosPorData(Date data);
	
	public List<Pedido> listarPedidosPorProduto(Produto produto);
	
}
