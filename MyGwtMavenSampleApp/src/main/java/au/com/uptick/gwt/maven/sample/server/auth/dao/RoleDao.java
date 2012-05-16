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
		q.append("SELECT r FROM Role r WHERE 1=1");
		
		if (filter.getId() != null){
			q.append("AND r.roleId :id");			
		}
		if (filter.getName() != null){
			q.append("AND r.roleName :name");			
		}
		
		Query query = entityManager.createQuery(q.toString());
		
		if (filter.getId() != null){
			query.setParameter(":id", filter.getId());
		}
		if (filter.getName() != null){
			query.setParameter(":name", filter.getName());		
		}
		
		return query.getResultList();
	}

}
