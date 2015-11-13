package br.com.projectjpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import com.sun.faces.util.Cache.Factory;

public class EntityManagerUtil {
	private static EntityManagerFactory factory = null;
	private static EntityManager em = null;
	
	public static EntityManager getEntityManager(){
		if (factory == null){
			factory = Persistence.createEntityManagerFactory("Project_JPA");
		}
		if (em == null){
			em = factory.createEntityManager();
		}
		return em;			
	}
	
}