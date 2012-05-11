package au.com.uptick.gwt.maven.sample.client.auth.event;

import java.util.ArrayList;
import java.util.List;

import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;

import com.google.gwt.event.shared.GwtEvent;

public class RemoveRoleEvent extends GwtEvent<IRemoveRoleEventHandler> {

	List<RoleDto> roles = new ArrayList<RoleDto>();
	
	public static Type<IRemoveRoleEventHandler> TYPE = new Type<IRemoveRoleEventHandler>();
	
	public RemoveRoleEvent(List<RoleDto> roles) {
		super();
		this.roles = roles;
	}

	@Override
	public Type<IRemoveRoleEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(IRemoveRoleEventHandler handler) {
		handler.onRemoveRole(this);
	}

	public List<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}

}
