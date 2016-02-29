package br.com.projetotcc.testes;

import javax.persistence.EntityManager;

import br.com.projetotcc.beans.Grupo;
import br.com.projetotcc.jpa.EntityManagerUtil;

public class TesteInserirGrupo {

	public static void main(String[] args) {
		
					 
			EntityManager em = EntityManagerUtil.getEntityManager();
			Grupo g = new Grupo();
			g.setNome("Gestores");
			em.getTransaction().begin();
			em.persist(g);
			em.getTransaction().commit();
			System.out.println("Inclusão ocorreu com sucesso");
			
		}

	}


