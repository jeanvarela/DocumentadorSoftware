package br.com.sistemagerenciador.modelo.repositorio.factory;

import java.lang.reflect.Constructor;

import javax.persistence.EntityManager;

import br.com.sistemagerenciador.modelo.repositorio.RepositorioBase;

/**
 * Essa Factory gera instancias automática do <code>DAO</code>.
 * Utilizando o <code>DAOAnnotation</code> nos atributos dos 
 * EJBs, pega qual a classe do <code>DAO</code> gera uma nova
 * instancia.
 */
public final class RepositorioFactory {

  /**
   * Construtor privado.
   */
  private RepositorioFactory() {
  }

  /**
   * Método responsável por criar uma instancia do
   * <code>DAO</code>.
   * 
   * @param entityManager - <code>EntityManager</code> que é 
   * usado no construtor do <code>DAO</code>.
   * @param clazz - Classe do DAO que será criado.
   * @return Instancia do DAO.
   * @throws Exception - Exceção lançada caso ocorra algum 
   * problema ao instanciar o <code>DAO</code>.
   */
  public static RepositorioBase instanciarDAO(final EntityManager entityManager,
		                                      final Class<? extends RepositorioBase> clazz) throws Exception {
    
	/* Usando Reflection para pegar o construtor do DAO que 
       recebe um EntityManager como parametro. */
    Constructor construtor = clazz.getConstructor(EntityManager.class);

    /* Cria uma instancia do DAO passando o EntityManager 
      como parámetro. */
    return (RepositorioBase) construtor.newInstance(entityManager);
  }
}