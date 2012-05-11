package au.com.uptick.gwt.maven.sample.client.app;


import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory
{
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);

	public EventBus getEventBus()
	{
		return eventBus;
	}

	public PlaceController getPlaceController()
	{
		return placeController;
	}

}
