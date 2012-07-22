package au.com.uptick.gwt.maven.sample.client.auth.event;

import java.util.Set;
import java.util.TreeSet;

import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;

import com.google.gwt.event.shared.GwtEvent;

public class RemoveRoleEvent extends GwtEvent<IRemoveRoleEventHandler> {

	Set<RoleDto> roles = new TreeSet<RoleDto>();
	
	public static Type<IRemoveRoleEventHandler> TYPE = new Type<IRemoveRoleEventHandler>();
	
	public RemoveRoleEvent(Set<RoleDto> roles) {
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

	public Set<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDto> roles) {
		this.roles = roles;
	}

}
