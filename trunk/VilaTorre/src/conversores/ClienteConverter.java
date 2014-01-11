package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fachadas.Fachada;

import basicas.Cliente;

@FacesConverter(forClass=Cliente.class, value="cliConverter")
public class ClienteConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {		
		Cliente cli;
		try {
			Integer codigo = Integer.parseInt(arg2);
			if (codigo == -1) {
				return null;
			}
			cli = Fachada.getInstancia().consultarPorIdCliente(codigo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return cli;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Cliente cli = (Cliente) arg2;
		return (cli != null ? cli.getId() + "" : "null");
	}


}
