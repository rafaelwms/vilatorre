package basicasMaterial;

import javax.persistence.*;

@Entity
public class Fornecimento {
	
	@EmbeddedId
	private MateriaPrimaEFornecedor chaveComp;
	
	@Column(nullable=false)
	private double preco;
	
	public Fornecimento(){}
	
	public Fornecimento(MateriaPrimaEFornecedor mpf, double preco){
		this.setChaveComp(mpf);
		this.setPreco(preco);
	}

	public MateriaPrimaEFornecedor getChaveComp() {
		return chaveComp;
	}

	public void setChaveComp(MateriaPrimaEFornecedor chaveComp) {
		this.chaveComp = chaveComp;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}


}
