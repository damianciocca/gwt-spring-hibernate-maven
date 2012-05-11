package au.com.uptick.gwt.maven.sample.client.auth.event;

import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateRoleEvent extends GwtEvent<IUpdateRoleEventHandler> {

	public static Type<IUpdateRoleEventHandler> TYPE = new Type<IUpdateRoleEventHandler>();
	private RoleDto role;

	public UpdateRoleEvent(RoleDto role) {
		this.role = role;
	}

	@Override
	public Type<IUpdateRoleEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(IUpdateRoleEventHandler handler) {
		handler.onUpdateRole(this);
	}

	public RoleDto getRole() {
		return role;
	}

}
