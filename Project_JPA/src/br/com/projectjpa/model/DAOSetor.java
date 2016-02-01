package br.com.projectjpa.model;


import java.io.Serializable;

import br.com.projectjpa.beans.Setor;
import br.com.projectjpa.conversores.ConverterOrdem;
import br.com.projectjpa.jpa.EntityManagerUtil;

@SuppressWarnings("serial")
public class DAOSetor<T> extends GenericDAO<T>  implements Serializable{ 

	public DAOSetor(){
		super.setClasse(Setor.class);
		super.setEm(EntityManagerUtil.getEntityManager());
		super.getListaOrdem().add(new Ordem("Código", "id"));
		super.getListaOrdem().add(new Ordem("Nome", "nome"));
		super.setOrdemAtual((Ordem) super.getListaOrdem().get(1));
		super.setFiltro("");
		super.setMaximoObjetos(2);
		super.setConverterOrdem(new ConverterOrdem(super.getListaOrdem()));
	}
		
}
