package br.com.projetotcc.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.projetotcc.beans.Funcionario;
import br.com.projetotcc.conversores.ConverterFuncao;
import br.com.projetotcc.conversores.ConverterGrupo;
import br.com.projetotcc.conversores.ConverterSetor;
import br.com.projetotcc.model.DAOFuncao;
import br.com.projetotcc.model.DAOFuncionario;
import br.com.projetotcc.model.DAOGrupo;
import br.com.projetotcc.model.DAOSetor;
import br.com.projetotcc.util.UtilErros;
import br.com.projetotcc.util.UtilMensagens;

@SuppressWarnings("serial")
@ManagedBean(name = "controleFuncionario")
@SessionScoped
public class ControleFuncionario implements Serializable {

	@SuppressWarnings("rawtypes")
	private DAOFuncionario dao;
	private Funcionario objeto;
	@SuppressWarnings("rawtypes")
	private DAOFuncao daoFuncao;
	@SuppressWarnings("rawtypes")
	private DAOGrupo daoGrupo;
	@SuppressWarnings("rawtypes")
	private DAOSetor daoSetor;
	private ConverterFuncao converterFuncao;
	private ConverterGrupo converterGrupo;
	private ConverterSetor converterSetor;

	@SuppressWarnings("rawtypes")
	public ControleFuncionario() {
		dao = new DAOFuncionario<Funcionario>();
		daoFuncao = new DAOFuncao();
		daoGrupo = new DAOGrupo();
		daoSetor = new DAOSetor();
		converterFuncao = new ConverterFuncao();
		converterGrupo = new ConverterGrupo();
		converterSetor = new ConverterSetor();
	}

	public String listar() {
		return "/privado/funcionario/listar?faces-redirect=true";
	}

	public String novo() {
		objeto = new Funcionario();
		return "form";
	}

	public String cancelar() {
		return "listar";
	}

	@SuppressWarnings("unchecked")
	public String gravar() {
		boolean gravou = false;
		if (objeto.getId() == null) {
			gravou = dao.persist(objeto);
		} else {
			gravou = dao.merge(objeto);
		}
		if (gravou) {
			return "listar";
		} else {
			return "form";
		}
	}

	public String alterar(Funcionario obj) {
		objeto = obj;
		return "form";

	}

	@SuppressWarnings("unchecked")
	public String excluir(Funcionario obj) {
		dao.remove(obj);
		return "form";
	}

	

	@SuppressWarnings("rawtypes")
	public DAOFuncionario getDao() {
		return dao;
	}

	@SuppressWarnings("rawtypes")
	public void setDao(DAOFuncionario dao) {
		this.dao = dao;
	}

	public Funcionario getObjeto() {
		return objeto;
	}

	public void setObjeto(Funcionario objeto) {
		this.objeto = objeto;
	}

	@SuppressWarnings("rawtypes")
	public DAOFuncao getDaoFuncao() {
		return daoFuncao;
	}

	@SuppressWarnings("rawtypes")
	public void setDaoFuncao(DAOFuncao daoFuncao) {
		this.daoFuncao = daoFuncao;
	}

	@SuppressWarnings("rawtypes")
	public DAOGrupo getDaoGrupo() {
		return daoGrupo;
	}

	@SuppressWarnings("rawtypes")
	public void setDaoGrupo(DAOGrupo daoGrupo) {
		this.daoGrupo = daoGrupo;
	}

	@SuppressWarnings("rawtypes")
	public DAOSetor getDaoSetor() {
		return daoSetor;
	}

	@SuppressWarnings("rawtypes")
	public void setDaoSetor(DAOSetor daoSetor) {
		this.daoSetor = daoSetor;
	}

	public ConverterFuncao getConverterFuncao() {
		return converterFuncao;
	}

	public void setConverterFuncao(ConverterFuncao converterFuncao) {
		this.converterFuncao = converterFuncao;
	}

	public ConverterGrupo getConverterGrupo() {
		return converterGrupo;
	}

	public void setConverterGrupo(ConverterGrupo converterGrupo) {
		this.converterGrupo = converterGrupo;
	}

	public ConverterSetor getConverterSetor() {
		return converterSetor;
	}

	public void setConverterSetor(ConverterSetor converterSetor) {
		this.converterSetor = converterSetor;
	}

}
