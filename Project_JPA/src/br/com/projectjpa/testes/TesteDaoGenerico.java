package br.com.projectjpa.testes;

import java.util.List;

import br.com.projectjpa.beans.Setor;
import br.com.projectjpa.model.DAOSetor;

public class TesteDaoGenerico {

	public static void main(String[] args) {
		DAOSetor<Setor> dao = new DAOSetor<Setor>();
		//dao.setMaximoObjetos(1);
		List<Setor> lista = dao.listar();
		for (Setor o : lista){
			System.out.println("Codigo: "+o.getId()+" Nome: "+o.getNome());
		}

	}

}
