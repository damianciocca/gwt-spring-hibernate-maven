package au.com.uptick.gwt.maven.sample.client.app;

import au.com.uptick.gwt.maven.sample.client.auth.event.AddRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.AddRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.AddedRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.AddedRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.RemovedRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.RemovedRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.UpdateRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.UpdateRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.CancelledUpdateOrAddRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.CancelledUpdateOrAddRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.UpdatedRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.UpdatedRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.presenter.RoleFormPresenter;
import au.com.uptick.gwt.maven.sample.client.auth.presenter.RoleListPresenter;
import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityService;
import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityServiceAsync;
import au.com.uptick.gwt.maven.sample.client.auth.view.RoleFormView;
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
	private static final String AUTH_ROLES_REMOVE = "auth_roles_remove";
	private HandlerManager eventBus;
	private HasWidgets container;
	private final SecurityServiceAsync securityService;

	public AppController(HandlerManager eventBus, SecurityServiceAsync securityService) {

		this.eventBus = eventBus;
		this.securityService = securityService;
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
		
		eventBus.addHandler(UpdateRoleEvent.TYPE, new UpdateRoleEventHandler() {
			public void onUpdateRole(UpdateRoleEvent event) {
				History.newItem(AUTH_ROLES_EDIT, false); // esto permite que no se dispare el metedo onValueChange()
				Presenter presenter = new RoleFormPresenter(securityService, eventBus, new RoleFormView(), event.getRole());
				presenter.go(container);
			}
		});
		
		eventBus.addHandler(UpdatedRoleEvent.TYPE, new UpdatedRoleEventHandler() {
			public void onUpdatedRole(UpdatedRoleEvent event) {
				System.out.println("Updated role => " + event.getRole());
				History.newItem(AUTH_ROLES_LIST);
			}
		});
		
		eventBus.addHandler(CancelledUpdateOrAddRoleEvent.TYPE, new CancelledUpdateOrAddRoleEventHandler() {
			public void onCancelledUpdateOrAddRole(CancelledUpdateOrAddRoleEvent event) {
				History.newItem(AUTH_ROLES_LIST);
			}
		});
		
		eventBus.addHandler(AddedRoleEvent.TYPE, new AddedRoleEventHandler() {
			public void onAddedRole(AddedRoleEvent event) {
				System.out.println("Added role => " + event.getRole());
				History.newItem(AUTH_ROLES_LIST);
			}
		});
		
		eventBus.addHandler(RemovedRoleEvent.TYPE, new RemovedRoleEventHandler() {
			public void onRemovedRole(RemovedRoleEvent event) {
				System.out.println("Removed role => " + event.toString());				
				// Como el token es el mismo, no se va a ejecutar el onValueChange mediante History.newItem(AUTH_ROLES_LIST);				
				// Por ende, forzamos que se ejecute.
				History.fireCurrentHistoryState();
			}
		});
		
	}

	public void onValueChange(ValueChangeEvent<String> event) {

		System.out.println("AppController => onValueChange [INICIO]");
		String token = event.getValue();
		
		if (token != null) {
			Presenter presenter = null;

			if (token.equals(AUTH_ROLES_LIST)) {
				presenter = new RoleListPresenter(securityService, eventBus, new RoleListView());
				presenter.go(container);
			} else if (token.equals(AUTH_ROLES_ADD)) {
				presenter = new RoleFormPresenter(securityService, eventBus, new RoleFormView());
				presenter.go(container);
			}  else if (token.equals(AUTH_ROLES_EDIT)) {
				presenter = new RoleFormPresenter(securityService, eventBus, new RoleFormView());
				presenter.go(container);
			}  else if (token.equals(AUTH_ROLES_REMOVE)) {
				presenter = new RoleListPresenter(securityService, eventBus, new RoleListView());
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
