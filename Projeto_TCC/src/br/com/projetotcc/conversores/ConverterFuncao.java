package br.com.projetotcc.conversores;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.projetotcc.beans.Funcao;
import br.com.projetotcc.jpa.EntityManagerUtil;

@SuppressWarnings("serial")
public class ConverterFuncao implements Converter, Serializable {

	// converte da tela para o objeto 
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.equals("Selecione uma Fun��o")){
			return null;
		}
		return EntityManagerUtil.getEntityManager().find(Funcao.class, 
				Integer.parseInt(string));
	}

	// converte do objeto para a tela
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object o) {
		if (o == null){
			return null;
		}
		Funcao obj = (Funcao) o;
		return obj.getId().toString();
	}

}
