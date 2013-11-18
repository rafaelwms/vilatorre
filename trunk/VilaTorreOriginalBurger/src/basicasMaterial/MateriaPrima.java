package basicasMaterial;

import javax.persistence.*;
import comum.*;

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
	
		
	
	protected enum Unidade{g, kg, qtd}



	public Unidade getUnidade() {
		return unidade;
	}


	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	

}
