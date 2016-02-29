package br.com.projetotcc.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
		private static EntityManagerFactory factory = null;
		private static EntityManager em = null;
		
		public static EntityManager getEntityManager(){
			if (factory == null){
				factory = Persistence.createEntityManagerFactory("bd_project");
			}
			if (em == null){
				em = factory.createEntityManager();
			}
			return em;			
		}
		
}
