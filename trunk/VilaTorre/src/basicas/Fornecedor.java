package basicas;

import java.util.*;
import util.*;

import javax.persistence.*;



@Entity
@PrimaryKeyJoinColumn(name="id_fornecedor", referencedColumnName="id_pessoa")
public class Fornecedor extends Pessoa{
	
	@Temporal(TemporalType.DATE)
	private Date inicioParceria;
	
	public Fornecedor(){}
	
	public Fornecedor(String nome, int dia, int mes, int ano, int diaAdm, int mesAdm, int anoAdm, String cpf, String rg, String fonePrincipal, Endereco endereco ){
		this.setNome(nome);
		this.setNasc(Datas.criarData(dia, mes, ano));
		this.setInicioParceria(Datas.criarData(diaAdm, mesAdm, anoAdm));
		this.setCpf(cpf);
		this.setRg(rg);
		this.setFone(fonePrincipal);
		
		this.setEndereco(endereco);
	}

	public Date getInicioParceria() {
		return inicioParceria;
	}

	public void setInicioParceria(Date inicioParceria) {
		this.inicioParceria = inicioParceria;
	}

}
