package basicas;

import javax.persistence.*;


@Entity
public class Ingrediente extends ObjetoGeral{
	
	@Column
	private int qtd;
	
	@Enumerated(EnumType.STRING)
	public Medida medida;
	
	@ManyToOne
	@JoinColumn(name="materia", referencedColumnName="id")
	private MateriaPrima materiaPrima;
	
	public enum Medida{gramas, unidade, porção}
	
	public Ingrediente(){}
	
	public Ingrediente(int qtd, MateriaPrima materiaPrima, Medida medida){
		this.setQuantidade(qtd);
		this.setMateriaPrima(materiaPrima);
		this.setMedida(medida);
	}

	public int getQuantidade() {
		return qtd;
	}

	public void setQuantidade(int quantidade) {
		this.qtd = quantidade;
	}

	public Medida getMedida() {
		return medida;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}

	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}


	
	

}
