package beans;

import java.util.List;

import basicas.*;
import basicas.MateriaPrima.Unidade;

import javax.faces.bean.ManagedBean;

import fachadas.Fachada;




@ManagedBean
public class MateriaPrimaBean {
	
	private MateriaPrima materia = new MateriaPrima();
	private Unidade[] unidade;
	private List<MateriaPrima> materias;
	
	
	
	public MateriaPrima getMateria() {
		return materia;
	}
	public void setMateria(MateriaPrima materia) {
		this.materia = materia;
	}
	public Unidade[] getUnidade(){	
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

	
	

}
