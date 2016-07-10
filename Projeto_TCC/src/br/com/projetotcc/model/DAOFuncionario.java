package br.com.projetotcc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projetotcc.beans.Funcionario;
import br.com.projetotcc.conversores.ConverterOrdem;
import br.com.projetotcc.jpa.EntityManagerUtil;
import br.com.projetotcc.util.UtilErros;
import br.com.projetotcc.util.UtilMensagens;

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
	
	public boolean login(String usuario, String senha){
		Query query = em.createQuery("from funcionario where upper(nome_usuario) = :usuario"
				+ "upper (senha) = :senha and ativo=true");
		query.setParameter("usuario", usuario.toUpperCase());
		query.setParameter("senha", senha.toUpperCase());
		if(!query.getResultList().isEmpty()){
			return true;
		}else{
			return false;
		}
		
	}
	
	public Funcionario LocalizaPorNome(String usuario){
		return (Funcionario) em.createQuery("from funcionario where upper(nome_usuario) = "
				+ ":usuario").setParameter("usuario", usuario.toUpperCase()).getSingleResult();
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}
