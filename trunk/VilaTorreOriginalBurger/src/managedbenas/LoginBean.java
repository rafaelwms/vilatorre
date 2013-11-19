package managedbenas;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import basicasHumana.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {
	
	private String login;
	private String senha;
	private Usuario usuarioLogado;
	
	public String tentarLogar(){
		
		if((login.equals("rafael"))&&(senha.equals("wms"))){
			
			return "/loginSucedido.xhtml?faces-redirect=true";
		}else

			return "/sefu.xhtml?faces-redirect=true";
		
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
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
