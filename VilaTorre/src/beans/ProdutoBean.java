package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import util.Datas;

import fachadas.Fachada;

import basicas.*;

import basicas.Produto.Categoria;;

@ManagedBean
public class ProdutoBean {

	
	private Produto produto = new Produto();
	
	private Categoria categoria;
	
	private String preco;
	
	private Categoria[] categorias;	

	private List<Produto> produtos = new ArrayList<Produto>();	
	
	private List<Ingrediente> todosIngredientes = new ArrayList<Ingrediente>();
	
	private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	
	
	public ProdutoBean(){}
	
	
	public String salvar(){
		try{
			
			if(categoria == Categoria.Selecione){
				throw new Exception("É necessário selecionar uma categoria.");
			}
			
			
			if(ingredientes.size() < 1 ){
				throw new Exception("É necessário selecionar ao menos um ingrediente.");
			}
			
			
			if(preco.trim().equals("")){
				throw new Exception("Preço invalido.");
			}

			preco = preco.replace(".", "");
			preco = preco.replace(",", ".");
			produto.setPreco(Double.parseDouble(preco));
			produto.setCategoria(categoria);
			produto.setIngredientes(ingredientes);
			
			if(produto.getId() == null || produto.getId() < 1){
				
				produto.setId(null);
				Fachada.getInstancia().inserirProduto(produto);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Produto "+produto.getNome()+" cadastrado com êxito."));
				produto = new Produto();
				preco = new String();
				categoria = Categoria.Selecione;
				ingredientes = new ArrayList<Ingrediente>();
				return null;
				
			}else{
				
				Fachada.getInstancia().alterarProduto(produto);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Produto "+produto.getNome()+" cadastrado com êxito."));
				produto = new Produto();
				preco = new String();
				categoria = Categoria.Selecione;
				ingredientes = new ArrayList<Ingrediente>();
				return null;
				
			}
			
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage()));
			return null;
		}
	}
	
	public String editar(Produto param){
		
		this.produto = param;
		this.categoria = param.getCategoria();
		this.preco =  Datas.double2MoneyString(param.getPreco());
		for(Ingrediente i : param.getIngredientes()){
			ingredientes.add(i);
		}
		
		
		System.out.println(produto);
		System.out.println(categoria);
		System.out.println(preco);
		System.out.println(ingredientes);
		return null;
	}
	
	
	public String excluir(Produto param){

		try{
			Fachada.getInstancia().removerProduto(param);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Produto "+produto.getNome()+" removido com êxito."));
			produto = new Produto();
			preco = new String();
		return null;	
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage()));
		return null;
		}
	
	}
	
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Ingrediente> getTodosIngredientes() {
		try {
			return Fachada.getInstancia().consultarTodosIngrediente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	
	
	public Categoria[] getCategorias(){
		return Categoria.values();
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public List<Produto> getProdutos() {
		try {
			return Fachada.getInstancia().consultarTodosProduto();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}


	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}


	public void setTodosIngredientes(List<Ingrediente> todosIngredientes) {
		this.todosIngredientes = todosIngredientes;
	}
	
}
