package br.com.projetotcc.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.projetotcc.beans.Grupo;
import br.com.projetotcc.beans.Setor;
import br.com.projetotcc.model.DAOGrupo;
import br.com.projetotcc.model.DAOSetor;



@SuppressWarnings("serial")
@ManagedBean(name="controleGrupo")
@SessionScoped
public class ControleGrupo implements Serializable{
	private DAOGrupo<Grupo> dao;
	private Grupo objeto;
	
	public ControleGrupo(){
		dao = new DAOGrupo<Grupo>();
		
	}
	
	public String listar(){
		return "/privado/grupo/listar?faces-redirect=true";
	}
	
	public String novo(){
		objeto = new Grupo();
		return "form";		
	}
	
	public String cancelar(){
		return "listar";
	}
	
	public String gravar(){
		boolean gravou = false;
		if(objeto.getId() == null){
			gravou = dao.persist(objeto);
		} else {
			gravou = dao.merge(objeto);
		}
		if(gravou){
			return "listar";
		} else {
			return "form";
		}
	}
	
	public String alterar(Grupo obj){
		objeto = obj;
		return "form";
		
	}
	
	public String excluir(Grupo obj){
		dao.remove(obj);
		return "form";
	}

	public DAOGrupo<Grupo> getDao() {
		return dao;
	}

	public void setDao(DAOGrupo<Grupo> dao) {
		this.dao = dao;
	}

	public Grupo getObjeto() {
		return objeto;
	}

	public void setObjeto(Grupo objeto) {
		this.objeto = objeto;
	}
	
	
	
	

}
