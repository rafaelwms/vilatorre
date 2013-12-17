package basicas;

import javax.persistence.*;



@Embeddable
public class Usuario {
	

	@Column(length=30, nullable=true, unique=true)
	private String login;
	
	@Column(length=30, nullable=true, unique=false)
	private String senha;
	
	@Column(nullable=true)
	@Enumerated(EnumType.STRING)
	private TipoUser tipoUser;
	
	public enum TipoUser{Selecione, ADMINISTRADOR, USUÁRIO, CLIENTE}
	
	public Usuario(){}
	
	public Usuario(String login, String senha, TipoUser tipoUser){
		this.setLogin(login);
		this.setSenha(senha);
		this.setTipoUser(tipoUser);
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
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

	public TipoUser getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(TipoUser tipoUser) {
		this.tipoUser = tipoUser;
	}

	
}
