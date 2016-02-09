package br.com.projectjpa.controle;

import java.io.Serializable;


import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;


import br.com.projectjpa.beans.Setor;
import br.com.projectjpa.model.DAOSetor;


@SuppressWarnings("serial")
@ManagedBean(name="controleSetor")
@SessionScoped

public class ControleSetor implements Serializable{

	private DAOSetor<Setor> dao;
	private Setor objeto;
	
	
	public ControleSetor(){
		dao = new DAOSetor<Setor>();
		//objeto = new Setor();
	}
	
	public String listar(){
		return "/privado/setor/listar?faces-redirect=true";
	}
	
	public String novo(){
		objeto = new Setor();
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
	
	public String alterar(Setor obj){
		objeto = obj;
		return "form";
		
	}
	
	public String excluir(Setor obj){
		dao.remove(obj);
		return "form";
	}
	
	public DAOSetor<Setor> getDao() {
		return dao;
	}
	public void setDao(DAOSetor<Setor> dao) {
		this.dao = dao;
	}
	public Setor getObjeto() {
		return objeto;
	}
	public void setObjeto(Setor objeto) {
		this.objeto = objeto;
	}
	
	
	
}
