package comum;

import javax.persistence.*;

@Embeddable
public class Endereco {
	
	@Column(length=150, nullable=false)
	private String logradouro;
	
	@Column(length=30, nullable=false)
	private String numero;
	
	@Column(length=50, nullable=true)
	private String complemento;
	
	@Column(length=50, nullable=false)
	private String bairro;
	
	@Column(length=50, nullable=false)
	private String cidade;
	
	@Column(length=2, nullable=false)
	private String uf;
	
	public Endereco(){}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	

}

