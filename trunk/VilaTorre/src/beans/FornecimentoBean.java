package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import fachadas.Fachada;

import basicas.*;

@ManagedBean
public class FornecimentoBean {
	
	
	private Fornecedor fornecedor = new Fornecedor();
	
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	
	private MateriaPrima materia = new MateriaPrima();
	
	private List<MateriaPrima> materias = new ArrayList<MateriaPrima>();
	
	private MateriaPrimaEFornecedor matforn = new MateriaPrimaEFornecedor();
	
	private String valor = new String();
	
	private Fornecimento fornecimento = new Fornecimento();
	
	private List<Fornecimento> fornecimentos = new ArrayList<Fornecimento>();
	
	
	
	public FornecimentoBean() {}
	
	

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		try {
			return Fachada.getInstancia().consultarTodosFornecedor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public MateriaPrima getMateria() {
		return materia;
	}

	public void setMateria(MateriaPrima materia) {
		this.materia = materia;
	}

	public List<MateriaPrima> getMaterias() {
		try {
			return Fachada.getInstancia().consultarTodosMateriaPrima();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setMaterias(List<MateriaPrima> materias) {
		this.materias = materias;
	}

	public MateriaPrimaEFornecedor getMatforn() {
		return matforn;
	}

	public void setMatforn(MateriaPrimaEFornecedor matforn) {
		this.matforn = matforn;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Fornecimento getFornecimento() {
		return fornecimento;
	}

	public void setFornecimento(Fornecimento fornecimento) {
		this.fornecimento = fornecimento;
	}

	public List<Fornecimento> getFornecimentos() {
		try {
			return Fachada.getInstancia().consultarTodosFornecimento();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setFornecimentos(List<Fornecimento> fornecimentos) {
		this.fornecimentos = fornecimentos;
	}
	
	
	
	

}
