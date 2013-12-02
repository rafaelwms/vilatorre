package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fachadas.Fachada;

import basicas.Cargo;

@ManagedBean
public class CargoBean {

	private Cargo cargo = new Cargo();
	private List<Cargo> cargos = new ArrayList<Cargo>();

	
	
	public CargoBean(){}
	
	public void editar(Cargo param){
		this.cargo = param;
		System.out.println(cargo);
	}
	
	public void excluir(Cargo param){
		try{
			Fachada.getInstancia().removerCargo(param);
		}catch(Exception x){}
		
	}
	
	
	public String salvar(){

		try{
			if(cargo.getId()== null || cargo.getId() < 1){	
				this.cargo.setId(null);
				Fachada.getInstancia().inserirCargo(cargo);
				FacesContext.getCurrentInstance().addMessage("cadastroCargo", new FacesMessage("Cargo "+cargo.getNome()+" cadastrado com êxito."));
				cargo = new Cargo();
				return null;
			} else{
				
				Fachada.getInstancia().alterarCargo(cargo);
				FacesContext.getCurrentInstance().addMessage("cadastroCargo", new FacesMessage("Cargo "+cargo.getNome()+" alterado com êxito."));
				cargo = new Cargo();
				return null;
				
			}
			
		}catch(Exception x){
			
		}
				
		return null;
	}
	

	public List<Cargo> listarCargos(){
		try{
			cargos = Fachada.getInstancia().consultarTodosCargo();
		return cargos;
		}catch(Exception ex){
			return null;
		}
	}
	
	public List<Cargo> getColecao(){
		try{
		return Fachada.getInstancia().consultarTodosCargo();
		}catch(Exception x){
			return null;
		}
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}


	public List<Cargo> getCargos() {
		try{
		return Fachada.getInstancia().consultarTodosCargo();
		}catch(Exception x){
			return null;
		}
	}


	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	
	

}
