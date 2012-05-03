package au.com.uptick.gwt.maven.sample.client.auth.event;

import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;

import com.google.gwt.event.shared.GwtEvent;

public class CancelledUpdateOrAddRoleEvent extends GwtEvent<CancelledUpdateOrAddRoleEventHandler> {

	public static Type<CancelledUpdateOrAddRoleEventHandler> TYPE = new Type<CancelledUpdateOrAddRoleEventHandler>();

	private RoleDto role;
	
	public CancelledUpdateOrAddRoleEvent(RoleDto role) {
		super();
		this.role = role;
	}

	@Override
	public Type<CancelledUpdateOrAddRoleEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(CancelledUpdateOrAddRoleEventHandler handler) {
		handler.onCancelledUpdateOrAddRole(this);
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}
	
}
