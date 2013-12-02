package beans;

import java.text.ParseException;
import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import negocio.ValidacoesDeTela;

import util.Datas;
import basicas.Fornecedor;
import basicas.Endereco;
import fachadas.Fachada;

@ManagedBean
public class FornecedorBean {

	private Fornecedor fornecedor = new Fornecedor();
	private Endereco endereco = new Endereco();
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

	private String nasc;
	private String parceiro;


	public String salvar() {

		try {

			endereco.setCidade("Recife");
			endereco.setUf("PE");
			fornecedor.setEndereco(endereco);
			fornecedor.setUsuario(null);
			fornecedor.setNasc(Datas.criarData(nasc));
			fornecedor.setInicioParceria(Datas.criarData(parceiro));
			
			
			ValidacoesDeTela.validarString(fornecedor.getNome(), "fornecedor", "nome", 6, 130, "o", "o");
			ValidacoesDeTela.validarString(fornecedor.getFone(), "fornecedor", "fone", 13, 13, "o", "o");
			ValidacoesDeTela.validarString(fornecedor.getCpf(), "fornecedor", "cpf", 14, 14, "o", "o");
			
			
			if (fornecedor.getId() == null || fornecedor.getId() < 1) {
				this.fornecedor.setId(null);
				Fachada.getInstancia().inserirFornecedor(fornecedor);
				FacesContext.getCurrentInstance().addMessage("cadastroForn", new FacesMessage("Cadastro de " + fornecedor.getNome() + " efetuado com sucesso."));
				fornecedor = new Fornecedor();
				endereco = new Endereco();
				nasc = new String();
				parceiro = new String();
				return null;

			} else {

				Fachada.getInstancia().alterarFornecedor(fornecedor);
				FacesContext.getCurrentInstance().addMessage("alterForn", new FacesMessage("Cadastro de " + fornecedor.getNome() + " alterado com sucesso."));
				fornecedor = new Fornecedor();
				endereco = new Endereco();
				nasc = new String();
				parceiro = new String();
				return null;
			}
		} catch (ParseException px){
			FacesContext.getCurrentInstance().addMessage("expetionCli", new FacesMessage("Data \""+nasc+"\" incorreta."));
			return null;
		} catch (Exception ex) {
			FacesContext.getCurrentInstance().addMessage("expetionForn", new FacesMessage(ex.getMessage()));
			return null;
		}

	}

	public String reset() {
		fornecedor = new Fornecedor();
		endereco = new Endereco();
		nasc = new String();
		parceiro = new String();
		return null;
	}
	
	public String editar(Fornecedor forn){
		
		this.fornecedor = forn;
		this.endereco = forn.getEndereco();
		this.nasc = Datas.formatarData(forn.getNasc());
		this.parceiro = Datas.formatarData(forn.getInicioParceria());	
		
		System.out.println(fornecedor);
		System.out.println(endereco);
		System.out.println(nasc);
		System.out.println(parceiro);
		return null;
	}
	
	public String  remover(Fornecedor forn){
		try{
			
		if (forn.getId() != null && forn.getId() < 1) {

			Fachada.getInstancia().removerFornecedor(forn);
			FacesContext.getCurrentInstance().addMessage("cadastroForn", new FacesMessage("Cadastro removido com sucesso."));
			fornecedor = new Fornecedor();
			endereco = new Endereco();
			nasc = new String();
			parceiro = new String();
			return null;

		}else{
			FacesContext.getCurrentInstance().addMessage("cadastroForn", new FacesMessage("Seleicione um fornecedor para remoção."));
			return null;
		}
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage("exceptionForn", new FacesMessage(ex.getMessage()));
		}
		
		return null;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNasc() {
		return nasc;
	}

	public void setNasc(String nasc) {
		this.nasc = nasc;
	}


	

	public String getParceiro() {
		return parceiro;
	}

	public void setParceiro(String parceiro) {
		this.parceiro = parceiro;
	}

	public List<Fornecedor> getFornecedores() {
		try {
			fornecedores = Fachada.getInstancia().consultarTodosFornecedor();
			return fornecedores;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
