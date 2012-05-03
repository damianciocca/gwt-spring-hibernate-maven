package au.com.uptick.gwt.maven.sample.client.auth.presenter;

import java.util.List;

import au.com.uptick.gwt.maven.sample.client.app.MyAsyncCallback;
import au.com.uptick.gwt.maven.sample.client.app.Presenter;
import au.com.uptick.gwt.maven.sample.client.auth.event.AddRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.RemovedRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.UpdateRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.UpdatedRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityServiceAsync;
import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;
import au.com.uptick.gwt.maven.sample.shared.auth.model.Role;

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
public class RoleListPresenter implements Presenter {

	// private final RoleService rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	private List<Role> roleList;
	private final SecurityServiceAsync securityService;
	
	/**
	 * Interafce que debera implementar la vista (RoleView) 	
	 * @author dciocca
	 *
	 */
	public interface Display {

		HasClickHandlers getAddButton();
		HasClickHandlers getDeleteButton();
		HasClickHandlers getEditButton();
		HasClickHandlers getList();
		List<RoleDto> getSelectedRows();
		void setData(List<RoleDto> data);
		Widget asWidget();
	}
	
	/**
	 * Permite mostrar el widget (la vista) en el root panel
	 */
	public void go(HasWidgets container) {

		bind();
		container.clear();
		container.add(display.asWidget());
		retriveRoles();
		
	}

	public RoleListPresenter(SecurityServiceAsync securityService, HandlerManager eventBus, Display display) {
		
		this.securityService = securityService;
		this.eventBus = eventBus;
		this.display = display;
		
	}

	/**
	 * Realiza el binding de cada uno de los componentes de la interface con el evento
	 * Por ejemplo, en este caso, al hacer clic en el boton de add role, se disparara
	 * el evento AddRoleEvent mediante el eventBus
	 */
	public void bind() {

		display.getAddButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				System.out.println("eventBus => AddRoleEvent");
				eventBus.fireEvent(new AddRoleEvent());
			}
		});
		
		display.getEditButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				System.out.println("eventBus => EditRoleEvent");
				List<RoleDto> selectedRows = display.getSelectedRows();
				if (selectedRows.size() == 1){
					eventBus.fireEvent(new UpdateRoleEvent(selectedRows.get(0)));
				} else {
					System.out.println("Debe seleccionar solo un elemento");
				}
			}
		});
		
		display.getDeleteButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				if (!display.getSelectedRows().isEmpty()){
					doRemove(display.getSelectedRows());
				} else {
					System.out.println("Debe seleccionar al menos un elemento");
				}
			}
		});
	}

	protected void doRemove(List<RoleDto> roles) {

		securityService.deleteRoles(roles, new MyAsyncCallback<List<RoleDto>>() {

			public void onSuccess(List<RoleDto> result) {
				
				System.out.println("onSuccess...");
				eventBus.fireEvent(new RemovedRoleEvent(result));
			}

			@Override
			public void onError(Throwable caught, boolean alreadyHandledError) {
				
				System.out.println("onError...");
			}
			
		});
		
	}

	private void retriveRoles() {

		/*
		 * NO llevar las entities de JPA clientside:
		 * 
		 * Lazy properties issue : when trying to send a partially loaded
		 * Hibernate POJO to the client-side of GWT (Javascript), the GWT
		 * compiler throws a Serialization exception because it the CGLIB
		 * generated proxy does not belong to the JRE emulation.
		 * 
		 * Type issue : Hibernate replaces some basic Java types with various
		 * subclassed implementation (such as java.sql.Timestamp instead of
		 * java.util.Date or PersistentList for List collections).
		 * 
		 * Javascript serialization of these classes will fail, since they do
		 * not belong to the JRE emulation supported by GWT 1.4 (note : the Java
		 * SQL dates are now supported by GWT 1.5)
		 */
		securityService.retriveRoles(new RoleDto(), new MyAsyncCallback<List<RoleDto>>() {

					public void onSuccess(List<RoleDto> roles) {

						System.out.println("onSuccess...");
						display.setData(roles);
					}

					@Override
					public void onError(Throwable caught, boolean alreadyHandledError) {

						System.out.println("onError...");

					}
				}
		);
	}
}
