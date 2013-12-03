package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fachadas.Fachada;

import basicas.ItemPedido;

@FacesConverter(forClass=ItemPedido.class, value="itemConverter")
public class ItemPedidoConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {		
		ItemPedido item;
		try {
			Integer codigo = Integer.parseInt(arg2);
			if (codigo == -1) {
				return null;
			}
			item = Fachada.getInstancia().consultarItemPedidoPorId(codigo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return item;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		ItemPedido item = (ItemPedido) arg2;
		return (item != null ? item.getId_item() + "" : "null");
	}


}
