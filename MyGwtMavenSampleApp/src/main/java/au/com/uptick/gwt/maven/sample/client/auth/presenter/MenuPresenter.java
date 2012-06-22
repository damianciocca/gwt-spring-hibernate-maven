package au.com.uptick.gwt.maven.sample.client.auth.presenter;

import au.com.uptick.gwt.maven.sample.client.app.ClientFactory;
import au.com.uptick.gwt.maven.sample.client.app.utils.handlers.HasCommandHandler;
import au.com.uptick.gwt.maven.sample.client.auth.place.MenuPlace;
import au.com.uptick.gwt.maven.sample.client.auth.place.RoleListPlace;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Presenter/activity asociado a un place: {@link MenuPlace}.
 * 
 * @author dciocca
 */
public class MenuPresenter extends AbstractActivity  {

	private final Display display;
	private final ClientFactory clientFactory;
	
	public interface Display extends IsWidget{
		
		  HasCommandHandler getMenuAdminUser(); 
          HasCommandHandler getMenuAdminRole();
          HasCommandHandler getMenuAdminPermission();
		
	}

	public MenuPresenter(Display display, ClientFactory clientFactory) {
		
		this.display=display;
		this.clientFactory = clientFactory;
		bind();
	}

	private void bind() {
		
		
		display.getMenuAdminUser().addCommandHandler(new Command() {
			
			public void execute() {
				
				Window.alert("USERR");
				
			}
		});
		
		display.getMenuAdminRole().addCommandHandler(new Command() {
			
			public void execute() {
				
				clientFactory.getPlaceController().goTo(new RoleListPlace());
				
			}
		});
		
		display.getMenuAdminPermission().addCommandHandler(new Command() {
			
			public void execute() {
				
				Window.alert("PERMISOOO");
				
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
