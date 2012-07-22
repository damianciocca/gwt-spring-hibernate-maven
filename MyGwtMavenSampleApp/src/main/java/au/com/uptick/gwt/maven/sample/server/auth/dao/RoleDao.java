package au.com.uptick.gwt.maven.sample.server.auth.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import au.com.uptick.gwt.maven.sample.server.common.JpaQueryBuilder;
import au.com.uptick.gwt.maven.sample.server.common.QueryList;
import au.com.uptick.gwt.maven.sample.server.dao.JpaDao;
import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;
import au.com.uptick.gwt.maven.sample.shared.auth.model.Role;

@Repository("roleDAO")
public class RoleDao extends JpaDao<Long, Role>{
	
	public List<Role> retriveRoles(RoleDto filter){
		
		JpaQueryBuilder<Role> qb = new JpaQueryBuilder<Role>(getEntityManager());
		qb.addInitialClause("SELECT r FROM Role r WHERE 1=1");
		
		if (filter != null){
			qb.addAndClause("r.roleId = :id", "id", filter.getId());
			qb.addAndClause("r.roleName = :name", "name", filter.getName());
			QueryList<Role> result  = qb.executeQuery(filter.getStartIndex(), filter.getEndIndex());
			return result.getList();
			
		} else {
			
			QueryList<Role> result = qb.executeQuery(null, null);
			return result.getList();
		}
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
