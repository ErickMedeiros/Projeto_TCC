package br.com.projectjpa.controle;

import java.io.Serializable;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.projectjpa.beans.Funcionario;
import br.com.projectjpa.beans.Projeto;
import br.com.projectjpa.beans.ProjetoFuncionario;
import br.com.projectjpa.conversores.ConverterFuncionario;
import br.com.projectjpa.conversores.ConverterSetor;
import br.com.projectjpa.model.DAOFuncionario;
import br.com.projectjpa.model.DAOSetor;
import br.com.projectjpa.model.ProjetoDAO;



@SuppressWarnings("serial")
@ManagedBean(name="controleProjeto")
@SessionScoped
public class ControleProjeto implements Serializable{
	private ProjetoDAO dao;
	private Projeto objeto;
	private DAOFuncionario daoFuncionario;
	private ConverterFuncionario converterFuncionario;
	private DAOSetor daoSetor;
	private ConverterSetor converterSetor;
	private Funcionario funcionario;
	private Integer cargaHoraria;
	private Boolean gestor;
	private Calendar inicioParticipacao;
	private Calendar fimParticipacao;
	private Boolean addFunc = false;
	
	public ControleProjeto(){
		dao = new ProjetoDAO();
		daoFuncionario = new DAOFuncionario();
		converterFuncionario = new ConverterFuncionario();
		daoSetor = new DAOSetor();
		converterSetor = new ConverterSetor();
	}
	
	public String listar(){
		return "/privado/projeto/listar?faces-redirect=true";
	}
	
	public String novo(){
		objeto = new Projeto();
		addFunc = false;
		return "form";		
	}
	
	public String cancelar(){
		addFunc = false;
		dao.roolback();
		return "listar";
	}
	
	public String gravar(){
		if (dao.gravar(objeto)){
			addFunc = false;
			return "listar";			
		}else{
			return "form";
		}
	}
	
	public String alterar(Projeto obj){
		objeto = obj;
		addFunc = false;
		return "form";
	}
	
	public String excluir(Projeto obj){
		dao.excluir(obj);
		return "listar";
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

	public ProjetoDAO getDao() {
		return dao;
	}

	public void setDao(ProjetoDAO dao) {
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

	

	public DAOFuncionario getDaoFuncionario() {
		return daoFuncionario;
	}

	public void setDaoFuncionario(DAOFuncionario daoFuncionario) {
		this.daoFuncionario = daoFuncionario;
	}

	public DAOSetor getDaoSetor() {
		return daoSetor;
	}

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
