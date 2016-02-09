package br.com.projectjpa.controle;

import java.io.Serializable;


import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;


import br.com.projectjpa.beans.Funcao;
import br.com.projectjpa.model.DAOFuncao;


@SuppressWarnings("serial")
@ManagedBean(name="controleFuncao")
@SessionScoped

public class ControleFuncao implements Serializable{

	private DAOFuncao<Funcao> dao;
	private Funcao objeto;
	
	
	public ControleFuncao(){
		dao = new DAOFuncao<Funcao>();
		
	}
	
	public String listar(){
		return "/privado/funcao/listar?faces-redirect=true";
	}
	
	public String novo(){
		objeto = new Funcao();
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
	
	public String alterar(Funcao obj){
		objeto = obj;
		return "form";
		
	}
	
	public String excluir(Funcao obj){
		dao.remove(obj);
		return "form";
	}

	public DAOFuncao<Funcao> getDao() {
		return dao;
	}

	public void setDao(DAOFuncao<Funcao> dao) {
		this.dao = dao;
	}

	public Funcao getObjeto() {
		return objeto;
	}

	public void setObjeto(Funcao objeto) {
		this.objeto = objeto;
	}
	
	
	
	
	
}
