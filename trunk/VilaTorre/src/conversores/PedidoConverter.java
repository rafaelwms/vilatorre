package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fachadas.Fachada;

import basicas.Pedido;

@FacesConverter(forClass=Pedido.class, value="pedidoConverter")
public class PedidoConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {		
		Pedido pedido;
		try {
			Integer codigo = Integer.parseInt(arg2);
			if (codigo == -1) {
				return null;
			}
			pedido = Fachada.getInstancia().consultarPedidoPorId(codigo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return pedido;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Pedido pedido = (Pedido) arg2;
		return (pedido != null ? pedido.getId_pedido() + "" : "null");
	}


}

