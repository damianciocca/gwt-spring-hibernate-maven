package au.com.uptick.gwt.maven.sample.client.app;

import au.com.uptick.gwt.maven.sample.client.auth.event.AddRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.AddRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.EditRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.EditRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.UpdateCancelledRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.UpdateCancelledRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.UpdatedRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.UpdatedRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.presenter.RoleEditPresenter;
import au.com.uptick.gwt.maven.sample.client.auth.presenter.RoleListPresenter;
import au.com.uptick.gwt.maven.sample.client.auth.view.RoleEditView;
import au.com.uptick.gwt.maven.sample.client.auth.view.RoleListView;

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

	private static final String AUTH_ROLES_LIST = "auth_roles_list";
	private static final String AUTH_ROLES_EDIT = "auth_roles_edit";
	private static final String AUTH_ROLES_ADD = "auth_roles_add";
	private HandlerManager eventBus;
	private HasWidgets container;

	// TODO cuando tengamos el servicio, tenemos que pasarlo como parametro
	public AppController(HandlerManager eventBus) {

		this.eventBus = eventBus;
		// this.rpcService = rpcService;
		bind();
	}

	private void bind() {
		
		// Adds a ValueChangeEvent handler to be informed of changes to the browser's history stack.
		History.addValueChangeHandler(this); 	

		eventBus.addHandler(AddRoleEvent.TYPE, new AddRoleEventHandler() {
			public void onAddRole(AddRoleEvent event) {
				History.newItem(AUTH_ROLES_ADD);
			}
		});
		
		eventBus.addHandler(EditRoleEvent.TYPE, new EditRoleEventHandler() {
			public void onEditRole(EditRoleEvent event) {
				History.newItem(AUTH_ROLES_EDIT, false); // esto permite que no se dispare el metedo onValueChange()
				Presenter presenter = new RoleEditPresenter(eventBus, new RoleEditView(), event.getRole());
				presenter.go(container);
			}
		});
		
		eventBus.addHandler(UpdatedRoleEvent.TYPE, new UpdatedRoleEventHandler() {
			public void onUpdatedRole(UpdatedRoleEvent event) {
				History.newItem(AUTH_ROLES_LIST);
			}
		});
		
		eventBus.addHandler(UpdateCancelledRoleEvent.TYPE, new UpdateCancelledRoleEventHandler() {
			public void onUpdateCancelledRole(UpdateCancelledRoleEvent event) {
				History.newItem(AUTH_ROLES_LIST);
			}
		});
		
	}

	public void onValueChange(ValueChangeEvent<String> event) {

		System.out.println("AppController => onValueChange [INICIO]");
		String token = event.getValue();
		
		if (token != null) {
			Presenter presenter = null;

			if (token.equals(AUTH_ROLES_LIST)) {
				presenter = new RoleListPresenter(eventBus, new RoleListView());
				presenter.go(container);
			} else if (token.equals(AUTH_ROLES_ADD)) {
				presenter = new RoleEditPresenter(eventBus, new RoleEditView());
				presenter.go(container);
			}  else if (token.equals(AUTH_ROLES_EDIT)) {
				// Esto funcion para el caso que el usuario quiera volver para atras al formulario 
				// Para esto se debera mantener el estado.
				presenter = new RoleEditPresenter(eventBus, new RoleEditView());
				presenter.go(container);
			} else {
				System.out.println("No se obtuvo el presenter para el token: " + token);
			}
		}
		System.out.println("AppController => onValueChange [FIN]");
	}

	/**
	 * Este metodo se ejecutara cuando se inicia al app o bien cuando refrescamos el browser.
	 * 
	 */
	public void go(HasWidgets container) {

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
			// Añadiendo esto al browser, causa que se dispare ValueChangeHandler.onValueChange
			History.newItem(AUTH_ROLES_LIST); 
		} else {			
			History.fireCurrentHistoryState(); // Causa que se dispare ValueChangeHandler.onValueChange
		}
	}
}
