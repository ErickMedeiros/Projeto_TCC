package br.com.projectjpa.conversores;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.projectjpa.beans.Setor;
import br.com.projectjpa.jpa.EntityManagerUtil;

public class ConverterSetor implements Converter, Serializable {

	// Converte da view para o objeto
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		// TODO Auto-generated method stub
		if (string == null || string.equals("Selecione um Setor")){
		return null;
	}
		return EntityManagerUtil.getEntityManager().find(Setor.class,Integer.parseInt(string));
	}	


	// Converte do objeto para a view
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object o) {
		// TODO Auto-generated method stub
		if (o == null){
		return null;
	}
		Setor obj = (Setor) o;
		return obj.getId().toString();

}
}