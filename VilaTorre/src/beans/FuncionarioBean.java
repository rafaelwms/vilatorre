package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fachadas.Fachada;

import util.Datas;

import basicas.*;

@ManagedBean
public class FuncionarioBean {
	
	private Funcionario func;
	private Usuario usuario;
	private Endereco endereco;
	private Cargo cargo;
	private String admissao;
	private String demissao;
	private String nasc;
	private String salario;
	
	public String salvar(){
		
		try{
			ValidacoesDeTela.validarString(func.getNome(), "func", "nome", 6, 130, "o", "o");
			ValidacoesDeTela.validarString(func.getFone(), "func", "fone", 13, 13, "o", "o");
			ValidacoesDeTela.validarString(func.getCpf(), "func", "cpf", 14, 14, "o", "o");
			ValidacoesDeTela.validarString(func.getUsuario().getLogin(), "func", "login", 6, 30, "o", "o");
			ValidacoesDeTela.validarString(func.getUsuario().getSenha(), "func", "senha", 6, 30, "o", "a");
	
			func.setAdmissao(Datas.criarData(admissao));
			func.setDemissao(Datas.criarData(demissao));
			func.setNasc(Datas.criarData(nasc));
			func.setSalario(Double.parseDouble(salario));
			func.setCargo(cargo);
			func.setUsuario(usuario);
			endereco.setCidade("Recife");
			endereco.setUf("PE");
			func.setEndereco(endereco);
			
			
			
			if(func.getId() == null || func.getId() ==0){
				
				Fachada.getInstancia().inserirFuncionario(func);
				FacesContext.getCurrentInstance().addMessage("cadastroFunc", new FacesMessage("Cadadstro de " + func.getNome() + " efetuado com sucesso."));
				
				func = new Funcionario();
				endereco = new Endereco();
				cargo = new Cargo();
				usuario = new Usuario();
				
				return  null;
			}else{
				
				Fachada.getInstancia().alterarFuncionario(func);
				FacesContext.getCurrentInstance().addMessage("cadastroFunc", new FacesMessage("Alteração de " + func.getNome() + " efetuada com sucesso."));
				
				func = new Funcionario();
				endereco = new Endereco();
				cargo = new Cargo();
				usuario = new Usuario();
				
				return  null;
				
			}				
			
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage("exceptionFunc", new FacesMessage(ex.getMessage()));
		}
		
		
		return null;
	}
	
	public String  remover(){
		try{
		if (func.getId() != null && func.getId() > 0) {

			Fachada.getInstancia().removerFuncionario(func);
			FacesContext.getCurrentInstance().addMessage("cadastroCli", new FacesMessage("Cadastro de removido com sucesso."));
			func = new Funcionario();
			usuario = new Usuario();
			endereco = new Endereco();
			nasc = "";
			return null;

		}else{
			FacesContext.getCurrentInstance().addMessage("cadastroCli", new FacesMessage("Seleicione um func para remoção."));
			return null;
		}
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage("exceptionCli", new FacesMessage(ex.getMessage()));
		}
		
		return null;
	}
	
	public String reset(){
		func = new Funcionario();
		endereco = new Endereco();
		cargo = new Cargo();
		usuario = new Usuario();
		
		return  null;
	}
	
	public Funcionario getFunc() {
		return func;
	}
	public void setFunc(Funcionario func) {
		this.func = func;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public String getAdmissao() {
		return admissao;
	}
	public void setAdmissao(String admissao) {
		this.admissao = admissao;
	}
	public String getDemissao() {
		return demissao;
	}
	public void setDemissao(String demissao) {
		this.demissao = demissao;
	}
	public String getNasc() {
		return nasc;
	}
	public void setNasc(String nasc) {
		this.nasc = nasc;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


}
