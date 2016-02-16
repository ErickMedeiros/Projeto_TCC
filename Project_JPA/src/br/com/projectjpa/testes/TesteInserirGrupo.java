package br.com.projectjpa.testes;

import javax.persistence.EntityManager;

import br.com.projectjpa.beans.Grupo;
import br.com.projectjpa.jpa.EntityManagerUtil;

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


