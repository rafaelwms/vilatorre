package managedbenas;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import util.Datas;
import comum.Endereco;


import basicasHumana.Cliente;
import basicasHumana.Usuario;
import fachadas.*;
@ManagedBean
@ViewScoped
public class ClienteBeans {

private String nasc;
private Cliente cliente = new Cliente();
private Usuario usuario = new Usuario();
private Endereco endereco = new Endereco();
private Fachada fachada = new Fachada();

public String salvar(){
		
		cliente.setUsuario(usuario);
		cliente.setEndereco(endereco);
	if (cliente.getId() == null  || cliente.getId() == 0){
		cliente.setNasc(Datas.criarData(nasc));
		
		
	//	fachada.inserirCliente(cliente);
		System.out.println(nasc);
		System.out.println(""+cliente.getNasc());
		return "/cadastroRealizado.xhtml?faces-redirect=true";
	}else{
		fachada.alterarCliente(cliente);
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




}
