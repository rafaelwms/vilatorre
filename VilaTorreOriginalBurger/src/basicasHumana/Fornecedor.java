package basicasHumana;

import java.util.*;
import util.*;

import javax.persistence.*;
import comum.*;

@Entity
public class Fornecedor extends Pessoa{
	
	private Date inicioParceria;
	
	public Fornecedor(){}
	
	public Fornecedor(String nome, int dia, int mes, int ano, int diaAdm, int mesAdm, int anoAdm, String cpf, String rg, String fonePrincipal, String foneSecundario, Endereco endereco ){
		this.setNome(nome);
		this.setNasc(Datas.criarData(dia, mes, ano));
		this.setInicioParceria(Datas.criarData(diaAdm, mesAdm, anoAdm));
		this.setCpf(cpf);
		this.setRg(rg);
		this.setFonePrincipal(fonePrincipal);
		this.setFoneSecundario(foneSecundario);
		this.setEndereco(endereco);
	}

	public Date getInicioParceria() {
		return inicioParceria;
	}

	public void setInicioParceria(Date inicioParceria) {
		this.inicioParceria = inicioParceria;
	}

}
