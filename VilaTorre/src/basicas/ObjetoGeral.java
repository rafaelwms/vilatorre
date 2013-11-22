package basicas;

import javax.persistence.*;

@MappedSuperclass
public abstract class ObjetoGeral {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length=120)
	private String nome;
	
	@Column(length=255)
	private String descricao;
	
	public ObjetoGeral(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	


}
