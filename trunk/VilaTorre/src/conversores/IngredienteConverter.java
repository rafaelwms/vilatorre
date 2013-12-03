package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fachadas.Fachada;

import basicas.Ingrediente;

@FacesConverter(forClass=Ingrediente.class, value="ingredienteConverter")
public class IngredienteConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {		
		Ingrediente ingrediente;
		try {
			Integer codigo = Integer.parseInt(arg2);
			if (codigo == -1) {
				return null;
			}
			ingrediente = Fachada.getInstancia().consultarIngredientePorId(codigo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return ingrediente;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Ingrediente ingrediente = (Ingrediente) arg2;
		return (ingrediente != null ? ingrediente.getId() + "" : "null");
	}


}

