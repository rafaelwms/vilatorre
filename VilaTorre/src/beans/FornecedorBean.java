package beans;

import java.text.ParseException;
import java.util.Date;

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

	private String nasc;
	private String parceiro;
	private Date nascimento;
	private Date parceria;

	public String salvar() {

		try {
			nascimento = Datas.criarData(nasc);
			parceria = Datas.criarData(parceiro);
			endereco.setCidade("Recife");
			endereco.setUf("PE");
			fornecedor.setEndereco(endereco);
			fornecedor.setUsuario(null);
			fornecedor.setNasc(nascimento);
			fornecedor.setInicioParceria(parceria);
			
			
			ValidacoesDeTela.validarString(fornecedor.getNome(), "fornecedor", "nome", 6, 130, "o", "o");
			ValidacoesDeTela.validarString(fornecedor.getFone(), "fornecedor", "fone", 13, 13, "o", "o");
			ValidacoesDeTela.validarString(fornecedor.getCpf(), "fornecedor", "cpf", 14, 14, "o", "o");
			
			
			if (fornecedor.getId() == null || fornecedor.getId() == 0) {

				Fachada.getInstancia().inserirFornecedor(fornecedor);
				FacesContext.getCurrentInstance().addMessage("cadastroForn", new FacesMessage("Cadastro de " + fornecedor.getNome() + " efetuado com sucesso."));
				fornecedor = new Fornecedor();
				endereco = new Endereco();
				nasc = "";
				return null;

			} else {

				Fachada.getInstancia().alterarFornecedor(fornecedor);
				FacesContext.getCurrentInstance().addMessage("alterForn", new FacesMessage("Cadastro de " + fornecedor.getNome() + " alterado com sucesso."));
				fornecedor = new Fornecedor();
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
		nasc = "";
		return null;
	}
	
	public String  remover(){
		try{
		if (fornecedor.getId() != null && fornecedor.getId() > 0) {

			Fachada.getInstancia().removerFornecedor(fornecedor);
			FacesContext.getCurrentInstance().addMessage("cadastroForn", new FacesMessage("Cadastro de removido com sucesso."));
			fornecedor = new Fornecedor();
			endereco = new Endereco();
			nasc = "";
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

	public Date getMomento() {
		return parceria;
	}

	public void setMomento(Date momento) {
		this.parceria = momento;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getParceiro() {
		return parceiro;
	}

	public void setParceiro(String parceiro) {
		this.parceiro = parceiro;
	}

}
