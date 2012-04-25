package au.com.uptick.gwt.maven.sample.server.auth.services;

import org.springframework.stereotype.Service;

import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityService;
import au.com.uptick.gwt.maven.sample.shared.auth.model.dto.RoleDto;

@Service("securityService")
public class SecurityServiceImpl implements SecurityService{

	public RoleDto saveRole(RoleDto role) {
		
		System.out.println("SAVE ROLE.... " + role);
		return null;
	}

}
