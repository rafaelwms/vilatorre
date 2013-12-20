package basicas;

import java.util.*;

import javax.persistence.*;


@Entity
public class Pagamento{
	
	@Id
	@GeneratedValue
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="pedido", referencedColumnName="id_pedido")
	private Pedido pedido;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private FormaPagamento forma_pagamento;
	
	@Column(nullable=true)
	@Enumerated(EnumType.STRING)
	private Bandeira bandeira;
	
	@Column(nullable=true)
	private String cod_confirmacao;
	
	@Column(nullable=false)
	private double desconto;
	
	@Column(nullable=false)
	private double valor_pago;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date hora_pagamento;
	
	public enum FormaPagamento{Selecione, CRÉDITO, DÉBITO, ESPÉCIE, VOUCHER}
	
	public enum Bandeira{Selecione, AMEX, DINNERS, HIPERCARD, MASTER, TR, VISA}
	
	public Pagamento(){}
	
	public Pagamento(FormaPagamento forma_pagamento, Bandeira bandeira, String cod_confirmacao, double desconto){
		this.setHora_pagamento(new Date());
		this.setForma_pagamento(forma_pagamento);
		this.setBandeira(bandeira);
		this.setCod_confirmacao(cod_confirmacao);
		this.setDesconto(desconto);
		
	}


	public FormaPagamento getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(FormaPagamento forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

	public String getCod_confirmacao() {
		return cod_confirmacao;
	}

	public void setCod_confirmacao(String cod_confirmacao) {
		this.cod_confirmacao = cod_confirmacao;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getValor_pago() {
		return valor_pago;
	}

	public void setValor_pago(double valor_pago) {
		this.valor_pago = valor_pago;
	}

	public Date getHora_pagamento() {
		return hora_pagamento;
	}

	public void setHora_pagamento(Date hora_pagamento) {
		this.hora_pagamento = hora_pagamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
