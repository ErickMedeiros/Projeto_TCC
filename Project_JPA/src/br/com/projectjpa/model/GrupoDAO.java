package br.com.projectjpa.model;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.projectjpa.beans.Grupo;
import br.com.projectjpa.jpa.EntityManagerUtil;
import br.com.projectjpa.util.UtilErros;
import br.com.projectjpa.util.UtilMensagens;

public class GrupoDAO {

	private EntityManager em;
	
	public GrupoDAO(){
		em = EntityManagerUtil.getEntityManager();
	}
	
	public List<Grupo> listarTodos(){
		return em.createQuery("from Grupo order by nome").getResultList();
	}
	
	public boolean gravar (Grupo obj){
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

	public boolean excluir (Grupo obj){
		try{
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			UtilMensagens.mensagemInformacao("Dado excluído com sucesso!");
			return true;
		} catch (Exception e) {
			if(em.getTransaction().isActive()== false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			UtilMensagens.mensagemErro("Erro ao excluir dados no banco"+
			UtilErros.getMensagemErro(e));
			return false;
		}
	}
	
	public Grupo localizar (Integer id){
		return em.find(Grupo.class, id);
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
}
