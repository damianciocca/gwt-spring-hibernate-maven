package au.com.uptick.gwt.maven.sample.client.auth.event;

import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;

import com.google.gwt.event.shared.GwtEvent;

public class SearchRoleEvent extends GwtEvent<ISearchRoleEventHandler> {

	private RoleDto filter = new RoleDto();
	public static Type<ISearchRoleEventHandler> TYPE = new Type<ISearchRoleEventHandler>();
	
	public SearchRoleEvent(RoleDto filter) {
		super();
		this.filter = filter;
	}
	
	public SearchRoleEvent() {
		super();
		this.filter = new RoleDto();
	}

	@Override
	public Type<ISearchRoleEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ISearchRoleEventHandler handler) {
		handler.onSearchRole(this);
	}

	public RoleDto getFilter() {
		return filter;
	}

}
