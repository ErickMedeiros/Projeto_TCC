package br.com.projetotcc.controle;

import java.io.Serializable;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.projetotcc.beans.Funcionario;
import br.com.projetotcc.beans.Projeto;
import br.com.projetotcc.beans.ProjetoFuncionario;
import br.com.projetotcc.conversores.ConverterFuncionario;
import br.com.projetotcc.conversores.ConverterSetor;
import br.com.projetotcc.model.DAOFuncionario;
import br.com.projetotcc.model.DAOProjeto;
import br.com.projetotcc.model.DAOSetor;



@SuppressWarnings("serial")
@ManagedBean(name="controleProjeto")
@SessionScoped
public class ControleProjeto implements Serializable{
	@SuppressWarnings("rawtypes")
	private DAOProjeto dao;
	private Projeto objeto;
	@SuppressWarnings("rawtypes")
	private DAOFuncionario daoFuncionario;
	private ConverterFuncionario converterFuncionario;
	@SuppressWarnings("rawtypes")
	private DAOSetor daoSetor;
	private ConverterSetor converterSetor;
	private Funcionario funcionario;
	private Integer cargaHoraria;
	private Boolean gestor;
	private Calendar inicioParticipacao;
	private Calendar fimParticipacao;
	private Boolean addFunc = false;
	
	@SuppressWarnings("rawtypes")
	public ControleProjeto(){
		dao = new DAOProjeto<Projeto>();
		daoFuncionario = new DAOFuncionario();
		daoSetor = new DAOSetor();
		converterFuncionario = new ConverterFuncionario();
		converterSetor = new ConverterSetor();
	}
	
	public String listar(){
		return "/privado/projeto/listar?faces-redirect=true";
	}
	
	public String novo() {
		objeto = new Projeto();
		addFunc = false;
		return "form";		
	}
	
	public String cancelar() {
		addFunc = false;
		dao.roolback();
		return "listar";
	}
	
	@SuppressWarnings("unchecked")
	public String gravar() {
		boolean gravou = false;
		if (objeto.getId() == null) {
			addFunc = false;
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
	
	public String alterar(Projeto obj) {
		objeto = obj;
		addFunc = false;
		return "form";

	}
	
	@SuppressWarnings("unchecked")
	public String excluir(Projeto obj) {
		dao.remove(obj);
		return "form";
	}
	
	public void removerFuncionario(ProjetoFuncionario obj){
		objeto.removerFuncionario(obj);
	}
	
	public void adicionarFuncionario(){
		addFunc = true;
	}
	
	public void cancelarFuncionario(){
		addFunc = false;
	}
	
	public void salvarFuncionario(){
		ProjetoFuncionario obj = new ProjetoFuncionario();
		obj.setCargaHoraria(cargaHoraria);
		obj.setFuncionario(funcionario);
		obj.setInicioParticipacao(inicioParticipacao);
		obj.setFimParticipacao(fimParticipacao);
		obj.setGestor(gestor);
		objeto.adicionarFuncionario(obj);
		addFunc = false;	
		cargaHoraria = null;
		funcionario = null;
		inicioParticipacao = null;
		fimParticipacao = null;
		gestor = null;
	}

	

	@SuppressWarnings("rawtypes")
	public DAOProjeto getDao() {
		return dao;
	}

	@SuppressWarnings("rawtypes")
	public void setDao(DAOProjeto dao) {
		this.dao = dao;
	}

	public Projeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Projeto objeto) {
		this.objeto = objeto;
	}

	

	public ConverterFuncionario getConverterFuncionario() {
		return converterFuncionario;
	}

	public void setConverterFuncionario(ConverterFuncionario converterFuncionario) {
		this.converterFuncionario = converterFuncionario;
	}

	

	@SuppressWarnings("rawtypes")
	public DAOFuncionario getDaoFuncionario() {
		return daoFuncionario;
	}

	@SuppressWarnings("rawtypes")
	public void setDaoFuncionario(DAOFuncionario daoFuncionario) {
		this.daoFuncionario = daoFuncionario;
	}

	@SuppressWarnings("rawtypes")
	public DAOSetor getDaoSetor() {
		return daoSetor;
	}

	@SuppressWarnings("rawtypes")
	public void setDaoSetor(DAOSetor daoSetor) {
		this.daoSetor = daoSetor;
	}

	public ConverterSetor getConverterSetor() {
		return converterSetor;
	}

	public void setConverterSetor(ConverterSetor converterSetor) {
		this.converterSetor = converterSetor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Boolean getGestor() {
		return gestor;
	}

	public void setGestor(Boolean gestor) {
		this.gestor = gestor;
	}

	public Calendar getInicioParticipacao() {
		return inicioParticipacao;
	}

	public void setInicioParticipacao(Calendar inicioParticipacao) {
		this.inicioParticipacao = inicioParticipacao;
	}

	public Calendar getFimParticipacao() {
		return fimParticipacao;
	}

	public void setFimParticipacao(Calendar fimParticipacao) {
		this.fimParticipacao = fimParticipacao;
	}

	public Boolean getAddFunc() {
		return addFunc;
	}

	public void setAddFunc(Boolean addFunc) {
		this.addFunc = addFunc;
	}
	
	
	
	
	

}
