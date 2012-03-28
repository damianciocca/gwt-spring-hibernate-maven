package au.com.uptick.gwt.maven.sample.client.auth.presenter;

import java.util.ArrayList;
import java.util.List;

import au.com.uptick.gwt.maven.sample.client.app.Presenter;
import au.com.uptick.gwt.maven.sample.client.auth.event.AddRoleEvent;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 * The presenter is going to need to:
 * 
 * 1. Respond to button clicks 
 * 2, Populate the list 
 * 2. Respond to a user clicking on a role in the list Query the view for selected roles
 * 
 * @author dciocca
 * 
 */
public class RolePresenter implements Presenter {

	// private final RoleService rpcService;
	private final HandlerManager eventBus;
	private final Display display;

	// TODO cuando se arme el servicio, tmb debe ir como parametro de entrada en
	// el constructor.
	public RolePresenter(HandlerManager eventBus, Display display) {
		super();
		this.eventBus = eventBus;
		this.display = display;
	}

	/**
	 * Interafce que debera implementar la vista (RoleView) 	
	 * @author dciocca
	 *
	 */
	public interface Display {

		HasClickHandlers getAddButton();
		
		HasClickHandlers getDeleteButton();
		
		HasClickHandlers getList();
		
		void setData(List<String> data);
		
		Widget asWidget();
	}

	/**
	 * Realiza el binding de cada uno de los componentes de la interface con el evento
	 * Por ejemplo, en este caso, al hacer clic en el boton de add role, se disparara
	 * el evento AddRoleEvent mediante el eventBus
	 */
	public void bind() {

		display.getAddButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				System.out.println("add button clic...");
				eventBus.fireEvent(new AddRoleEvent());
			}
		});
	}

	/**
	 * Permite mostrar el widget (la vista) en el root panel
	 */
	public void go(HasWidgets container) {

		bind();
		container.clear();
		container.add(display.asWidget());
		// TODO aqui deberemos ir con el servicio a la BD y obtenerlos de esa manera.
		List<String> data = retriveRoles();
		display.setData(data);
	}

	private List<String> retriveRoles() {

		List<String> data = new ArrayList<String>();
		data.add("ROLE 1");
		data.add("ROLE 2");
		data.add("ROLE 3");
		data.add("ROLE 4");
		data.add("ROLE 5");
		return data;
	}
}
