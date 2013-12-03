package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fachadas.Fachada;

import basicas.Produto;

@FacesConverter(forClass=Produto.class, value="produtoConverter")
public class ProdutoConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {		
		Produto produto;
		try {
			Integer codigo = Integer.parseInt(arg2);
			if (codigo == -1) {
				return null;
			}
			produto = Fachada.getInstancia().consultarProdutoPorId(codigo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return produto;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Produto produto = (Produto) arg2;
		return (produto != null ? produto.getId() + "" : "null");
	}


}

