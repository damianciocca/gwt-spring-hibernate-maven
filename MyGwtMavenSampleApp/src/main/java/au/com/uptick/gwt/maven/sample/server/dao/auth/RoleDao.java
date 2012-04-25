package au.com.uptick.gwt.maven.sample.server.dao.auth;

import org.springframework.stereotype.Repository;

import au.com.uptick.gwt.maven.sample.server.dao.JpaDao;
import au.com.uptick.gwt.maven.sample.shared.auth.model.Role;

@Repository("roleDAO")
public class RoleDao extends JpaDao<Long, Role>{

}
