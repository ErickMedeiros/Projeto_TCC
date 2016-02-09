package br.com.projectjpa.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.projectjpa.beans.Funcionario;

import br.com.projectjpa.conversores.ConverterGrupo;
import br.com.projectjpa.conversores.ConverterSetor;
import br.com.projectjpa.conversores.ConverterFuncao;
import br.com.projectjpa.model.DAOFuncionario;
import br.com.projectjpa.model.DAOGrupo;
import br.com.projectjpa.model.DAOSetor;
import br.com.projectjpa.model.DAOFuncao;

import br.com.projectjpa.util.UtilErros;
import br.com.projectjpa.util.UtilMensagens;

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

	public void enviarFoto(FileUploadEvent event) {
		try {
			byte[] foto = IOUtils.toByteArray(event.getFile().getInputstream());
			objeto.setFoto(foto);
			UtilMensagens.mensagemInformacao("Arquivo enviado com sucesso! " + event.getFile().getFileName());
		} catch (Exception e) {
			UtilMensagens.mensagemErro("Erro ao enviar arquivo:" + UtilErros.getMensagemErro(e));
		}
	}

	public StreamedContent getImagemDinamica() {
		String strid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id_imagem");
		if (strid != null) {
			Integer id = Integer.parseInt(strid);
			Funcionario obj = dao.localizar(id);
			return obj.getImagem();
		}
		return new DefaultStreamedContent();
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
