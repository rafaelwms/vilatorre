package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fachadas.Fachada;

import basicas.Fornecedor;

@FacesConverter(forClass=Fornecedor.class, value="fornConverter")
public class FornecedorConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {		
		Fornecedor forn;
		try {
			Integer codigo = Integer.parseInt(arg2);
			if (codigo == -1) {
				return null;
			}
			forn = Fachada.getInstancia().consultarFornecedorPorId(codigo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return forn;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Fornecedor forn = (Fornecedor) arg2;
		return (forn != null ? forn.getId() + "" : "null");
	}


}

