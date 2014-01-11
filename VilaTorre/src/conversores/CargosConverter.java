package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fachadas.Fachada;

import basicas.*;

@FacesConverter(forClass=Cargo.class, value="cargoConverter")
public class CargosConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {		
		Cargo cargo;
		try {
			Integer codigo = Integer.parseInt(arg2);
			if (codigo == -1) {
				return null;
			}
			cargo = Fachada.getInstancia().consultarCargoPorId(codigo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return cargo;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Cargo cargo = (Cargo) arg2;
		return (cargo != null ? cargo.getId() + "" : "null");
	}

}
