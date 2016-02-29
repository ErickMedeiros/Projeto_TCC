package br.com.projetotcc.controle;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

@SuppressWarnings({ "serial", "unused" })
@ManagedBean(name = "controleLocale")
@RequestScoped
public class ControleLocale implements Serializable {

	
	Locale currentLocale = new Locale ("pt", "BR");
	
	
	public ControleLocale() {

	}
	
	public void englishLocale(){
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		currentLocale = Locale.US;
		viewRoot.setLocale(currentLocale);
	}

	public void portugueseLocale(){
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		currentLocale = new Locale ("pt", "BR");;
		viewRoot.setLocale(currentLocale);
	}

	public Locale getCurrentLocale() {
		return currentLocale;
	}


	public void setCurrentLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
	}

	
	
	
}
