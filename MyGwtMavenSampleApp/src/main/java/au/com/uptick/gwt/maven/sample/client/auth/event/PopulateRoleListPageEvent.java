package au.com.uptick.gwt.maven.sample.client.auth.event;

import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;

import com.google.gwt.event.shared.GwtEvent;

public class PopulateRoleListPageEvent extends GwtEvent<IPopulateRoleListPageEventHandler> {

	RoleDto filterRole = new RoleDto();
	
	public static Type<IPopulateRoleListPageEventHandler> TYPE = new Type<IPopulateRoleListPageEventHandler>();

	public PopulateRoleListPageEvent() {
		super();
	}

	public PopulateRoleListPageEvent(RoleDto filterRole) {
		super();
		this.filterRole = filterRole;
	}

	@Override
	public Type<IPopulateRoleListPageEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(IPopulateRoleListPageEventHandler handler) {
		handler.onPopulateRoleListPage(this);
	}

	public RoleDto getFilterRole() {
		return filterRole;
	}

	public void setFilterRole(RoleDto filterRole) {
		this.filterRole = filterRole;
	}

}
