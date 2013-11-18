package basicasMaterial;

import java.io.Serializable;

import javax.persistence.*;

import basicasHumana.*;

@Embeddable
public class MateriaPrimaEFornecedor  implements Serializable{


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName="id")
	private MateriaPrima materia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName="id")
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
