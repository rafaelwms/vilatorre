package beans;

import javax.faces.bean.*;
import basicas.*;

@ManagedBean
@SessionScoped
public class LoginBean {
	
	private String login;
	private String senha;
	private Pessoa logado;
	
	
	public String tentarLogar(){
		
 	if((login.equals("rafael"))&&(senha.equals("wms"))){

			
			return "/loginSucedido.xhtml?faces-redirect=true";
		}else{
			return "/sefu.xhtml?faces-redirect=true";
		}
	}
	
	
	public String telaCliente(){
		
		return "/telaCliente.xhtml?faces-redirect=true";
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
	public Pessoa getUsuarioLogado() {
		return logado;
	}
	public void setUsuarioLogado(Pessoa logado) {
		this.logado = logado;
	}

}
