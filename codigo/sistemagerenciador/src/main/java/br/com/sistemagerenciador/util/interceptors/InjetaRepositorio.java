package br.com.sistemagerenciador.util.interceptors;

import java.lang.reflect.Field;

import javax.annotation.PostConstruct;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.sistemagerenciador.modelo.repositorio.RepositorioBase;
import br.com.sistemagerenciador.modelo.repositorio.factory.RepositorioFactory;
import br.com.sistemagerenciador.util.anotacoes.RepositorioAnnotation;

/**
 * Classe usada para injetar o <code>DAO</code> nos
 * atributos dos EJBs.
 */
public class InjetaRepositorio {

  /**
   * Construtor.
   */
  public InjetaRepositorio() {
  }

  /**
   * EntityManager ser� repassando ao <code>DAO</code>.
   */
  @PersistenceContext(unitName="primary")
  private EntityManager entityManager;

  /**
   * Este m�todo � usado ap�s o EJB ser criado, e dentro
   * do EJB procura os <code>DAO</code>s que precisa instanciar.
   * @param invocationContext - Alvo que ser� adicionado 
   *        o <code>DAO</code>.
   * @throws Exception - Exce��o lan�ada caso ocorra algum 
   *         problema quando 
   * adicionar o <code>DAO</code>.
   */
  @PostConstruct
  public void postConstruct(final InvocationContext
    invocationContext) throws Exception {
    //Pega o alvo
    Object target = invocationContext.getTarget();

    //Pega a classe alvo.
    Class classe = target.getClass();
    //Procura os atributos da classe.
    Field[] fields = classe.getDeclaredFields();

    /* Verifica se algum dos campos da classe possui 
      o DAOAnnotation. */
    for (Field field : fields) {
      if (field.isAnnotationPresent(RepositorioAnnotation.class)) {
        /* Quando encontrar algum atributo, com DAOAnnotation,
           gera uma instancia do DAO.*/
        this.injetaDAO(field, target, this.entityManager);
      }
    }
  }

  /**
   * M�todo usado para gerar uma instancia do <code>DAO</code>
   * e atribui-la ao atributo.
   * 
   * @param field - Atributo que vai receber o <code>DAO</code>.
   * @param target - Classe alvo.
   * @param entityManager - <code>EntityManager</code> que ser�
   *        usado na instancia do <code>DAO</code>.
   * @throws Exception - Exce��o lan�ada caso ocorra algum 
   *         problema quando adicionar o <code>DAO</code>.
   */
  private void injetaDAO(final Field field, final Object 
    target, final EntityManager entityManager) throws Exception {
    //Pega a classe do DAO que sera instanciado.
    Class clazz = field.getType();

    //Gera uma instancia do DAO.
    RepositorioBase  dao = RepositorioFactory.instanciarDAO(entityManager, clazz);

    //Verifica se o atributo esta acess�vel.
    boolean acessivel = field.isAccessible();

    //Se o atributo nao e acess�vel, deixa ele como acess�vel.
    if (!acessivel) {
      field.setAccessible(true);
    }

    //Seta o DAO no atributo.
    field.set(target, dao);

    //Se o atributo nao e acessivel, volta ao valor original.
    if (!acessivel) {
      field.setAccessible(acessivel);
    }
  }
}