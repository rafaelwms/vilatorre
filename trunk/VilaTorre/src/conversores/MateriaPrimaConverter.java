package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fachadas.Fachada;

import basicas.MateriaPrima;

@FacesConverter(forClass=MateriaPrima.class, value="materiaConverter")
public class MateriaPrimaConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {		
		MateriaPrima materia;
		try {
			Integer codigo = Integer.parseInt(arg2);
			if (codigo == -1) {
				return null;
			}
			materia = Fachada.getInstancia().consultarMateriaPrimaPorId(codigo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return materia;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		MateriaPrima materia = (MateriaPrima) arg2;
		return (materia != null ? materia.getId() + "" : "null");
	}


}
