package basicasMaterial;

import java.util.*;

import javax.persistence.*;

import basicasHumana.*;

import comum.ObjetoGeral;

@Entity
public class CompraEstoque extends ObjetoGeral{
	
	@OneToOne
	@JoinColumn(name="id")
	private Fornecedor fornecedor;
	
	@OneToOne
	@JoinColumn(name="id")
	private MateriaPrima materia_prima;
	
	@Column
	private double quantidade;
	
	@Column
	private double valorinvestido;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCompra;
	
	public CompraEstoque(){}

	public CompraEstoque(Fornecedor fornecedor, double quantidade, double valorinvestido){
		
		this.setDataCompra(new Date());
		this.setFornecedor(fornecedor);
		this.setQuantidade(quantidade);
		this.setValorinvestido(valorinvestido);
		
		
	}
	

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public MateriaPrima getMateria_prima() {
		return materia_prima;
	}

	public void setMateria_prima(MateriaPrima materia_prima) {
		this.materia_prima = materia_prima;
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
