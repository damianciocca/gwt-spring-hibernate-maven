package au.com.uptick.gwt.maven.sample.client.auth.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * The Event Bus is a mechanism for a) passing events and b) registering to be
 * notified of some subset of these events
 * 
 * App-wide events are really the only events that you want to be passing around
 * on the Event Bus. The app is uninterested in events such as *
 * "the user clicked enter" or "an RPC is about to be made". Instead (at least
 * in our example app), we pass around events such as a contact being updated,
 * the user switching to the edit view, or an RPC that deleted a user has
 * successfully returned from the server.
 * 
 * Each of events will extend GwtEvent and override dispatch() and
 * getAssociatedType().
 * 
 * Method dispatch() takes a single param of type EventHandler, and for our
 * application we have defined handler interfaces for each of our events.
 * 
 * @author dciocca
 * 
 */
public class AddRoleEvent extends GwtEvent<AddRoleEventHandler> {

	public static Type<AddRoleEventHandler> TYPE = new Type<AddRoleEventHandler>();

	@Override
	public Type<AddRoleEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AddRoleEventHandler handler) {
		handler.onAddRole(this);
	}

}
