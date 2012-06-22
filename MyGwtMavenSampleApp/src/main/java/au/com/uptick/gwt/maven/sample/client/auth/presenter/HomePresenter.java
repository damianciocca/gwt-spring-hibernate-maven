package au.com.uptick.gwt.maven.sample.client.auth.presenter;

import au.com.uptick.gwt.maven.sample.client.app.ClientFactory;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

public class HomePresenter extends AbstractActivity  {

	private final Display display;
	private final ClientFactory clientFactory;
	
	public interface Display extends IsWidget {

	}
	
	public HomePresenter(Display display, ClientFactory clientFactory) {
		
		this.display=display;
		this.clientFactory = clientFactory;
	}

	/**
     * Este metodo sera invocado mediante el ActivityManager para empezar con la actividad
     */
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
		panel.setWidget(display.asWidget());
		
	}

}
