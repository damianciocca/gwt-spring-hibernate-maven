package au.com.uptick.gwt.maven.sample.client.auth.event;

import au.com.uptick.gwt.maven.sample.shared.auth.model.dto.RoleDto;

import com.google.gwt.event.shared.GwtEvent;

public class AddedRoleEvent extends GwtEvent<AddedRoleEventHandler> {

	public static Type<AddedRoleEventHandler> TYPE = new Type<AddedRoleEventHandler>();

	private RoleDto role;
	
	public AddedRoleEvent(RoleDto role) {
		super();
		this.role = role;
	}

	@Override
	public Type<AddedRoleEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AddedRoleEventHandler handler) {
		handler.onAddedRole(this);
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}
	
}

