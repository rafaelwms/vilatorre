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

	private TipoUser tipos;
	
	public String salvar(){
		
		try{

	
			
			if(demissao != null){
				func.setDemissao(Datas.criarData(demissao));
			}
			func.setAdmissao(Datas.criarData(admissao));	
			func.setNasc(Datas.criarData(nasc));
			salario = salario.replace(".", "");
			salario = salario.replace(",", ".");
			func.setSalario(Double.parseDouble(salario));
			func.setCargo(cargoEscolhido);
			func.setUsuario(usuario);
			endereco.setCidade("Recife");
			endereco.setUf("PE");
			func.setEndereco(endereco);
			
			
			ValidacoesDeTela.validarString(func.getNome(), "func", "nome", 6, 130, "o", "o");
			ValidacoesDeTela.validarString(func.getFone(), "func", "fone", 13, 13, "o", "o");
			ValidacoesDeTela.validarString(func.getCpf(), "func", "cpf", 14, 14, "o", "o");
			ValidacoesDeTela.validarString(func.getUsuario().getLogin(), "func", "login", 6, 30, "o", "o");
			ValidacoesDeTela.validarString(func.getUsuario().getSenha(), "func", "senha", 6, 30, "o", "a");
			
			
			if(func.getId() == null || func.getId()< 1){
				
				this.func.setId(null);
				
				Fachada.getInstancia().inserirFuncionario(func);
				FacesContext.getCurrentInstance().addMessage("cadastroFunc", new FacesMessage("Cadadstro de " + func.getNome() + " efetuado com sucesso."));
				
				func = new Funcionario();
				endereco = new Endereco();
				cargoEscolhido = new Cargo();
				usuario = new Usuario();
				salario = new String();
				nasc = new String();
				admissao = new String();
				demissao = new String();
				return  null;
			
			}else{
				
				Fachada.getInstancia().alterarFuncionario(func);
				FacesContext.getCurrentInstance().addMessage("cadastroFunc", new FacesMessage("Alteração de " + func.getNome() + " efetuada com sucesso."));
				
				func = new Funcionario();
				endereco = new Endereco();
				cargoEscolhido = new Cargo();
				usuario = new Usuario();
				salario = new String();
				nasc = new String();
				admissao = new String();
				demissao = new String();				
				return  null;
				
			}				
			
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage("exceptionFunc", new FacesMessage(ex.getMessage()));
		}
		
		
		return null;
	}
	
	public String  remover(Funcionario funcParam){
		try{
		if (funcParam.getId() != null && funcParam.getId() > 0) {

			Fachada.getInstancia().removerFuncionario(funcParam);
			FacesContext.getCurrentInstance().addMessage("cadastroCli", new FacesMessage("Cadastro de removido com sucesso."));
			func = new Funcionario();
			usuario = new Usuario();
			endereco = new Endereco();
			salario = new String();
			nasc = new String();
			admissao = new String();
			demissao = new String();
			return null;

		}else{
			FacesContext.getCurrentInstance().addMessage("cadastroCli", new FacesMessage("Seleicione um funconário para exclusão."));
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
			
	public void editar(Funcionario funcParam){
		this.func = funcParam;
		this.endereco = funcParam.getEndereco();
		this.usuario = funcParam.getUsuario();
		this.cargoEscolhido = funcParam.getCargo();
		this.nasc = Datas.formatarData(funcParam.getNasc());
		this.admissao = Datas.formatarData(funcParam.getAdmissao());
		this.salario = Datas.double2MoneyString(funcParam.getSalario());
		System.out.println(func);
		System.out.println(endereco);
		System.out.println(usuario);
		System.out.println(cargoEscolhido);
		System.out.println(nasc);
		System.out.println(admissao);
		System.out.println(salario);
	}			

	
	public String reset(){
		func = new Funcionario();
		endereco = new Endereco();
		cargoEscolhido = new Cargo();
		usuario = new Usuario();
		salario = new String();
		nasc = new String();
		admissao = new String();
		demissao = new String();
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
	public Cargo getCargoEscolhido() {
		return cargoEscolhido;
	}
	public void setCargoEscolhido(Cargo cargoEscolhido) {
		this.cargoEscolhido = cargoEscolhido;
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

	public TipoUser getTipos() {
		return tipos;
	}

	public void setTipos(TipoUser tipos) {
		this.tipos = tipos;
	}


}
