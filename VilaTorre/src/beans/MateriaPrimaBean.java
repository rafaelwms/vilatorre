package beans;

import java.util.ArrayList;
import java.util.List;

import basicas.*;
import basicas.MateriaPrima.Unidade;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fachadas.Fachada;




@ManagedBean
public class MateriaPrimaBean {
	
	private MateriaPrima materia = new MateriaPrima();
	private Unidade unid;
	private Unidade[] unidades;
	private List<MateriaPrima> materias = new ArrayList<MateriaPrima>();
	
	
	public String salvar(){
		try{
			
			if (materia.getId() == null || materia.getId() < 0){
				
				materia.setUnidade(unid);
				Fachada.getInstancia().inserirMateriaPrima(materia);
				FacesContext.getCurrentInstance().addMessage("cadastroMat", new FacesMessage("Materia prima "+materia.getNome()+" cadastrada com êxito."));
				materia = new MateriaPrima();
				unid.values();
				return null;
			}else{
				
				materia.setUnidade(unid);
				Fachada.getInstancia().alterarMateriaPrima(materia);
				FacesContext.getCurrentInstance().addMessage("cadastroMat", new FacesMessage("Materia prima "+materia.getNome()+" cadastrada com êxito."));
				materia = new MateriaPrima();
				return null;
			}

		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage("cadastroMat", new FacesMessage(ex.getMessage()));
			return null;
		}
	
	}
	
	public String editar(MateriaPrima param){
		this.materia = param;
		this.unid = param.getUnidade();
		
		System.out.println(materia);
		System.out.println(unid);
		
		return null;
	}
	
	public String remover(MateriaPrima param){
		try{
			
			Fachada.getInstancia().removerMateriaPrima(param);
			FacesContext.getCurrentInstance().addMessage("cadastroMat", new FacesMessage("Materia prima "+materia.getNome()+" removida com êxito."));
			
		}catch(Exception ex){
			
		}
		
		
		return null;
	}
	
	public MateriaPrima getMateria() {
		return materia;
	}
	public void setMateria(MateriaPrima materia) {
		this.materia = materia;
	}
	public Unidade[] getUnidades(){	
		return Unidade.values();
	}
	public List<MateriaPrima> getMaterias() {
		try{
		return Fachada.getInstancia().consultarTodosMateriaPrima();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}
	public void setMaterias(List<MateriaPrima> materias) {
		this.materias = materias;
	}




	public Unidade getUnid() {
		return unid;
	}




	public void setUnid(Unidade unid) {
		this.unid = unid;
	}

	
	

}
