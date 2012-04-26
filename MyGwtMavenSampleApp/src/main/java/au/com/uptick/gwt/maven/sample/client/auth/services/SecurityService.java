package au.com.uptick.gwt.maven.sample.client.auth.services;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import au.com.uptick.gwt.maven.sample.shared.auth.model.dto.RoleDto;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("services/securityService")
public interface SecurityService extends RemoteService {

	@PreAuthorize("hasRole('PERM_CREATE_ROLES')")
	public RoleDto saveRole(RoleDto role);

	@PreAuthorize("hasRole('PERM_UPDATE_ROLES')")
	RoleDto upateRole(RoleDto role);
	
	@PreAuthorize("hasRole('PERM_LIST_ROLES')")
	List<RoleDto> retriveRoles(RoleDto role);

}
