package basicas;

import javax.persistence.*;

@Entity
public class Estoque {
	
	@Id
	private Integer materia;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private MateriaPrima materia_prima;
	
	private double quantidade;
	
	public Estoque(){}


	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}


	public Integer getId_materia() {
		return materia;
	}


	public void setId_materia(Integer materia) {
		this.materia = materia;
	}



}
