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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((materia_prima == null) ? 0 : materia_prima.hashCode());
		long temp;
		temp = Double.doubleToLongBits(quantidade);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		if (materia_prima == null) {
			if (other.materia_prima != null)
				return false;
		} else if (!materia_prima.equals(other.materia_prima))
			return false;
		if (Double.doubleToLongBits(quantidade) != Double
				.doubleToLongBits(other.quantidade))
			return false;
		return true;
	}



}
