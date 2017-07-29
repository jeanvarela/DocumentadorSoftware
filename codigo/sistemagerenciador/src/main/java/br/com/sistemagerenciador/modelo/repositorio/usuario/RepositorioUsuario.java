package br.com.sistemagerenciador.modelo.repositorio.usuario;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.sistemagerenciador.modelo.entidade.usuario.Usuario;
import br.com.sistemagerenciador.modelo.repositorio.RepositorioBase;

public class RepositorioUsuario  extends RepositorioBase<Usuario> implements IRepositorioUsuario {

	public RepositorioUsuario(EntityManager em) {
		  super(em);
	}
	  
	@Override
	public Usuario logar(String login, String senha) {
//		Query query = getEntityManager().createQuery("from Usuario where " + 
//												     "email = :emailUsuario and senha = :senhaUsuario");
//		query.setParameter("emailUsuario", login);
//		query.setParameter("senhaUsuario", senha);
//		
//		return (List<Usuario>)query.getResultList();
		
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = builder.createQuery(Usuario.class);
		Root<Usuario> veiculo = criteriaQuery.from(Usuario.class);
		criteriaQuery.select(veiculo);
		
		Predicate predicado = builder.equal(veiculo.get("nome"),login);
		criteriaQuery.where(predicado);
		
		return getEntityManager().createQuery(criteriaQuery).getSingleResult();		
	}
}