package br.com.sistemagerenciador.util.banco;

import javax.persistence.Persistence;

public class GeraBanco {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("sistemagerenciador");
	}
}
