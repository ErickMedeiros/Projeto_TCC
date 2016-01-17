package br.com.projectjpa.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.projectjpa.beans.Funcionario;
import br.com.projectjpa.beans.Grupo;
import br.com.projectjpa.beans.Setor;
import br.com.projectjpa.jpa.EntityManagerUtil;

public class TesteInserirFuncionario {

	public static void main(String[] args) {
		
					 
			EntityManager em = EntityManagerUtil.getEntityManager();
			Grupo grupo = em.find(Grupo.class, 1);
			Setor setor = em.find(Setor.class, 1);
			Funcionario f = new Funcionario();
			f.setNome("Erick Medeiros");
			f.setCpf("881.084.494-72");
			f.setEmail("erickb_m@hotmail.com");
			f.setSalario(1800.00);
			f.setNascimento(Calendar.getInstance());
			f.setAtivo(true);
			//f.setFoto("Gestores");
			f.setNomeUsuario("erickbm");
			f.setSenha("ebdm2525");
			f.setGrupo(grupo);
			f.setSetor(setor);
			em.getTransaction().begin();
			em.persist(f);
			em.getTransaction().commit();
		}

	}