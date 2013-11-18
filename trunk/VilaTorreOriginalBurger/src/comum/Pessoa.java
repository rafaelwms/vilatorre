package comum;

import java.util.*;
import javax.persistence.*;

import basicasHumana.Usuario;

@Entity
public abstract class Pessoa extends ObjetoGeral{
	
	@Temporal(TemporalType.DATE)
	private Date nasc;
	
	@Column(length=14)
	private String cpf;
	
	@Column(length=12)
	private String rg;
	
	@Embedded
	private Endereco endereco;
	
	@Embedded
	private Usuario usuario;
	
	@Column(length=13)
	private String fonePrincipal;
	
	@Column(length=13)
	private String foneSecundario;
	
	
	public Pessoa(){}


	public Date getNasc() {
		return nasc;
	}


	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public String getFonePrincipal() {
		return fonePrincipal;
	}


	public void setFonePrincipal(String fonePrincipal) {
		this.fonePrincipal = fonePrincipal;
	}


	public String getFoneSecundario() {
		return foneSecundario;
	}


	public void setFoneSecundario(String foneSecundario) {
		this.foneSecundario = foneSecundario;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
