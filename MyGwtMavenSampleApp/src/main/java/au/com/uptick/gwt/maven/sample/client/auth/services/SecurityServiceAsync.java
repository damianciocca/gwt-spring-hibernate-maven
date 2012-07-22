package au.com.uptick.gwt.maven.sample.client.auth.services;

import java.util.List;
import java.util.Set;

import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;
import au.com.uptick.gwt.maven.sample.shared.auth.rpc.response.RoleListData;
import au.com.uptick.gwt.maven.sample.shared.auth.rpc.response.RoleListPageData;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SecurityServiceAsync {

	void saveRole(RoleDto role, AsyncCallback<RoleDto> callback);
	
	void upateRole(RoleDto role, AsyncCallback<RoleDto> callback);

	void deleteRoles(Set<RoleDto> roles, AsyncCallback<Set<RoleDto>> callback);

	void getUserLogged(AsyncCallback<String> callback);
	
	void retriveRoleById(Long id, AsyncCallback<RoleDto> callback);

	void retriveRoleListPage(RoleDto filter, AsyncCallback<RoleListPageData> callback);
	
	void retriveRoleList(RoleDto filter, AsyncCallback<RoleListData> callback);

}
