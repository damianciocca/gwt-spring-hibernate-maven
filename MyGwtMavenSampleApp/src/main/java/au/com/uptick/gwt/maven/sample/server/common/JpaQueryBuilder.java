package au.com.uptick.gwt.maven.sample.server.common;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JpaQueryBuilder<T> {
	
	StringBuffer jpql = new StringBuffer();
	HashMap<String, Object> paramMap = new HashMap<String, Object>();
	private final EntityManager em;

	public JpaQueryBuilder(EntityManager em) {

		this.em = em;
	}
	
	public void addInitialClause(String initialClause){
		
		jpql.append(initialClause);
	}
	
	public void addAndClause(String clause, String paramName, Object paramValue){
		
		if(paramValue != null){
			jpql.append(" AND ");
			addClause(clause);
			addParameter(paramName, paramValue);
		}
	}
	
	public QueryList<T> executeQuery(Integer start, Integer end){
		
		Query query = em.createQuery(jpql.toString());
		
		if(start != null){
			query.setFirstResult(start);
		}
		if(end != null){
			query.setMaxResults(start + end);
		}
		
		Set<String> ParamSet = paramMap.keySet();
		for (String paramName : ParamSet) {
			query.setParameter(paramName, paramMap.get(paramName));
		}
	
		List<T> resultList = query.getResultList();
		QueryList<T> result = new QueryList<T>();
		result.setList(resultList);
		result.setCount(-1);
		
		return result;
	}
	
	private void addClause(String clause){
		
		jpql.append(" ").append(clause);
	}
	
	private void addParameter(String paramName, Object paramValue){
		
		paramMap.put(paramName, paramValue);
	}
	
	
	
	

}
