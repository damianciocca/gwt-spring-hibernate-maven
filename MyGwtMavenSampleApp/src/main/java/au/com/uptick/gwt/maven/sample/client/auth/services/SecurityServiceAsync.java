package au.com.uptick.gwt.maven.sample.client.auth.services;

import java.util.List;

import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;
import au.com.uptick.gwt.maven.sample.shared.auth.rpc.response.RoleFormData;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SecurityServiceAsync {

	void saveRole(RoleDto role, AsyncCallback<RoleDto> callback);
	
	void upateRole(RoleDto role, AsyncCallback<RoleDto> callback);

	void retriveRoles(RoleDto role, AsyncCallback<List<RoleDto>> callback);
	
	void retriveRoleById(Long id, AsyncCallback<RoleDto> callback);

	void deleteRoles(List<RoleDto> roles, AsyncCallback<List<RoleDto>> callback);

	void getUserLogged(AsyncCallback<String> callback);

	void retriveRoleFormData(RoleDto filter, AsyncCallback<RoleFormData> callback);

}
