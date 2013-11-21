package basicasMaterial;

import javax.persistence.*;

import basicasHumana.*;

@Embeddable
public class MateriaPrimaEFornecedor {

	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="materia_id")
	private MateriaPrima materia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedor;

	
	public MateriaPrimaEFornecedor(){}
	
	public MateriaPrimaEFornecedor(MateriaPrima materia, Fornecedor fornecedor){
		this.setMateria(materia);
		this.setFornecedor(fornecedor);
	}

	public MateriaPrima getMateria() {
		return materia;
	}

	public void setMateria(MateriaPrima materia) {
		this.materia = materia;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	

}
