package basicasVendas;

import javax.persistence.*;

import basicasMaterial.Produto;

/*
 * 
 * Eu não sei se seria interessante persistir os ítens do pedido. Provavelmente deva ser necessário.
 * 
 */

@Entity
public class ItemPedido {
	
	@OneToMany
	private Pedido pedido;
	
	@Column
	private int numOrdem;
	
	//@ManyToOne?? 
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
	
}
