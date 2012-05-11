package au.com.uptick.gwt.maven.sample.client.auth.event;

import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;

import com.google.gwt.event.shared.GwtEvent;

public class SaveRoleEvent extends GwtEvent<ISaveRoleEventHandler> {

	RoleDto role = new RoleDto();
	
	public static Type<ISaveRoleEventHandler> TYPE = new Type<ISaveRoleEventHandler>();
	
	public SaveRoleEvent(RoleDto role) {
		super();
		this.role = role;
	}
	
	@Override
	public Type<ISaveRoleEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ISaveRoleEventHandler handler) {
		handler.onSaveRole(this);
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

}
