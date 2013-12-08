package basicas;

import javax.persistence.*;

@Entity
public class Fornecimento {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fornecedor", referencedColumnName="id_fornecedor")
	private Fornecedor fornecedor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="materia", referencedColumnName="id")
	private MateriaPrima materia;

	
	@Column(nullable=false)
	private double preco;
	
	public Fornecimento(){}
	


	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Fornecedor getFornecedor() {
		return fornecedor;
	}



	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}



	public MateriaPrima getMateria() {
		return materia;
	}



	public void setMateria(MateriaPrima materia) {
		this.materia = materia;
	}


}
