package br.com.projectjpa.conversores;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.projectjpa.model.Ordem;

@SuppressWarnings("serial")
public class ConverterOrdem implements Serializable, Converter{

	private List<Ordem> listaOrdem;
	
	
	
	public ConverterOrdem(List<Ordem> listaOrdem) {
		super();
		this.listaOrdem = listaOrdem;
	}

	public List<Ordem> getListaOrdem() {
		return listaOrdem;
	}

	public void setListaOrdem(List<Ordem> listaOrdem) {
		this.listaOrdem = listaOrdem;
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		Ordem retorno = null;
		for (Ordem ob : listaOrdem)
			if ( ob.getAtributo().equals(string)){
				retorno = ob;
			}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object ob) {
		if (ob == null){
			return null;
		}
		Ordem ordem = (Ordem) ob;
		return ordem.getAtributo().toString();
	}

	
	
}
