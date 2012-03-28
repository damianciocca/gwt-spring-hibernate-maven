package au.com.uptick.gwt.maven.sample.client.app;

import au.com.uptick.gwt.maven.sample.client.auth.event.AddRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.AddRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.presenter.RolePresenter;
import au.com.uptick.gwt.maven.sample.client.auth.view.RoleView;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * To handle logic that is not specific to any presenter and instead resides at
 * the application layer, we'll introduce the AppController component. This
 * component contains the history management and view transition logic.
 * 
 * @author dciocca
 * 
 */
public class AppController implements Presenter, ValueChangeHandler<String> {

	private HandlerManager eventBus;
	private HasWidgets container;

	// TODO cuando tengamos el servicio, tenemos que pasarlo como parametro
	public AppController(HandlerManager eventBus) {

		this.eventBus = eventBus;
		// this.rpcService = rpcService;
		bind();
	}

	private void bind() {

		// Adds a ValueChangeEvent handler to be informed of changes to the 
		// browser's history stack.	
		History.addValueChangeHandler(this);

		// Agregamos al event bus el evento de add role
		eventBus.addHandler(AddRoleEvent.TYPE, new AddRoleEventHandler() {
			public void onAddRole(AddRoleEvent event) {
				System.out.println("onAddRole....");
				History.newItem("add");
			}
		});
	}

	public void onValueChange(ValueChangeEvent<String> event) {

		System.out.println("onValueChange...");
		String token = event.getValue();

		if (token != null) {
			Presenter presenter = null;

			if (token.equals("list_role")) {
				presenter = new RolePresenter(eventBus, new RoleView());
				System.out.println("ir al listaod de roles..");
			} else if (token.equals("add_role")) {
				System.out.println("ir al formulario de alta de rol..");
				// presenter = new EditContactPresenter(rpcService, eventBus,
				// new EditContactView());
			}  else if (token.equals("edit_role")) {
				System.out.println("ir al formulario de edicion del rol..");
				// presenter = new EditContactPresenter(rpcService, eventBus,
				// new EditContactView());
			}

			if (presenter != null) {
				presenter.go(container);
			} else {
				System.out.println("No se obtuvo el presenter para el token: " + token);
			}
		}
	}

	/**
	 * Este metodo se ejecutara cuando se inicia al app o bien cuando refrescamos el browser.
	 * 
	 */
	public void go(HasWidgets container) {

		System.out.println("go...");
		this.container = container;

		if ("".equals(History.getToken())) {
			/*
			 * History class: This class allows you to interact with the browser's history
			 * stack. Each "item" on the stack is represented by a single
			 * string, referred to as a "token". You can create new history
			 * items (which have a token associated with them when they are
			 * created), and you can programmatically force the current history
			 * to move back or forward
			 */
			// TODO aqui tendremos que agregar el token que nos llevara al HOME de la app.
			History.newItem("list_role"); // Añadiendo esto al browser, causa que se dispare ValueChangeHandler.onValueChange
										
		} else {			
			History.fireCurrentHistoryState(); // Causa que se dispare ValueChangeHandler.onValueChange
		}
	}
}
