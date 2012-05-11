package au.com.uptick.gwt.maven.sample.client.auth.presenter;

import au.com.uptick.gwt.maven.sample.client.app.ClientFactory;
import au.com.uptick.gwt.maven.sample.client.auth.place.MainPlace;
import au.com.uptick.gwt.maven.sample.client.auth.place.RoleListPlace;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Presenter/activity asociado a un place: {@link MainPlace}.
 * @author dciocca
 *
 */
public class MainPresenter extends AbstractActivity  {

	private final Display display;
	private final ClientFactory clientFactory;
	
	public interface Display extends IsWidget{
		
		HasClickHandlers getRoleButton();
		
	}

	public MainPresenter(Display display, ClientFactory clientFactory) {
		
		this.display=display;
		this.clientFactory = clientFactory;
		bind();
	}

	private void bind() {
		
		// TODO NO ESTAMOS USANDO EL EVENT BUS PARA ESTO!!!!
		display.getRoleButton().addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {

				clientFactory.getPlaceController().goTo(new RoleListPlace());
			}
		});
	}

	/**
     * Este metodo sera invocado mediante el ActivityManager para empezar con la actividad
     */
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
     	panel.setWidget(display.asWidget());
	}

}
