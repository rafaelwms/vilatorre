package basicasMaterial;

import javax.persistence.*;

@Entity
public class Ingrediente {
	
	@Column
	private int qtd;
	
	@Enumerated(EnumType.STRING)
	private Unidade unidade;
	
	@Embedded
	private MateriaPrima materiaPrima;
	
	private enum Unidade{gramas, unidade, porção}
	
	public Ingrediente(){}
	
	public Ingrediente(int qtd, MateriaPrima materiaPrima, Unidade unidade){
		this.setQuantidade(qtd);
		this.setMateriaPrima(materiaPrima);
		this.setUnidade(unidade);
	}

	public int getQuantidade() {
		return qtd;
	}

	public void setQuantidade(int quantidade) {
		this.qtd = quantidade;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}


	
	

}
