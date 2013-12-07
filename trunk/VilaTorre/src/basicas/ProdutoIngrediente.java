package basicas;

import javax.persistence.*;

@Entity
public class ProdutoIngrediente {
	
	@EmbeddedId
	private ProdIngr chave;
	
	public ProdutoIngrediente(){}

	public ProdIngr getChave() {
		return chave;
	}

	public void setChave(ProdIngr chave) {
		this.chave = chave;
	}
	
	

}
