package au.com.uptick.gwt.maven.sample.client.auth.services;

import au.com.uptick.gwt.maven.sample.shared.auth.model.dto.RoleDto;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SecurityServiceAsync {

	void saveRole(RoleDto role, AsyncCallback<RoleDto> callback);
	
	void upateRole(RoleDto role, AsyncCallback<RoleDto> callback);

}
