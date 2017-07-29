package br.com.sistemagerenciador.util.producer;

import javax.persistence.Persistence;

public class GerarBanco {
	
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("sistemagerenciador");
		}

}
