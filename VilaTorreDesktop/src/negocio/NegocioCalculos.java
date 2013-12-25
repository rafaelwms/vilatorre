package negocio;


import basicas.*;

public class NegocioCalculos {

	
	public NegocioCalculos(){
	}

	public static Estoque deduzirEstoque(Estoque estoque, double deducao){	
		try{
		estoque.setQuantidade(estoque.getQuantidade() - deducao);
		return estoque;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	public static Estoque alimentarEstoque(Estoque estoque, double adicao){	
		try{
		estoque.setQuantidade(estoque.getQuantidade() + adicao);
		return estoque;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}

	
	public static void calcularItem(ItemPedido item){
		item.setTotalItem(item.getQtd() * item.getProduto().getPreco());
	}
		
	
	public static void calcularPedido(Pedido pedido){		
		double total = 0;
		for(ItemPedido item : pedido.getLista_itens()){
			calcularItem(item);
			total = total + item.getTotalItem();
		}
		pedido.setValor_total(total);
	}
	

	
}
