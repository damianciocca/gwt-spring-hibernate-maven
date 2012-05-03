package au.com.uptick.gwt.maven.sample.client.auth.event;

import java.util.List;

import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;

import com.google.gwt.event.shared.GwtEvent;

public class RemovedRoleEvent extends GwtEvent<RemovedRoleEventHandler> {

	public static Type<RemovedRoleEventHandler> TYPE = new Type<RemovedRoleEventHandler>();

	private List<RoleDto> removedRoles;
	
	public RemovedRoleEvent(List<RoleDto> removedRoles) {
		super();
		this.removedRoles = removedRoles;
	}

	@Override
	public Type<RemovedRoleEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RemovedRoleEventHandler handler) {
		handler.onRemovedRole(this);
	}

	public List<RoleDto> getRemovedRoles() {
		return removedRoles;
	}

	public void setRemovedRoles(List<RoleDto> removedRoles) {
		this.removedRoles = removedRoles;
	}

	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		if (removedRoles != null){
			for (RoleDto role : removedRoles) {
				sb.append(role.toString());
			}
		}
		return "RemovedRoleEvent: " + (sb.length() == 0 ? "-" : sb.toString());
	}
	
	
	
}


