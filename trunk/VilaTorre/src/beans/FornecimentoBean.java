package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import util.Datas;

import fachadas.Fachada;

import basicas.*;

@ManagedBean
public class FornecimentoBean {
	
	
	private Fornecedor fornecedor = new Fornecedor();
	
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	
	private MateriaPrima materia = new MateriaPrima();
	
	private List<MateriaPrima> materias = new ArrayList<MateriaPrima>();

	private String valor = new String();
	
	private Fornecimento fornecimento = new Fornecimento();
	
	private List<Fornecimento> fornecimentos = new ArrayList<Fornecimento>();
	
	
	
	public FornecimentoBean() {}
	
	
	public String salvar(){
		
		fornecimento.setFornecedor(fornecedor);
		fornecimento.setMateria(materia);
		valor = valor.replace(".", "");
		valor = valor.replace(",", ".");
		fornecimento.setPreco(Double.parseDouble(valor));
		
		try{
			
			if (fornecimento.getFornecedor().getId() == null || fornecimento.getFornecedor().getId() < 1){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("É necessário selecionar um fornecedor."));
				return null;
			}
			if (fornecimento.getMateria().getId() == null || fornecimento.getMateria().getId() < 1){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("É necessário selecionar uma Matéria Prima."));
				return null;
			}			
			if(fornecimento.getPreco() < 0){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Valor abaixo de zero."));
				return null;
			}
			

				
			
			
			if(fornecimento.getId() == null || fornecimento.getId() < 1){
				fornecimento.setId(null);
				Fachada.getInstancia().inserirFornecimento(fornecimento);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fornecimento inserido com êxito."));
				fornecedor = new Fornecedor();
				materia = new MateriaPrima();
				fornecimento = new Fornecimento();
				valor = new String();
				return null;
				
			}else{
				
				Fachada.getInstancia().alterarFornecimento(fornecimento);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fornecimento alterado com êxito."));
				fornecedor = new Fornecedor();
				materia = new MateriaPrima();
				fornecimento = new Fornecimento();
				valor = new String();
				return null;
			}
			
		}catch(Exception ex){
			
			return null;
		}
	}
	
	
	public String editar (Fornecimento param){
		
		this.fornecimento = param;
		this.valor = Datas.double2MoneyString(param.getPreco());
		this.fornecedor = param.getFornecedor();
		this.materia = param.getMateria();
		
		System.out.println(fornecimento);
		System.out.println(valor);
		System.out.println(fornecedor);
		System.out.println(materia);
		
		return null;
	}
	
	
	public String excluir(Fornecimento parm){
		
		try {
			Fachada.getInstancia().removerFornecimento(parm);
			fornecedor = new Fornecedor();
			materia = new MateriaPrima();
			fornecimento = new Fornecimento();
			valor = new String();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		try {
			return Fachada.getInstancia().consultarTodosFornecedor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
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


	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Fornecimento getFornecimento() {
		return fornecimento;
	}

	public void setFornecimento(Fornecimento fornecimento) {
		this.fornecimento = fornecimento;
	}

	public List<Fornecimento> getFornecimentos() {
		try {
			return Fachada.getInstancia().consultarTodosFornecimento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setFornecimentos(List<Fornecimento> fornecimentos) {
		this.fornecimentos = fornecimentos;
	}
	
	
	
	

}
