import javax.swing.JOptionPane;

import dados.*;
import fachadas.Fachada;
import basicas.*;

public class Testes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			for(Produto p : Fachada.getInstancia().consultarTodosProduto()){
				
				for(Ingrediente i : p.getIngredientes()){
					
					JOptionPane.showMessageDialog(null, "Produto "+ p.getNome()+" Ingrediente "+i.getNome(), "Alerta", JOptionPane.OK_OPTION);
					
				}
				
				
			}
		}catch(Exception x){
			
		}
	}

}
