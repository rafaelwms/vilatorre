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
	private Pessoa logado;
	
	
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
			
		 logado = Fachada.getInstancia().logarPessoa(login, senha);
		 FacesContext.getCurrentInstance().addMessage("loginTry", new FacesMessage("Bem vindo "+logado.getNome()+"."));
		 
		 if(logado.getUsuario().getTipoUser() == TipoUser.ADIM)
			 retorno = "engine/admin.xhtml?faces-redirect=true";
		 
		 if(logado.getUsuario().getTipoUser() == TipoUser.USER)
			 retorno = "engine/user.xhtml?faces-redirect=true";
		 
		 if(logado.getUsuario().getTipoUser() == TipoUser.CLIENTE)
			 retorno = "engine/cliente.xhtml?faces-redirect=true";
		 
		  if(logado.getUsuario().getTipoUser() == TipoUser.DEVELOPER)
			  retorno = "engine/rafaelwms.xhtml?faces-redirect=true";
		  return retorno;
		}
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage("loginTry", new FacesMessage(ex.getMessage()));
			return null;
		}
		
	}
	
	
	public String telaCliente(){
		
		return "cliente/telaCliente.xhtml?faces-redirect=true";
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
