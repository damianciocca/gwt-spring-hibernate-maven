package au.com.uptick.gwt.maven.sample.client.app;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

/**
 * A ClientFactory is not required to use Activities and Places; however, it is helpful to use 
 * a factory or dependency injection framework like GIN to obtain references to objects 
 * needed throughout your application like the event bus. 
 * Our ClientFactory provide an EventBus, GWT PlaceController, and view implementations.
 * 
 * @author dciocca
 *
 */
public interface ClientFactory
{
	EventBus getEventBus();
	
	PlaceController getPlaceController();
	
}
