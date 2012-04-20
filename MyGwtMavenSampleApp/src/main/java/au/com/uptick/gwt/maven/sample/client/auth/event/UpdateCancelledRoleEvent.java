package au.com.uptick.gwt.maven.sample.client.auth.event;

import au.com.uptick.gwt.maven.sample.shared.auth.model.dto.RoleDto;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateCancelledRoleEvent extends GwtEvent<UpdateCancelledRoleEventHandler> {

	public static Type<UpdateCancelledRoleEventHandler> TYPE = new Type<UpdateCancelledRoleEventHandler>();

	private RoleDto role;
	
	public UpdateCancelledRoleEvent(RoleDto role) {
		super();
		this.role = role;
	}

	@Override
	public Type<UpdateCancelledRoleEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdateCancelledRoleEventHandler handler) {
		handler.onUpdateCancelledRole(this);
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}
	
}
