package basicasHumana;

import java.util.*;

import javax.persistence.*;

import util.Datas;
import comum.*;

@Entity
public class Funcionario extends Pessoa{
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date admissao;
	
	@Column(nullable=true)
	@Temporal(TemporalType.DATE)
	private Date demissao;
	
	@Column(nullable=false)
	private double salario;

	@Embedded
	private Cargo cargo;
	
	public Funcionario(){}
	
	public Funcionario(String nome, int dia, int mes, int ano, int diaAdm, int mesAdm, int anoAdm, String cpf, String rg, String fonePrincipal, String foneSecundario, Endereco endereco ){

		this.setNome(nome);
		this.setNasc(Datas.criarData(dia, mes, ano));
		this.setAdmissao(Datas.criarData(diaAdm, mesAdm, anoAdm));
		this.setCpf(cpf);
		this.setRg(rg);
		this.setFonePrincipal(fonePrincipal);
		this.setFoneSecundario(foneSecundario);
		this.setEndereco(endereco);

	}

	public Date getAdmissao() {
		return admissao;
	}

	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}

	public Date getDemissao() {
		return demissao;
	}

	public void setDemissao(Date demissao) {
		this.demissao = demissao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}


	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	

}
