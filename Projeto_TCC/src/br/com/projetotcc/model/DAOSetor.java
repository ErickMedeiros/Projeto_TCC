package br.com.projetotcc.model;


import java.io.Serializable;

import br.com.projetotcc.beans.Setor;
import br.com.projetotcc.conversores.ConverterOrdem;
import br.com.projetotcc.jpa.EntityManagerUtil;

@SuppressWarnings("serial")
public class DAOSetor<T> extends GenericDAO<T>  implements Serializable{ 

	public DAOSetor(){
		super.setClasse(Setor.class);
		super.setEm(EntityManagerUtil.getEntityManager());
		super.getListaOrdem().add(new Ordem("Código", "id"));
		super.getListaOrdem().add(new Ordem("Nome", "nome"));
		super.setOrdemAtual((Ordem) super.getListaOrdem().get(1));
		super.setFiltro("");
		super.setMaximoObjetos(1);
		super.setConverterOrdem(new ConverterOrdem(super.getListaOrdem()));
	}
		
}
