package br.com.projectjpa.testes;

import javax.persistence.EntityManager;

import br.com.projectjpa.beans.Setor;
import br.com.projectjpa.jpa.EntityManagerUtil;

public class TesteInserirSetor {

	public static void main(String[] args) {
	
		EntityManager em = EntityManagerUtil.getEntityManager();
		Setor s = new Setor();
		s.setNome("Administrativo");
		Setor s2 = new Setor();
		s2.setNome("Pessoal");
		em.getTransaction().begin();
		em.persist(s);
		em.persist(s2);
		em.getTransaction().commit();
		System.out.println("Inclusão ocorreu com sucesso");
		
	}

}
