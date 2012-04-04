package au.com.uptick.gwt.maven.sample.client.auth.event;

import com.google.gwt.event.shared.GwtEvent;

public class EditRoleEvent extends GwtEvent<EditRoleEventHandler> {

	public static Type<EditRoleEventHandler> TYPE = new Type<EditRoleEventHandler>();
	private long roleID;
	
	public EditRoleEvent(long roleID) {
		this.roleID = roleID;
	}

	@Override
	public Type<EditRoleEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EditRoleEventHandler handler) {
		handler.onEditRole(this);
	}

	public long getRoleID() {
		return roleID;
	}

}
