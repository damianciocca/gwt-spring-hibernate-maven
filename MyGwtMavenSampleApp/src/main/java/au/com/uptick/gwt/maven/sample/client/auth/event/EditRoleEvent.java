package au.com.uptick.gwt.maven.sample.client.auth.event;

import au.com.uptick.gwt.maven.sample.shared.auth.model.dto.RoleDto;

import com.google.gwt.event.shared.GwtEvent;

public class EditRoleEvent extends GwtEvent<EditRoleEventHandler> {

	public static Type<EditRoleEventHandler> TYPE = new Type<EditRoleEventHandler>();
	private RoleDto role;

	public EditRoleEvent(RoleDto role) {
		this.role = role;
	}

	@Override
	public Type<EditRoleEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EditRoleEventHandler handler) {
		handler.onEditRole(this);
	}

	public RoleDto getRole() {
		return role;
	}

}
