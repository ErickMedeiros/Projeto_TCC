package br.com.projetotcc.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Ordem implements Serializable{
  
	private String rotulo;
	private String atributo;
	
		
	
	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	public String getAtributo() {
		return atributo;
	}
	
	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}
	public Ordem(String rotulo, String atributo) {
	
		this.rotulo = rotulo;
		this.atributo = atributo;
	}
	@Override
	public String toString() {
		return rotulo;
	}
	
	

}
