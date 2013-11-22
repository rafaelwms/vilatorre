package basicas;

import javax.persistence.*;


@Entity
public class ItemPedido{
	
	@Id
	@GeneratedValue
	private Integer id_item;
	
	@ManyToOne
	@JoinColumn(name="pedido", referencedColumnName="id_pedido")
	private Pedido pedido;
	
	@Column
	private int numOrdem;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@JoinColumn(name="id_produto", referencedColumnName="id")
	private Produto produto;
	
	@Column
	private int qtd;
	
	@Column
	private double totalItem;
	
	public ItemPedido(){}
	
	public ItemPedido(Pedido pedido, Produto produto, int qtd){
		this.setPedido(pedido);
		this.setProduto(produto);
		this.setQtd(qtd);
		this.setNumOrdem(pedido.getLista_itens().size() + 1);
		this.setTotalItem(qtd * produto.getPreco());
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getNumOrdem() {
		return numOrdem;
	}

	public void setNumOrdem(int numOrdem) {
		this.numOrdem = numOrdem;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(double totalItem) {
		this.totalItem = totalItem;
	}

	public Integer getId_item() {
		return id_item;
	}

	public void setId_item(Integer id_item) {
		this.id_item = id_item;
	}
	
}
