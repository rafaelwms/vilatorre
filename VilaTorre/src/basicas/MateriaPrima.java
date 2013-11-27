package basicas;

import javax.persistence.*;


@Entity
public class MateriaPrima extends ObjetoGeral{
	
	
	
	@Enumerated(EnumType.STRING)
	private Unidade unidade;
	
	public MateriaPrima(){}
	
	public MateriaPrima(String nome, String descricao, Unidade unidade){
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setUnidade(unidade);
	}
	
		
	
	public enum Unidade{g, kg, unidade}



	public Unidade getUnidade() {
		return unidade;
	}


	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	

}
