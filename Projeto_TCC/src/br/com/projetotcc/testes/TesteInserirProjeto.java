package br.com.projetotcc.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.projetotcc.beans.Funcionario;
import br.com.projetotcc.beans.Projeto;
import br.com.projetotcc.beans.ProjetoFuncionario;
import br.com.projetotcc.beans.Setor;
import br.com.projetotcc.jpa.EntityManagerUtil;


public class TesteInserirProjeto {

	public static void main(String[] args) {
		
		 
		EntityManager em = EntityManagerUtil.getEntityManager();
		Setor setor = em.find(Setor.class, 1);
		Funcionario func = em.find(Funcionario.class, 1);
		Projeto projeto = new Projeto();
		projeto.setNome("Projeto JSF");
		projeto.setDescricao("Meu novo projeto JSF");
		projeto.setInicio(Calendar.getInstance());
		projeto.setFim(Calendar.getInstance());
		projeto.setAtivo(true);
		projeto.setSetor(setor);
		ProjetoFuncionario pf = new ProjetoFuncionario() ;
		pf.setFuncionario(func);
		pf.setCargaHoraria(200);
		pf.setInicioParticipacao(Calendar.getInstance());
		pf.setFimParticipacao(Calendar.getInstance());
		pf.setGestor(true);
		projeto.adicionarFuncionario(pf);
		em.getTransaction().begin();
		em.persist(projeto);
		em.getTransaction().commit();
		System.out.println("Inserção aconteceu com sucesso");
	}

}

