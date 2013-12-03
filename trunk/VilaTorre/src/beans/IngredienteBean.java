package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fachadas.Fachada;
import basicas.*;
import basicas.Ingrediente.Medida;

import java.util.*;

@ManagedBean
public class IngredienteBean {

	private Ingrediente ingrediente;
	private List<Ingrediente> ingredientes;
	
	private Medida medida;
	private Medida[] medidas;
	
	private MateriaPrima materia;
	private List<MateriaPrima> materias;
	
	
	
	public String salvar(){
		try {
			
			ingrediente.setMateriaPrima(materia);
			
			
			if(ingrediente.getId() == null || ingrediente.getId() < 1){
			ingrediente.setId(null);
			Fachada.getInstancia().inserirIngrediente(ingrediente);	
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ingrediente "+ingrediente.getNome()+" cadastrado com êxito."));
			return null;
			}else{
				Fachada.getInstancia().alterarIngrediente(ingrediente);	
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ingrediente "+ingrediente.getNome()+" alterado com êxito."));
			
			return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String editar(Ingrediente param){
		
		this.ingrediente = param;
		this.materia = param.getMateriaPrima();
		
		System.out.println(ingrediente);
		System.out.println(materia);
		return null;
	}
	
	public String excluir(Ingrediente param){
		try {  
			Fachada.getInstancia().removerIngrediente(param);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ingrediente "+ingrediente.getNome()+" removido com êxito."));			
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	public List<Ingrediente> getIngredientes() {
		
		try {
			return Fachada.getInstancia().consultarTodosIngrediente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public Medida getMedida() {
		return medida;
	}
	public void setMedida(Medida medida) {
		this.medida = medida;
	}
	public MateriaPrima getMateria() {
		return materia;
	}
	public void setMateria(MateriaPrima materia) {
		this.materia = materia;
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
	public Medida[] getMedidas() {
		return Medida.values();
	}

}
