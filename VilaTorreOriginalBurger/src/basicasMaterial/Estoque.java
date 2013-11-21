package basicasMaterial;

import javax.persistence.*;

@Entity
public class Estoque {

	@Id
	@OneToOne
	@JoinColumn(name="materia_id")
	private MateriaPrima materia;
	
	private double quantidade;
	
	public Estoque(){}

	public MateriaPrima getMateria() {
		return materia;
	}

	public void setMateria(MateriaPrima materia) {
		this.materia = materia;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

}
