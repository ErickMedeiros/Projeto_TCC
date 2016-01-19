package br.com.projectjpa.conversores;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.projectjpa.beans.Grupo;
import br.com.projectjpa.jpa.EntityManagerUtil;

public class ConverterGrupo implements Converter, Serializable {

	// Converte da view para o objeto
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		// TODO Auto-generated method stub
		if (string == null || string.equals("Selecione um grupo")){
		return null;
	}
		return EntityManagerUtil.getEntityManager().find(Grupo.class,Integer.parseInt(string));
	}	


	// Converte do objeto para a view
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object o) {
		// TODO Auto-generated method stub
		if (o == null){
		return null;
	}
		Grupo obj = (Grupo) o;
		return obj.getId().toString();

}
}