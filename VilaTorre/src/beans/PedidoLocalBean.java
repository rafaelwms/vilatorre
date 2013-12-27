package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import fachadas.Fachada;

import basicas.*;
import basicas.Pagamento.Bandeira;
import basicas.Pagamento.FormaPagamento;
import basicas.Pedido.TipoPedido;

@ManagedBean
public class PedidoLocalBean {
	
	
	private Pedido pedidoSelecionado = new Pedido();
	
	private Pedido pedido = new Pedido();
	
	private Pagamento pagamento = new Pagamento();
	
	private int condicao;
	
	private FormaPagamento forma;
	
	private FormaPagamento[] formas;
	
	private Cliente cliente = new Cliente();
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	private Bandeira bandeira;
	
	private Bandeira[] bandeiras;
	
	private String desconto = new String();
	
	private List<Pedido> todosPedidos = new ArrayList<Pedido>();
	
	private List<Pedido> pedidosAbertos = new ArrayList<Pedido>();
	
	private List<Pedido> pedidosAbertos2 = new ArrayList<Pedido>();
	
	private Produto produto = new Produto();
	
	private List<Produto> produtos = new ArrayList<Produto>();
	
	private ItemPedido item = new ItemPedido();
	
	private ItemPedido itemSelecionado = new ItemPedido();
	
	private List<ItemPedido> itemsPedido = new ArrayList<ItemPedido>();
	
	private TipoPedido[] tipos;
	
	private TipoPedido tipoPedido;
	
	private int qtd;
	
	private int mesa;
	
	public PedidoLocalBean(){}
	
	
	public String selecionarPedido(Pedido paramm){
		
		pedidoSelecionado = paramm;
		
		return null;
	}
	
	public String selecionarItem(ItemPedido para){
		
		itemSelecionado = para;
		
		return null;
	}
	
	

	public String abrirPedido(){
		
		try{
			
			if (tipoPedido == TipoPedido.Selecione){
				throw new Exception("É necessário selecionar o tipo de pedido.");
			}
			
			if(tipoPedido == TipoPedido.Delivery){
				if(cliente == null){
					throw new Exception("É necessário selecionar um cliente para o Delivery.");
				}
			}
			
			if(qtd < 1){
				throw new Exception("Quantidade inválida.");
			}
			
			pedido.setTipo_pedido(tipoPedido);
			
			pedido.setId_pedido(null);
			item.setId_item(null);
			item.setProduto(produto);	
			item.setQtd(qtd);
			item.setNumOrdem(1);	
			pedido.setAbertura_pedido(new Date());
			pedido.setNum_mesa(mesa);
			pedido.setStatus_aberto(true);			
			itemsPedido.add(item);
			pedido.setLista_itens(itemsPedido);
			pedido.setValor_total(item.getTotalItem());
			item.setPedido(pedido);
			Fachada.getInstancia().inserirPedido(pedido);
			produto = new Produto();
			pedido = new Pedido();
			item = new ItemPedido();
			tipoPedido = TipoPedido.Selecione;
			cliente = new Cliente();
			itemsPedido = new ArrayList<ItemPedido>();
			mesa = 0;
			qtd = 0;
			return null;
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage()));
			produto = new Produto();
			pedido = new Pedido();
			item = new ItemPedido();
			tipoPedido = TipoPedido.Selecione;
			cliente = new Cliente();
			itemsPedido = new ArrayList<ItemPedido>();
			mesa = 0;
			qtd = 0;
			return null;	
		}
	}
	
	
	public String addItem(Pedido para1){
		try{
			
			if(produto == null){
				throw new Exception("É necessário escolher um produto");
			}
			
			if(qtd <1 ){
				throw new Exception("Quantidade inválida.");
			}
			
			
			
		item.setId_item(null);
		item.setPedido(para1);
		int numOrdem = 1;
		for(ItemPedido it : para1.getLista_itens()){
			
			if(numOrdem <= it.getNumOrdem()){
				numOrdem = (it.getNumOrdem() + 1);
			}
			
		}
		item.setNumOrdem(numOrdem);
		item.setProduto(produto);	
		item.setQtd(qtd);
		item.setTotalItem(item.getProduto().getPreco() * item.getQtd());
		Fachada.getInstancia().adicionarItemPedido(para1, item);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item adicionado com êxito."));
		produto = new Produto();
		pedido = new Pedido();
		item = new ItemPedido();
		itemsPedido = new ArrayList<ItemPedido>();
		tipoPedido = TipoPedido.Selecione;
		mesa = 0;
		qtd = 0;
		return "/vendas/telaVendasLocal.xhtml?faces-redirect=true";
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage()));
			return null;
		}
	}
	
	
	public String delItem(ItemPedido inter){
		try{
			
			if(inter == null){
				throw new Exception("Porra de item nullo carallho!!");
			}
	
		Fachada.getInstancia().removerItemPedido(inter.getPedido(), inter);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item removido com êxito."));
		produto = new Produto();
		pedido = new Pedido();
		item = new ItemPedido();
		itemsPedido = new ArrayList<ItemPedido>();
		tipoPedido = TipoPedido.Selecione;
		mesa = 0;
		qtd = 0;
		return "/vendas/telaVendasLocal.xhtml?faces-redirect=true";
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage()));
			return null;
		}
	}
	
	
	public String cancelarPedido(Pedido param){
		
		
		try {
			param.setCancelado(true);
			param.setFechamento_pedido(new Date());
			param.setStatus_aberto(false);
			Fachada.getInstancia().alterarPedido(param);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pedido Cancelado com êxito."));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			e.printStackTrace();
		}
		
		
		return null;
	}

	
	
	public String pagar(Pedido param){
		try{
			
			if(forma == FormaPagamento.Selecione){
				throw new Exception("É necessário selecionar uma forma de pagamento.");
			}
			
			if((forma == FormaPagamento.CRÉDITO)  && (bandeira == Bandeira.Selecione)){
				throw new Exception("Para pagamento em crédito é necessário escolher uma bandeira.");
			}
			
			if((forma == FormaPagamento.DÉBITO)  && (bandeira == Bandeira.Selecione)){
				throw new Exception("Para pagamento em débito é necessário escolher uma bandeira.");
			}
			
			if(!desconto.trim().equals("")){
				desconto = desconto.replace(".", "");
				desconto = desconto.replace(",", ".");
				pagamento.setDesconto(Double.parseDouble(desconto));				
			}else{
				pagamento.setDesconto(0);
			}
				pagamento.setId(null);
				pagamento.setForma_pagamento(forma);
				pagamento.setValor_pago(param.getValor_total() - pagamento.getDesconto());
				
			if(forma == FormaPagamento.DÉBITO || forma == FormaPagamento.CRÉDITO){
					pagamento.setBandeira(bandeira);
			}else{
					pagamento.setBandeira(null);
			}
				pagamento.setHora_pagamento(new Date());
				pagamento.setPedido(param);
				
			if(condicao == 0){			
				param.setFechamento_pedido(new Date());
				param.setStatus_aberto(false);
				pagamento.setValor_pago(param.getValor_total());
				Fachada.getInstancia().alterarPedido(param);
				Fachada.getInstancia().inserirPagamento(pagamento);
			}else{
				
				if(desconto.trim().equals("")){
					throw new Exception("Para pagamento parcial é necessário setar o valor pago no campo desconto.");
				}
				
				param.setValor_total(param.getValor_total() - pagamento.getDesconto());
				pagamento.setValor_pago(pagamento.getDesconto());
				Fachada.getInstancia().alterarPedido(param);
				Fachada.getInstancia().inserirPagamento(pagamento);
			}
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pagamento efetuado com êxito."));
				forma = FormaPagamento.Selecione;
				bandeira = Bandeira.Selecione;
				condicao = 0;
				desconto = "";

			return null;
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage()));
			forma = FormaPagamento.Selecione;
			bandeira = Bandeira.Selecione;
			condicao = 0;
			desconto = "";
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


	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}


	public FormaPagamento getForma() {
		return forma;
	}


	public void setForma(FormaPagamento forma) {
		this.forma = forma;
	}


	public Bandeira getBandeira() {
		return bandeira;
	}


	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}


	public String getDesconto() {
		return desconto;
	}


	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}


	public FormaPagamento[] getFormas() {
		return FormaPagamento.values();
	}


	public Bandeira[] getBandeiras() {
		return Bandeira.values();
	}


	public int getCondicao() {
		return condicao;
	}


	public void setCondicao(int condicao) {
		this.condicao = condicao;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Cliente> getClientes() {
		try {
			return Fachada.getInstancia().consultarTodosCliente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	public Pedido getPedidoSelecionado() {
		return pedidoSelecionado;
	}


	public void setPedidoSelecionado(Pedido pedidoSelecionado) {
		this.pedidoSelecionado = pedidoSelecionado;
	}


	public List<Pedido> getPedidosAbertos2() {
		pedidosAbertos2 = new ArrayList<Pedido>();
		try{
			for(Pedido check: Fachada.getInstancia().consultarTodosPedido()){
				if(check.isStatus_aberto() == true){
					pedidosAbertos2.add(check);
				}
			}
			return pedidosAbertos2;
		}catch(Exception ex){
			return null;
		}
	}


	public void setPedidosAbertos2(List<Pedido> pedidosAbertos2) {
		this.pedidosAbertos2 = pedidosAbertos2;
	}


	public ItemPedido getItemSelecionado() {
		return itemSelecionado;
	}


	public void setItemSelecionado(ItemPedido itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}
	

}
