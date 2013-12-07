package basicas;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class ProdIngr implements Serializable{
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="produto",referencedColumnName="id")
	private Produto produto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ingrediente",referencedColumnName="id")
	private Ingrediente ingrediente;
	
	public ProdIngr(){}
	
	public ProdIngr(Produto produto, Ingrediente ingrediente){
		this.setProduto(produto);
		this.setIngrediente(ingrediente);
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

}
