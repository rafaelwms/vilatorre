package basicas;

import java.util.*;
import javax.persistence.*;

@Entity
@Inheritance(strategy =InheritanceType.JOINED)
public abstract class Pessoa{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pessoa", nullable=false)
	private Integer id_pessoa;
	
	@Column(length=130)
	private String nome;
	
	@Column
	private int sexo;
	
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
	private String fone;
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


	public String getFone() {
		return fone;
	}


	public void setFone(String fone) {
		this.fone = fone;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Integer getId() {
		return id_pessoa;
	}


	public void setId(Integer id_pessoa) {
		this.id_pessoa = id_pessoa;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getSexo() {
		return sexo;
	}


	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	
	

}
