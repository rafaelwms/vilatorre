package basicas;

import java.io.Serializable;

import javax.persistence.*;


@Embeddable
public class MateriaPrimaEFornecedor implements Serializable{

	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="materia", referencedColumnName="id")
	private MateriaPrima materia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fornecedor", referencedColumnName="id_fornecedor")
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
