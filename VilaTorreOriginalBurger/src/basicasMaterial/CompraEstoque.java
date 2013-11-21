package basicasMaterial;

import java.util.*;

import javax.persistence.*;

import basicasHumana.*;


@Entity
public class CompraEstoque{
	
	@EmbeddedId
	private MateriaPrimaEFornecedor id;
	
	@Column
	private double quantidade;
	
	@Column
	private double valorinvestido;
	
	@Temporal(TemporalType.DATE)
	private Date dataCompra;
	
	public CompraEstoque(){}

	public CompraEstoque(Fornecedor fornecedor, double quantidade, double valorinvestido){
		
		this.setDataCompra(new Date());
		this.setQuantidade(quantidade);
		this.setValorinvestido(valorinvestido);
		
		
	}
	



	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorinvestido() {
		return valorinvestido;
	}

	public void setValorinvestido(double valorinvestido) {
		this.valorinvestido = valorinvestido;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	

}
