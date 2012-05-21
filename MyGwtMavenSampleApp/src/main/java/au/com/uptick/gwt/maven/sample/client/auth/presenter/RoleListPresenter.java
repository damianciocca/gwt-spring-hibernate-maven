package au.com.uptick.gwt.maven.sample.client.auth.presenter;

import java.util.List;

import au.com.uptick.gwt.maven.sample.client.app.ClientFactory;
import au.com.uptick.gwt.maven.sample.client.app.MyAsyncCallback;
import au.com.uptick.gwt.maven.sample.client.app.utils.HasSelectedValue;
import au.com.uptick.gwt.maven.sample.client.auth.event.IRemoveRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.ISearchRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.RemoveRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.SearchRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.place.RoleFormPlace;
import au.com.uptick.gwt.maven.sample.client.auth.place.RoleListPlace;
import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityServiceAsync;
import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.ResettableEventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
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
public class RoleListPresenter extends AbstractActivity implements IRemoveRoleEventHandler, ISearchRoleEventHandler{

	private final Display display;
	private final SecurityServiceAsync securityService;
	private final ClientFactory clientFactory;
	private final RoleListPlace place;
	private EventBus eventBus;
	
	/**
	 * Interafce que debera implementar la vista (RoleView) 	
	 * @author dciocca
	 *
	 */
	public interface Display {

		HasClickHandlers getAddButton();
		HasClickHandlers getDeleteButton();
		HasClickHandlers getEditButton();
		HasClickHandlers getSearchButton();
		// List roles TODO esto tendriamos que mejorarlo para que solo tengamos el List
		HasClickHandlers getList();
		List<RoleDto> getListSelectedRows();
		void setListRows(List<RoleDto> data);
		// Combo roles
		HasSelectedValue<RoleDto> getRoleFilter();
		Widget asWidget();
	}

	public RoleListPresenter(RoleListPlace place, 
							 ClientFactory clientFactory, 
							 SecurityServiceAsync securityService, 
							 Display display) {
		
		this.place = place;
		this.securityService = securityService;
		this.clientFactory = clientFactory;
		this.display = display;
		bind();
		
	}
	
	/**
	 * Este metodo sera invocado mediante el ActivityManager para empezar con la actividad	
	 */
	public void start(AcceptsOneWidget panel, final EventBus eventBus) {
		
		// TODO aca mediante el place, podemos recuperar el estado anterior de la grilla..
		
		//Cuando para la actividad los eventos registrados se quitan evitando problemas de memory leak!
		this.eventBus = new ResettableEventBus(eventBus);
		this.eventBus.addHandler(RemoveRoleEvent.TYPE, this);
		this.eventBus.addHandler(SearchRoleEvent.TYPE, this);
		System.out.println("Fires the event and handler receive events of this type: SearchRoleEvent");
		panel.setWidget(display.asWidget());
		// If you fire an event inside a start(), the event will be dispatched before the remaining activities are started. 
		// So there is a good chance that the activity handling that event has not been started yet (the registration was not done).
		// Scheduler is a utility class provided by GWT. ScheduleDeferred will execute the command after the current browser event loop returns.
		Scheduler.get().scheduleDeferred(new ScheduledCommand(){
		    public void execute(){
		    	eventBus.fireEvent(new SearchRoleEvent());
		    }
		});
		// TODO hacer esto mediante el eventbus....
		retriveAllRoles();
	}

	

	/**
	 * Realiza el binding de cada uno de los componentes de la interface con el evento
	 * Por ejemplo, en este caso, al hacer clic en el boton de add role, se disparara
	 * el evento AddRoleEvent mediante el eventBus
	 */
	public void bind() {

		display.getAddButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				System.out.println("Request a change to a new place: RoleFormPlace");				
				clientFactory.getPlaceController().goTo(new RoleFormPlace(null));
			}
		});
		
		display.getEditButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				System.out.println("Request a change to a new place: RoleFormPlace");
				List<RoleDto> selectedRows = display.getListSelectedRows();
				if (selectedRows.size() == 1){
					RoleDto role = selectedRows.get(0);					
					clientFactory.getPlaceController().goTo(new RoleFormPlace(role.getId()));
				} else {
					System.out.println("Debe seleccionar solo un elemento");
				}
			}
		});
		
		display.getDeleteButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				if (!display.getListSelectedRows().isEmpty()){
					List<RoleDto> selectedRows = display.getListSelectedRows();
					System.out.println("Fires the event and handler receive events of this type: RemoveRoleEvent");
					eventBus.fireEvent(new RemoveRoleEvent(selectedRows));
					clientFactory.getPlaceController().goTo(new RoleListPlace());
				} else {
					System.out.println("Debe seleccionar al menos un elemento");
				}
			}
		});
		
		display.getSearchButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				System.out.println("Fires the event and handler receive events of this type: SearchRoleEvent");
				RoleDto filter = new RoleDto();
				RoleDto roleSelected = display.getRoleFilter().getSelectedValue();
				if (roleSelected != null){
					filter.setName(roleSelected.getName());
				}
				eventBus.fireEvent(new SearchRoleEvent(filter));	
			}
		});
	}

	public void onRemoveRole(RemoveRoleEvent event) {
	
		securityService.deleteRoles(event.getRoles(), new MyAsyncCallback<List<RoleDto>>() {

			public void onSuccess(List<RoleDto> result) {
				
				System.out.println("onSuccess...");
				clientFactory.getEventBus().fireEvent(new SearchRoleEvent());
			}

			@Override
			public void onError(Throwable caught, boolean alreadyHandledError) {
				
				System.out.println("onError...");
			}
		});
	}

	public void onSearchRole(SearchRoleEvent event) {

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
		securityService.retriveRoles(event.getFilter(), new MyAsyncCallback<List<RoleDto>>() {

			public void onSuccess(List<RoleDto> roles) {

				System.out.println("onSuccess...");
				display.setListRows(roles);			
			}

			@Override
			public void onError(Throwable caught, boolean alreadyHandledError) {

				System.out.println("onError...");

			}
		});		
	}
	
	public void retriveAllRoles() {
		// TODO hacer esto mediante el eventbus....
		securityService.retriveRoles(null, new MyAsyncCallback<List<RoleDto>>() {

			public void onSuccess(List<RoleDto> roles) {

				System.out.println("onSuccess...");
				display.getRoleFilter().setValues(roles);			
			}

			@Override
			public void onError(Throwable caught, boolean alreadyHandledError) {

				System.out.println("onError...");

			}
		});
	}

	
}
