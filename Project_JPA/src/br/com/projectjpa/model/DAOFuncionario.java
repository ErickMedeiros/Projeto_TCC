package br.com.projectjpa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;


import br.com.projectjpa.beans.Funcionario;
import br.com.projectjpa.conversores.ConverterOrdem;
import br.com.projectjpa.jpa.EntityManagerUtil;
import br.com.projectjpa.util.UtilErros;
import br.com.projectjpa.util.UtilMensagens;

@SuppressWarnings("serial")
public class DAOFuncionario<T> extends GenericDAO<T>  implements Serializable{ 

	private EntityManager em;
	
	public DAOFuncionario(){
		super.setClasse(Funcionario.class);
		super.setEm(EntityManagerUtil.getEntityManager());
		super.getListaOrdem().add(new Ordem("Código", "id"));
		super.getListaOrdem().add(new Ordem("Nome", "nome"));
		super.setOrdemAtual((Ordem) super.getListaOrdem().get(1));
		super.setFiltro("");
		super.setMaximoObjetos(1);
		super.setConverterOrdem(new ConverterOrdem(super.getListaOrdem()));
	}
	
	
	
	public boolean gravar (Funcionario obj){
		try{
			em.getTransaction().begin();
			if (obj.getId() == null){
				em.persist(obj);
			} else{
				em.merge(obj);
			}
			em.getTransaction().commit();
			UtilMensagens.mensagemInformacao("Dados gravados com sucesso!");
			return true;
		} catch (Exception e) {
			if(em.getTransaction().isActive()== false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			UtilMensagens.mensagemErro("Erro ao gravar dados no banco"+
			UtilErros.getMensagemErro(e));
			return false;
		}
	}

	public boolean excluir(Funcionario obj){
		try {
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			UtilMensagens.mensagemInformacao("Objeto removido com sucesso!");
			return true;
		} catch (Exception e){
			if (em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			UtilMensagens.mensagemErro("Erro ao remover objeto: "+
			                                  UtilErros.getMensagemErro(e));
			return false;
		}
	}	
	
	public Funcionario localizar (Integer id){
		return em.find(Funcionario.class, id);
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}
