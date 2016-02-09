package br.com.projectjpa.testes;

import javax.persistence.EntityManager;

import br.com.projectjpa.beans.Funcao;
import br.com.projectjpa.jpa.EntityManagerUtil;

public class TesteInserirFuncao {

	public static void main(String[] args) {
	
		EntityManager em = EntityManagerUtil.getEntityManager();
		Funcao f = new Funcao();
		f.setNome("Analista de Sistemas");
		Funcao f2 = new Funcao();
		f2.setNome("Programador");
		Funcao f3 = new Funcao();
		f3.setNome("Gerente de Projeto");
		em.getTransaction().begin();
		em.persist(f);
		em.persist(f2);
		em.persist(f3);
		em.getTransaction().commit();
		System.out.println("Inclusão ocorreu com sucesso");
		
	}

}
