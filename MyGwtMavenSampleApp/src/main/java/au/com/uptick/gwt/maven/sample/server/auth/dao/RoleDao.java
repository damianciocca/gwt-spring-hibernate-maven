package au.com.uptick.gwt.maven.sample.server.auth.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import au.com.uptick.gwt.maven.sample.server.dao.JpaDao;
import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;
import au.com.uptick.gwt.maven.sample.shared.auth.model.Role;

@Repository("roleDAO")
public class RoleDao extends JpaDao<Long, Role>{
	
	public List<Role> retriveRoles(RoleDto filter){
		
		StringBuffer q = new StringBuffer();
		q.append("SELECT r FROM Role r WHERE 1=1 ");
		
		if (filter != null && filter.getId() != null){
			q.append(" AND r.roleId = :id");			
		}
		if (filter != null && filter.getName() != null){
			q.append(" AND r.roleName = :name");			
		}
		
		Query query = entityManager.createQuery(q.toString());
		
		if (filter != null && filter.getId() != null){
			query.setParameter("id", filter.getId());
		}
		if (filter != null && filter.getName() != null){
			query.setParameter("name", filter.getName());		
		}
		
		if (filter != null){
			int startPosition = filter.getStartIndex() ;
			int endPosition = filter.getStartIndex() + filter.getEndIndex();
			System.out.println("START " + startPosition);
			System.out.println("END: " + endPosition );
			query.setFirstResult(startPosition);
			query.setMaxResults(endPosition);
		}

		return query.getResultList();
	}
	
	// TODO armar algo que en un solo metodo me devuelva tanto el listado como el 
	// count del mismo. Para esto armar una clase que sea como un wrapper por 
	// ejemplo QueryBuilder
	public Long retriveRolesCount(RoleDto filter){
		
		StringBuffer q = new StringBuffer();
		q.append("SELECT  count(r) FROM Role r WHERE 1=1 ");
		
		if (filter != null && filter.getId() != null){
			q.append(" AND r.roleId = :id");			
		}
		if (filter != null && filter.getName() != null){
			q.append(" AND r.roleName = :name");			
		}
		
		Query query = entityManager.createQuery(q.toString());
		
		if (filter != null && filter.getId() != null){
			query.setParameter("id", filter.getId());
		}
		if (filter != null && filter.getName() != null){
			query.setParameter("name", filter.getName());		
		}

		return (Long)query.getSingleResult();
		
	}

}
