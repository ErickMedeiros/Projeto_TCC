package br.com.projectjpa.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import br.com.projectjpa.beans.Setor;
import br.com.projectjpa.model.SetorDAO;


@ManagedBean(name="controleSetor")
@SessionScoped
public class ControleSetor implements Serializable{
	private SetorDAO dao;
	private Setor objeto;
	
	public ControleSetor(){
		dao = new SetorDAO();
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
		if (dao.gravar(objeto)){
			return "listar";
		}else{
			return "form";
		}
	}
	
	public String alterar(Setor obj){
		objeto = obj;
		return "form";
	}
	
	public String excluir(Setor obj){
		dao.excluir(obj);
		return "listar";
	}
	
	public SetorDAO getDao() {
		return dao;
	}
	public void setDao(SetorDAO dao) {
		this.dao = dao;
	}
	public Setor getObjeto() {
		return objeto;
	}
	public void setObjeto(Setor objeto) {
		this.objeto = objeto;
	}
	
	
	

}
