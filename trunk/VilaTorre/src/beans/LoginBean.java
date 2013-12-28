package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import fachadas.Fachada;

import basicas.*;
import basicas.Usuario.TipoUser;

@ManagedBean
@SessionScoped
public class LoginBean {
	
	private String login;
	private String senha;
	private Pessoa logado = new Funcionario();
	
	
	public String tentarLogar(){
		String retorno = "";
		
		try{
			
		if(login == null || login.trim().equals("")){
			FacesContext.getCurrentInstance().addMessage("loginTry", new FacesMessage("Login vazio."));
			return null;
		}
		else if (senha == null || senha.trim().equals("")){
			FacesContext.getCurrentInstance().addMessage("loginTry", new FacesMessage("Senha vazia."));
			return null;
		} else {
		
			Pessoa log = Fachada.getInstancia().logarPessoa(login, senha);
			
			if(log.getId() == null || log.getId() < 1){
				throw new Exception("");
			}else{
			
				
		logado = log;		
		
		 
		 if(logado.getUsuario().getTipoUser() == TipoUser.ADMINISTRADOR)
			 retorno = "template/adminTemplate.xhtml?faces-redirect=true";
		 
		 if(logado.getUsuario().getTipoUser() == TipoUser.USUÁRIO)
			 retorno = "engine/user.xhtml?faces-redirect=true";
		 
		 if(logado.getUsuario().getTipoUser() == TipoUser.CLIENTE)
			 retorno = "engine/cliente.xhtml?faces-redirect=true";
		}
			return retorno;
		}
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage("loginTry", new FacesMessage("Login ou senha inválidos."));
			return null;
		}
		
	}
	
	
//	public String telaCliente(){
//		
//		return "cliente/telaCliente.xhtml?faces-redirect=true";
//	}
	
	
	public String efetuarLogoff(){
		
		logado = null;
		
		return "../index.xhtml?faces-redirect=true";
	}

	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Pessoa getLogado() {
		return logado;
	}
	public void setLogado(Pessoa logado) {
		this.logado = logado;
	}

}
