package au.com.uptick.gwt.maven.sample.client.auth.presenter;

import au.com.uptick.gwt.maven.sample.client.app.ClientFactory;
import au.com.uptick.gwt.maven.sample.client.app.MyAsyncCallback;
import au.com.uptick.gwt.maven.sample.client.app.utils.FormTypeEnum;
import au.com.uptick.gwt.maven.sample.client.auth.event.ISaveRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.ISearchRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.IUpdateRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.SaveRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.SearchRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.UpdateRoleEvent;
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
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

public class RoleFormPresenter extends AbstractActivity implements ISaveRoleEventHandler, IUpdateRoleEventHandler, ISearchRoleEventHandler{

	private EventBus eventBus;
	private Display display;
	private RoleDto role;
	private FormTypeEnum formType;
	private final SecurityServiceAsync securityService;
	private final RoleFormPlace place;
	private final ClientFactory clientFactory;
	
	public interface Display {

		HasClickHandlers getSaveButton();
		HasClickHandlers getCancelButton();
		HasValue<String> getNameTxt();
		HasValue<String> getDescriptionTxt();
		Widget asWidget();
	}
	
	/**
	 * Constructor que arma el formulario vacio para el alta o un formulario con un rol para la edicion. 
	 * 
	 */
	public RoleFormPresenter(RoleFormPlace place, 
							 ClientFactory clientFactory, 
							 SecurityServiceAsync securityService, 
							 Display display, 
							 FormTypeEnum formType) {
		
		this.place = place;
		this.clientFactory = clientFactory;
		this.securityService = securityService;
		this.display = display;
		bind();	
		this.formType = formType;
	}	
	

	/**
	 * adding your handlers to the bus passed to the start method would have the same effect re. your handlers, 
	 * except that they're automatically removed when the activity is stopped (onStop or onCancel) 
	 * so you're guaranteed to not leak.
	 * Or you fire events, and then again, the bus passed to the start method will simply delegate to the 
	 * global bus (the one passed to the ActivityManager), so it's not an issue either
	 * 
	 * Don't inject the bus! use the one from start()!
	 */
	public void start(AcceptsOneWidget panel, final EventBus eventBus) {
		
		//Cuando para la actividad los eventos registrados se quitan evitando problemas de memory leak!
		this.eventBus = eventBus;
		this.eventBus.addHandler(SaveRoleEvent.TYPE, this);
		this.eventBus.addHandler(UpdateRoleEvent.TYPE, this);
		this.eventBus.addHandler(SearchRoleEvent.TYPE, this);

		if (FormTypeEnum.EDIT_FORM.equals(formType)){			
			if (place.getRoleId() != null){
				final RoleDto filter = new RoleDto();
				filter.setId(place.getRoleId());
				// If you fire an event inside a start(), the event will be dispatched before the remaining activities are started. 
				// So there is a good chance that the activity handling that event has not been started yet (the registration was not done).
				// Scheduler is a utility class provided by GWT. ScheduleDeferred will execute the command after the current browser event loop returns.
				Scheduler.get().scheduleDeferred(new ScheduledCommand(){
				    public void execute(){
				    	eventBus.fireEvent(new SearchRoleEvent(filter));
				    }
				});
			} else {
				// TODO lanzar una ventana de error.
				System.out.println("no deberia pasar que no venga un ID de role para editar...");
			}
		}
		panel.setWidget(display.asWidget());
	}

	public void bind() {

		this.display.getSaveButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				if(FormTypeEnum.ADD_FORM.equals(formType)){					
					RoleDto role = new RoleDto();
					role.setName(display.getNameTxt().getValue());
					role.setDescription(display.getDescriptionTxt().getValue());
					System.out.println("Fires the event and handler receive events of this type: SaveRoleEvent");
					eventBus.fireEvent(new SaveRoleEvent(role));
					
				} else if(FormTypeEnum.EDIT_FORM.equals(formType)){
					
					role.setName(display.getNameTxt().getValue());
					role.setDescription(display.getDescriptionTxt().getValue());
					System.out.println("Fires the event and handler receive events of this type: UpdateRoleEvent");
					eventBus.fireEvent(new UpdateRoleEvent(role));
					
				} else {
					throw new AssertionError("Unexcpected formType value " + formType); 
				}
			}
		});

		this.display.getCancelButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				System.out.println("Request a change to a new place: RoleListPlace");
				clientFactory.getPlaceController().goTo(new RoleListPlace());
			}
		});
	}
	
	public void onSaveRole(SaveRoleEvent event) {
		
		RoleDto role = event.getRole();
		securityService.saveRole(role, new MyAsyncCallback<RoleDto>(){
			public void onSuccess(RoleDto result) {
				
				System.out.println("onSuccess...");
				System.out.println("Request a change to a new place: RoleListPlace");
				clientFactory.getPlaceController().goTo(new RoleListPlace());
			}

			@Override
			public void onError(Throwable caught, boolean alreadyHandledError) {
				
				System.out.println("onError...");
			}}
		);
		
	}

	public void onUpdateRole(UpdateRoleEvent event) {

		RoleDto role = event.getRole();
		securityService.upateRole(role, new MyAsyncCallback<RoleDto>() {

			public void onSuccess(RoleDto result) {
				
				System.out.println("onSuccess...");
				System.out.println("Request a change to a new place: RoleListPlace");
				clientFactory.getPlaceController().goTo(new RoleListPlace());
			}

			@Override
			public void onError(Throwable caught, boolean alreadyHandledError) {
				
				System.out.println("onError...");
			}
		});
		
	}


	public void onSearchRole(SearchRoleEvent event) {

		securityService.retriveRoleById(event.getFilterRole().getId(), new MyAsyncCallback<RoleDto>() {

			public void onSuccess(RoleDto roleDto) {
				
				role = roleDto;
				display.getNameTxt().setValue(roleDto.getName());
				display.getDescriptionTxt().setValue(roleDto.getDescription());
				System.out.println("onSuccess...");
				
			}

			@Override
			public void onError(Throwable caught, boolean alreadyHandledError) {

				System.out.println("onError...");

			}
		});
		
	}

	

}
