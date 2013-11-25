package beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fachadas.Fachada;

import basicas.Cargo;

@ManagedBean
public class CargoBean {

	private Cargo cargo;
	private List<Cargo> cargos;

	
	
	public CargoBean(){}
	
	
	public String salvar(){

		try{
			if(cargo.getId()== null || cargo.getId() < 1){
				
				System.out.println(cargo.getNome());
				System.out.println(cargo.getDescricao());
				
				Fachada.getInstancia().inserirCargo(cargo);
				FacesContext.getCurrentInstance().addMessage("cadastroCargo", new FacesMessage("Cargo "+cargo.getNome()+" cadastrado com êxito."));
				return null;
			} else{
				
				Fachada.getInstancia().alterarCargo(cargo);
				FacesContext.getCurrentInstance().addMessage("cadastroCargo", new FacesMessage("Cargo "+cargo.getNome()+" alterado com êxito."));
				return null;
				
			}
			
		}catch(Exception x){
			
		}
				
		return null;
	}
	

	public List<Cargo> listarCargos(){
		try{
			setCargos(Fachada.getInstancia().consultarTodosCargo());
		return getCargos();
		}catch(Exception ex){
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
		return cargos;
	}


	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	
	

}
