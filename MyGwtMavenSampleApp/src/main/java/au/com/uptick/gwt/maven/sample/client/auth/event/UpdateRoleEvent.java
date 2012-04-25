package au.com.uptick.gwt.maven.sample.client.auth.event;

import au.com.uptick.gwt.maven.sample.shared.auth.model.dto.RoleDto;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateRoleEvent extends GwtEvent<UpdateRoleEventHandler> {

	public static Type<UpdateRoleEventHandler> TYPE = new Type<UpdateRoleEventHandler>();
	private RoleDto role;

	public UpdateRoleEvent(RoleDto role) {
		this.role = role;
	}

	@Override
	public Type<UpdateRoleEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateRoleEventHandler handler) {
		handler.onUpdateRole(this);
	}

	public RoleDto getRole() {
		return role;
	}

}
