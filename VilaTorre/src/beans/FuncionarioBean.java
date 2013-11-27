package beans;

import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import negocio.ValidacoesDeTela;

import fachadas.Fachada;

import util.Datas;

import basicas.*;
import basicas.Usuario.TipoUser;

@ManagedBean
public class FuncionarioBean {
	
	private Funcionario func = new Funcionario();
	private Usuario usuario = new Usuario();
	private Endereco endereco = new Endereco();
	private Cargo cargoEscolhido = new Cargo();
	private String admissao;
	private String demissao;
	private String nasc;
	private String salario;
	private List<Cargo> cargos = new ArrayList<Cargo>();
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private TipoUser[] tipos;
	private TipoUser tipouser;
	
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
			func.setCargo(cargoEscolhido);
			func.setUsuario(usuario);
			endereco.setCidade("Recife");
			endereco.setUf("PE");
			func.setEndereco(endereco);
			
			
			
			if(func.getId() == null || func.getId() ==0){
				
				Fachada.getInstancia().inserirFuncionario(func);
				FacesContext.getCurrentInstance().addMessage("cadastroFunc", new FacesMessage("Cadadstro de " + func.getNome() + " efetuado com sucesso."));
				
				func = new Funcionario();
				endereco = new Endereco();
				cargoEscolhido = new Cargo();
				usuario = new Usuario();
				
				return  null;
			}else{
				
				Fachada.getInstancia().alterarFuncionario(func);
				FacesContext.getCurrentInstance().addMessage("cadastroFunc", new FacesMessage("Alteração de " + func.getNome() + " efetuada com sucesso."));
				
				func = new Funcionario();
				endereco = new Endereco();
				cargoEscolhido = new Cargo();
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
	
		public TipoUser[] getTipoUser(){
			return TipoUser.values();
		}		

	
	public String reset(){
		func = new Funcionario();
		endereco = new Endereco();
		cargoEscolhido = new Cargo();
		usuario = new Usuario();
		
		return  null;
	}
	
	public List<Cargo> listarCargos(){
		try{
			cargos = Fachada.getInstancia().consultarTodosCargo();
		return cargos;
		}catch(Exception ex){
			return null;
		}
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
		return cargoEscolhido;
	}
	public void setCargo(Cargo cargo) {
		this.cargoEscolhido = cargo;
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

	public List<Cargo> getCargos() {
		try {
			return Fachada.getInstancia().consultarTodosCargo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public List<Funcionario> getFuncionarios() {
		try{
			funcionarios = Fachada.getInstancia().consultarTodos();
		return funcionarios;
		}catch(Exception x){
			System.out.println(x.getMessage());
			return null;
		}
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}


}
