package au.com.uptick.gwt.maven.sample.client.auth.services;

import org.springframework.security.access.prepost.PreAuthorize;

import au.com.uptick.gwt.maven.sample.shared.auth.model.dto.RoleDto;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("services/securityService")
public interface SecurityService extends RemoteService {

	@PreAuthorize("hasRole('PERM_CREATE_ROLES')")
	public RoleDto saveRole(RoleDto role);

}
