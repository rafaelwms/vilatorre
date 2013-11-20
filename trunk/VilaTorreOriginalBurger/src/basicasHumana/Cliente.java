package basicasHumana;

import java.util.*;
import javax.persistence.*;

import util.Datas;

import comum.*;


@Entity
public class Cliente extends Pessoa{
	
	@Temporal(TemporalType.DATE)
	private Date cadastro;
	
	private String email;
	
	public Cliente(){}
	
	public Cliente(String nome, int dia, int mes, int ano, String cpf, String rg, String fone, String email, Endereco endereco ){

		this.setCadastro(new Date());
		this.setNome(nome);
		this.setNasc(Datas.criarData(dia, mes, ano));
		this.setCpf(cpf);
		this.setRg(rg);
		this.setFone(fone);
		this.setEmail(email);
		this.setEndereco(endereco);

	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
