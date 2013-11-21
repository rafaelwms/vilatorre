package basicasVendas;

import java.util.*;

import javax.persistence.*;


@Entity
public class Pedido {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date abertura_pedido;
	
	@ManyToOne
	@JoinTable(name="itens_pedido", joinColumns={@JoinColumn(name="pedido_id", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="item_id", referencedColumnName="id")})
	private List<ItemPedido> lista_itens;
	
	@Column
	private boolean status_aberto;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=true)
	private Date fechamento_pedido;
	
	@Enumerated(EnumType.STRING)
	private TipoPedido tipo_pedido;
	
	@Column(nullable=true)
	private int num_mesa;
	
	
	private enum TipoPedido{Mesa, Viagem, DeliveryFone, DeliverySite}
	
	@Column(nullable=false)
	private double valor_total;
	
	@Embedded
	private Pagamento pagamento;
	
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


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	



}
