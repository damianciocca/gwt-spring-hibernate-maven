package au.com.uptick.gwt.maven.sample.client.auth.event;

import au.com.uptick.gwt.maven.sample.shared.auth.model.dto.RoleDto;

import com.google.gwt.event.shared.GwtEvent;

public class UpdatedRoleEvent extends GwtEvent<UpdatedRoleEventHandler> {

	public static Type<UpdatedRoleEventHandler> TYPE = new Type<UpdatedRoleEventHandler>();

	private RoleDto role;
	
	public UpdatedRoleEvent(RoleDto role) {
		super();
		this.role = role;
	}

	@Override
	public Type<UpdatedRoleEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UpdatedRoleEventHandler handler) {
		handler.onUpdatedRole(this);
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}
	
}
