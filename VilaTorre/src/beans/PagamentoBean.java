package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fachadas.Fachada;

import basicas.*;
import basicas.Pagamento.*;


@ManagedBean
public class PagamentoBean {

	private Pagamento pagamento = new Pagamento();
	
	private Pedido pedido = new Pedido();
	
	private FormaPagamento[] formas;
	
	private FormaPagamento forma;
	
	private String desconto;
	
	private Bandeira[] bandeiras;
	
	private Bandeira bandeira;
	
	private List<Pedido> pedidosAbertos = new ArrayList<Pedido>();
	
	private List<Pagamento> pagamentos = new ArrayList<Pagamento>();
	
	
	public PagamentoBean(){}
	
	public String pagar(Pedido param){
		try{
		pedido = param;	
		pedido.setStatus_aberto(false);
		pedido.setFechamento_pedido(new Date());
		pagamento.setId(null);
		pagamento.setForma_pagamento(forma);
		pagamento.setBandeira(bandeira);
		desconto = desconto.replace(".", "");
		desconto = desconto.replace("", ".");
		pagamento.setDesconto(Double.parseDouble(desconto));
		pagamento.setValor_pago(pedido.getValor_total() - pagamento.getDesconto());
		Fachada.getInstancia().alterarPedido(pedido);
		for(ItemPedido it : pedido.getLista_itens()){
			for(Ingrediente ing : it.getProduto().getIngredientes()){
				Estoque est = Fachada.getInstancia().localizarEstoqueMateria(ing.getMateriaPrima());
				est.setQuantidade(est.getQuantidade() - (ing.getQuantidade() * it.getQtd()));
				Fachada.getInstancia().alterarEstoque(est);
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pedido finalizado com êxito."));
		pagamento.setPedido(pedido);
		Fachada.getInstancia().inserirPagamento(pagamento);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pagamento efetuado com êxito."));
		pedido = new Pedido();
		pagamento = new Pagamento();
		desconto = new String();
		return null;
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage()));
			return null;
		}
		
	}


	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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


	public List<Pagamento> getPagamentos() {
		try {
			return Fachada.getInstancia().consultarTodosPagamento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
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


	public FormaPagamento[] getFormas() {
		return FormaPagamento.values();
	}


	public Bandeira[] getBandeiras() {
		return Bandeira.values();
	}


	public String getDesconto() {
		return desconto;
	}


	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}
	
	
	
	
}
