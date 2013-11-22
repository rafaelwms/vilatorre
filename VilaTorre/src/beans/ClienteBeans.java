package beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import util.Datas;
import basicas.Cliente;
import basicas.Endereco;
import basicas.Usuario;
import basicas.Usuario.TipoUser;
import fachadas.Fachada;
import fachadas.IFachada;

@ManagedBean
public class ClienteBeans {
	
private Cliente cliente = new Cliente();
private Usuario usuario = new Usuario();
private Endereco endereco = new Endereco();




private String nasc;
private Date nascimento;
private Date momento;

public String salvar(){
	    nascimento = Datas.criarData(nasc);
		momento = new Date();
		
		endereco.setCidade("Recife");
		endereco.setUf("PE");
		cliente.setEndereco(endereco);
		cliente.setUsuario(usuario);
		cliente.getUsuario().setTipoUser(TipoUser.CLIENTE);
		cliente.setNasc(nascimento);
		cliente.setCadastro(momento);
		
	if (cliente.getId() == null  || cliente.getId() == 0){
		try{
		Fachada.getInstancia().inserirCliente(cliente);
		return "/cadastroRealizado.xhtml?faces-redirect=true";
		}catch(Exception ex){
			System.out.println(ex);
			System.out.println(nasc);
			System.out.println(momento);
			System.out.println(nascimento);
		return "/sefu.xhtml?faces-redirect=true";	
		}
	}else{
		try {
			Fachada.getInstancia().alterarCliente(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/alteracaoClienteRealizada.xhtml";
	}
}

public void reset(){
	cliente = new Cliente();
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




}
