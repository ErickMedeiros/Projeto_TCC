package br.com.projectjpa.conversores;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "converterCalendar")
public class ConverterCalendar implements Converter {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// Converte da view para o objeto
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		Calendar c = Calendar.getInstance();// Pega a hora do sistema
		sdf.setLenient(false);// Verifica se a data é válida ou falsa
		try {
			c.setTime(sdf.parse(string));// Se a data for válida convert a data
											// string no objeto
		} catch (Exception e) {
			return null; // Se não a data é nula e retorna nulo
		}
		return c;
	}

	// Converte do objeto para a view
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		Calendar c = (Calendar) obj;
		String str = sdf.format(c.getTime());
		return str;
	}

}
