package au.com.uptick.gwt.maven.sample.client.auth.services;

import java.util.Set;

import org.springframework.security.access.prepost.PreAuthorize;

import au.com.uptick.gwt.maven.sample.client.auth.exceptions.SecurityException;
import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;
import au.com.uptick.gwt.maven.sample.shared.auth.rpc.response.RoleListData;
import au.com.uptick.gwt.maven.sample.shared.auth.rpc.response.RoleListPageData;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("services/securityService")
public interface SecurityService extends RemoteService {

	@PreAuthorize("hasRole('PERM_CREATE_ROLES')")
	public RoleDto saveRole(RoleDto role) throws SecurityException;

	@PreAuthorize("hasRole('PERM_UPDATE_ROLES')")
	RoleDto upateRole(RoleDto role) throws SecurityException;
	
	@PreAuthorize("hasRole('PERM_REMOVE_ROLES')")
	Set<RoleDto> deleteRoles(Set<RoleDto> roles) throws SecurityException;
	
	@PreAuthorize("hasRole('PERM_LIST_ROLES')")
	RoleDto retriveRoleById(Long id) throws SecurityException;
	
	RoleListPageData retriveRoleListPage(RoleDto filter) throws SecurityException;
	
	@PreAuthorize("hasRole('PERM_LIST_ROLES')")
	RoleListData retriveRoleList(RoleDto filter) throws SecurityException;
	
	String getUserLogged();


	

}