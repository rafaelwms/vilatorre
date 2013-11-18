package basicasMaterial;

import javax.persistence.*;

import comum.*;

@Entity
public class Produto extends ObjetoGeral  {
	
	@Column
	private double preco;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	/*
	 * A questão de dedução do estoque ficou em Stand By segundo Chico. 
	 * Pois, este era o motivo da lista de ingredientes.
	 */
	//private List<Ingrediente> ingredientes;
	
	public enum Categoria{Bebidas, Burgers, SuperBurgers, Salgados, Sobremesa}


	public Produto(){}
	
	public Produto(String nome, String desc, double preco){}
	
	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


}
