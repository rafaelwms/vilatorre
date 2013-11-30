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

	
	public static double calcularPedido(Pedido pedido){		
		double total = 0;
		for(ItemPedido item : pedido.getLista_itens()){			
			total = total + (item.getProduto().getPreco() * item.getQtd());
		}
		return total;
	}
	

	
}
