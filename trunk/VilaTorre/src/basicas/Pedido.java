package basicas;

import java.util.*;

import javax.persistence.*;


@Entity
public class Pedido{
	
	@Id
	@GeneratedValue
	private Integer id_pedido;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date abertura_pedido;
	
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> lista_itens;
	
	@Column
	private boolean status_aberto;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechamento_pedido;
	
	@Enumerated(EnumType.STRING)
	private TipoPedido tipo_pedido;
	
	@Column(nullable=true)
	private int num_mesa;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id_cliente", nullable=true)
	private Cliente cliente;
	
	
	@OneToMany
	@JoinTable(name="pedido_pagamento")
	private List<Pagamento> pagamentos;
	
	public enum TipoPedido{Selecione, DeliveryFone, DeliverySite, Mesa, Viagem}
	
	
	private double valor_total;
	
	public Pedido(){}

	public Date getAbertura_pedido() {
		return abertura_pedido;
	}

	public void setAbertura_pedido(Date abertura_pedido) {
		this.abertura_pedido = abertura_pedido;
	}

	public List<ItemPedido> getLista_itens() {
		return lista_itens;
	}

	public void setLista_itens(List<ItemPedido> lista_itens) {
		this.lista_itens = lista_itens;
	}

	public boolean isStatus_aberto() {
		return status_aberto;
	}

	public void setStatus_aberto(boolean status_aberto) {
		this.status_aberto = status_aberto;
	}

	public Date getFechamento_pedido() {
		return fechamento_pedido;
	}

	public void setFechamento_pedido(Date fechamento_pedido) {
		this.fechamento_pedido = fechamento_pedido;
	}

	public TipoPedido getTipo_pedido() {
		return tipo_pedido;
	}

	public void setTipo_pedido(TipoPedido tipo_pedido) {
		this.tipo_pedido = tipo_pedido;
	}

	public int getNum_mesa() {
		return num_mesa;
	}

	public void setNum_mesa(int num_mesa) {
		this.num_mesa = num_mesa;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	



}
