package au.com.uptick.gwt.maven.sample.server.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class JpaDao<PK, E>{

	@PersistenceContext        
	protected EntityManager entityManager;
	
	protected Class<E> entityClass;
	
	@SuppressWarnings("unchecked")
	public JpaDao() {
		
		System.out.println("JpaDao => constructor()");
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
		System.out.println("EntityClass " + this.entityClass);
	}

	public E persist(E entity) {
		entityManager.persist(entity);
		return entity;
	}

	public void remove(E entity) {
		entityManager.remove(entity);
	}

	public E merge(E entity) {
		return entityManager.merge(entity);
	}

	public void refresh(E entity) {
		entityManager.refresh(entity);
	}

	public E findById(PK id) {
		return entityManager.find(entityClass, id);
	}

	public E flush(E entity) {
		entityManager.flush();
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		
		Query query = entityManager.createQuery("SELECT h FROM " + entityClass.getName() + " h");
		return query.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
//	public Long getRealCount(String hql) {
//		int fromPosition = hql.indexOf("from ");
//		String restoQuery = hql.substring(fromPosition).replaceAll("fetch", "");
//		countQuery = entityManager.createQuery("select count(" + "*" + ") " + restoQuery);
//		for (String paramName : parameterMap.keySet()) {
//			countQuery.setParameter(paramName, parameterMap.get(paramName));
//		}
//		return (Long)countQuery.getSingleResult();
//	}
	
	

}