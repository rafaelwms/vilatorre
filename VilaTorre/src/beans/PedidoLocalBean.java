package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import fachadas.Fachada;

import basicas.*;
import basicas.Pedido.TipoPedido;;

@ManagedBean
public class PedidoLocalBean {
	
	private Pedido pedido = new Pedido();
	
	private List<Pedido> todosPedidos = new ArrayList<Pedido>();
	
	private List<Pedido> pedidosAbertos = new ArrayList<Pedido>();
	
	private Produto produto = new Produto();
	
	private List<Produto> produtos = new ArrayList<Produto>();
	
	private ItemPedido item = new ItemPedido();
	
	private List<ItemPedido> itemsPedido = new ArrayList<ItemPedido>();
	
	private TipoPedido[] tipos;
	
	private TipoPedido tipoPedido;
	
	private int qtd;
	
	private int mesa;
	
	public PedidoLocalBean(){}
	
	
	public String abrirPedido(){
		
		try{
			pedido.setId_pedido(null);
			item.setProduto(produto);	
			item.setQtd(qtd);
			item.setNumOrdem(1);
			item.setTotalItem(item.getProduto().getPreco() * item.getQtd());
			Fachada.getInstancia().inserirItemPedido(item);
			
			
			pedido.setAbertura_pedido(new Date());
			tipoPedido = TipoPedido.Mesa;
			pedido.setNum_mesa(mesa);
			pedido.setTipo_pedido(tipoPedido);
			pedido.getLista_itens().add(item);
			pedido.setValor_total(item.getTotalItem());
			Fachada.getInstancia().inserirPedido(pedido);
			
			
			
			return null;
		}catch(Exception ex){
			
			return null;	
		}
	}
	
	
	public String addItem(Pedido para1){
		try{
		item.setNumOrdem(para1.getLista_itens().size() + 1);
		item.setProduto(produto);	
		item.setQtd(qtd);
		item.setTotalItem(item.getProduto().getPreco() * item.getQtd());
		
		para1.getLista_itens().add(item);
		Fachada.getInstancia().alterarPedido(para1);
		produto = new Produto();
		item = new ItemPedido();
		qtd = 0;
		

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item adicionado com êxito."));
		return null;
		}catch(Exception ex){
			return null;
		}
	}
	
	
	

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getTodosPedidos() {
		try {
			return Fachada.getInstancia().consultarTodosPedido();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setTodosPedidos(List<Pedido> todosPedidos) {
		this.todosPedidos = todosPedidos;
	}

	public List<Pedido> getPedidosAbertos() {
		pedidosAbertos = new ArrayList<Pedido>();
		try{
			for(Pedido check: Fachada.getInstancia().consultarTodosPedido()){
				if(check.isStatus_aberto() == true){
					pedidosAbertos.add(check);
				}
			}
			return pedidosAbertos;
		}catch(Exception ex){
			return null;
		}
	}

	public void setPedidosAbertos(List<Pedido> pedidosAbertos) {
		this.pedidosAbertos = pedidosAbertos;
	}

	public ItemPedido getItem() {
		return item;
	}

	public void setItem(ItemPedido item) {
		this.item = item;
	}

	public List<ItemPedido> getItemsPedido() {
		return itemsPedido;
	}

	public void setItemsPedido(List<ItemPedido> itemsPedido) {
		this.itemsPedido = itemsPedido;
	}

	public TipoPedido getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(TipoPedido tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public TipoPedido[] getTipos() {
		return TipoPedido.values();
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public List<Produto> getProdutos() {
		try {
			return Fachada.getInstancia().consultarTodosProduto();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public int getQtd() {
		return qtd;
	}


	public void setQtd(int qtd) {
		this.qtd = qtd;
	}


	public int getMesa() {
		return mesa;
	}


	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	

}
