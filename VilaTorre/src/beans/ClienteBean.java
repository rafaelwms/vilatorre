package beans;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import negocio.ValidacoesDeTela;

import util.Datas;
import basicas.Cliente;
import basicas.Endereco;
import basicas.Usuario;
import basicas.Usuario.TipoUser;
import fachadas.Fachada;

@ManagedBean
public class ClienteBean {

	private Cliente cliente = new Cliente();
	private Usuario usuario = new Usuario();
	private Endereco endereco = new Endereco();
	private List<Cliente> clientes = new ArrayList<Cliente>();

	private String nasc;
	private Date nascimento;
	private Date momento;

	public String salvar() {

		try {
			nascimento = Datas.criarData(nasc);
			momento = new Date();
			endereco.setCidade("Recife");
			endereco.setUf("PE");
			cliente.setEndereco(endereco);
			cliente.setUsuario(usuario);
			cliente.getUsuario().setTipoUser(TipoUser.CLIENTE);
			cliente.setNasc(nascimento);
			cliente.setCadastro(momento);
			
			
			ValidacoesDeTela.validarString(cliente.getNome(), "cliente", "nome", 6, 130, "o", "o");
			ValidacoesDeTela.validarString(cliente.getFone(), "cliente", "fone", 13, 13, "o", "o");
			ValidacoesDeTela.validarString(cliente.getCpf(), "cliente", "cpf", 14, 14, "o", "o");
			ValidacoesDeTela.validarEmail(cliente.getEmail(), "cliente", "o");
			
			if((!cliente.getUsuario().getLogin().trim().equals(""))){
				ValidacoesDeTela.validarString(cliente.getUsuario().getLogin(), "cliente", "login", 6, 30, "o", "o");
				ValidacoesDeTela.validarString(cliente.getUsuario().getSenha(), "cliente", "senha", 6, 30, "o", "a");
			}

			if (cliente.getId() == null || cliente.getId() == 0) {
				cliente.setId(null);
				Fachada.getInstancia().inserirCliente(cliente);
				FacesContext.getCurrentInstance().addMessage("cadastroCli", new FacesMessage("Cadastro de " + cliente.getNome() + " efetuado com sucesso."));
				cliente = new Cliente();
				usuario = new Usuario();
				endereco = new Endereco();
				nasc = "";
				return null;

			} else {

				Fachada.getInstancia().alterarCliente(cliente);
				FacesContext.getCurrentInstance().addMessage("alterCli", new FacesMessage("Cadastro de " + cliente.getNome() + " alterado com sucesso."));
				cliente = new Cliente();
				return null;
			}
		} catch (ParseException px){
			FacesContext.getCurrentInstance().addMessage("expetionCli", new FacesMessage("Data \""+nasc+"\" incorreta."));
			return null;
		} catch (Exception ex) {
			FacesContext.getCurrentInstance().addMessage("expetionCli", new FacesMessage(ex.getMessage()));
			return null;
		}

	}
	
	public String editar(Cliente param){
		
	cliente = param;
	usuario = param.getUsuario();
	nasc = Datas.formatarData(param.getNasc());
	
	System.out.println(cliente);
	System.out.println(usuario);
	System.out.println(nasc);
	
		return null;
	}

	public String reset() {
		cliente = new Cliente();
		usuario = new Usuario();
		endereco = new Endereco();
		nasc = "";
		return null;
	}
	
	public String  remover(){
		try{
		if (cliente.getId() != null && cliente.getId() > 0) {

			Fachada.getInstancia().removerCliente(cliente);
			FacesContext.getCurrentInstance().addMessage("cadastroCli", new FacesMessage("Cadastro de removido com sucesso."));
			cliente = new Cliente();
			usuario = new Usuario();
			endereco = new Endereco();
			nasc = "";
			return null;

		}else{
			FacesContext.getCurrentInstance().addMessage("cadastroCli", new FacesMessage("Seleicione um cliente para remoção."));
			return null;
		}
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage("exceptionCli", new FacesMessage(ex.getMessage()));
		}
		
		return null;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public List<Cliente> getClientes() {
		try {
			return Fachada.getInstancia().consultarTodosCliente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
