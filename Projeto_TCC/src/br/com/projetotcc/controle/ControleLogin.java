package br.com.projetotcc.controle;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.projetotcc.beans.Funcionario;
import br.com.projetotcc.model.DAOFuncionario;
import br.com.projetotcc.util.UtilMensagens;
@SuppressWarnings("serial")
@ManagedBean("controleLogin")
@SessionScoped
public class ControleLogin implements Serializable {

	private DAOFuncionario dao;
	private Funcionario usuarioLogado;
	private String usuario;
	private String senha;
	
	public ControleLogin(){
		dao = new DAOFuncionario();
	}
	
	public String paginaLogin(){
		return "/login";
	}
	
	public String efetuarLogin(){
		if (dao.login(usuario, senha)){
			usuarioLogado = dao.LocalizaPorNome(usuario);
			UtilMensagens.mensagemInformacao("Login efetuado com sucessi!");
			return "/index";
		}else{
			UtilMensagens.mensagemErro("Falha no Login"
					+ "Usuário ou Senha Inválidos");
			return "/login";
		}
	}
	
	public String efetuarLogout(){
		usuarioLogado = null;
		return "/index";
		
	}
	
	
	public DAOFuncionario getDao() {
		return dao;
	}
	public void setDao(DAOFuncionario dao) {
		this.dao = dao;
	}
	public Funcionario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Funcionario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
