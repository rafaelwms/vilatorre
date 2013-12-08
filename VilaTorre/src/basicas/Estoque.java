package basicas;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Estoque {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	//@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@OneToOne(fetch=FetchType.EAGER)
	private MateriaPrima materia;
	
	@Column(nullable=true)
	private double quantidade;
	
	@Column(nullable=true)
	private double max;
	
	@Column(nullable=true)
	private double min;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date atualizacao;
	
	@Column
	private String login;
	
	public Estoque(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MateriaPrima getMateria() {
		return materia;
	}

	public void setMateria_prima(MateriaPrima materia) {
		this.materia = materia;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public Date getAtualizacao() {
		return atualizacao;
	}

	public void setAtualizacao(Date atualizacao) {
		this.atualizacao = atualizacao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}