package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fachadas.Fachada;

import basicas.*;

@ManagedBean
public class EstoqueBeans {

	
	private Estoque estoque = new Estoque();
	
	private MateriaPrima materia = new MateriaPrima();
	
	private String quantidade = new String();
	
	private String max = new String();
	
	private String min = new String();
	

	
	private List<MateriaPrima> materias = new ArrayList<MateriaPrima>();
	
	private List<Estoque> estoques = new ArrayList<Estoque>();
	
	
	public EstoqueBeans(){}
	
	
	public String salvar(){
	try{
		
		estoque.setMin(Double.parseDouble(min));
		estoque.setMax(Double.parseDouble(max));
		estoque.setQuantidade(Double.parseDouble(quantidade));
		estoque.setMateria_prima(materia);
		estoque.setAtualizacao(new Date());
		estoque.setLogin("Teste");

		if(estoque.getId() == null || estoque.getId() < 1){
			estoque.setId(null);
			Fachada.getInstancia().inserirEstoque(estoque);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estoque para "+estoque.getMateria().getNome()+" gerado com êxito."));
			estoque = new Estoque();
			min = new String();
			max = new String();
			quantidade = new String();
			materia = new MateriaPrima();
			return null;
			
		} else{
			
			Fachada.getInstancia().alterarEstoque(estoque);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estoque de " +estoque.getMateria().getNome()+ " alterado com êxito."));
			estoque = new Estoque();
			min = new String();
			max = new String();
			quantidade = new String();
			materia = new MateriaPrima();
			return null;
			
		}
		
	}catch(Exception ex){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage()));
		return null;
	}

	}
	
	
	public String editar(Estoque param){
		
		this.estoque = param;
		this.materia = param.getMateria();
		this.max = param.getMax()+"";
		this.min = param.getMin()+"";
		this.quantidade = param.getQuantidade()+"";
		
		System.out.println(estoque);
		System.out.println(materia);
		System.out.println(max);
		System.out.println(min);
		System.out.println(quantidade);
		
		return null;
	}
	
	public String excluir(Estoque param){
		
		try {
			Fachada.getInstancia().removerEstoque(param);
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	
	public String percentual(Estoque param){
		String retorno;
		double percent = (param.getQuantidade() * 100) / param.getMax();
		retorno = (int) percent+"";
		return retorno;
	}
	
	

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public MateriaPrima getMateria() {
		return materia;
	}

	public void setMateria(MateriaPrima materia) {
		this.materia = materia;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}





	public List<MateriaPrima> getMaterias() {
		try {
			return Fachada.getInstancia().consultarTodosMateriaPrima();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}





	public void setMaterias(List<MateriaPrima> materias) {
		this.materias = materias;
	}





	public List<Estoque> getEstoques() {
		try {
			return Fachada.getInstancia().consultarTodosEstoque();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}





	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}


	public String getMax() {
		return max;
	}


	public void setMax(String max) {
		this.max = max;
	}


	public String getMin() {
		return min;
	}


	public void setMin(String min) {
		this.min = min;
	}
	
	
	
	
	
}
