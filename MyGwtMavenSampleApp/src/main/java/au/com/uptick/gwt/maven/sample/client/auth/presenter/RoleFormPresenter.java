package au.com.uptick.gwt.maven.sample.client.auth.presenter;

import java.util.List;

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
	private Long roleId = null;
	
	public interface Display {

		HasClickHandlers getSaveButton();
		HasClickHandlers getCancelButton();
		HasValue<String> getNameTxt();
		HasValue<String> getDescriptionTxt();
		Widget asWidget();
	}
	
	/**
	 * Constructor que arma el formulario vacio. 
	 * Para ejecutar un alta.
	 * 
	 */
	public RoleFormPresenter(RoleFormPlace place, ClientFactory clientFactory, SecurityServiceAsync securityService, Display display) {
		
		this.place = place;
		this.clientFactory = clientFactory;
		this.securityService = securityService;
		this.display = display;
		bind();	
		this.formType = FormTypeEnum.ADD_FORM;
	}	
	

	/**
	 * Constructor que arma el formulario con datos. 
	 * Para ejecutar una modificacion.
	 * 
	 */
	public RoleFormPresenter(RoleFormPlace place, ClientFactory clientFactory, SecurityServiceAsync securityService, Display display, Long roleId) {
		
		this(place, clientFactory, securityService, display);
		this.roleId = roleId;				
		this.formType = FormTypeEnum.EDIT_FORM;		
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
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
		// TODO aca mediante el place, podemos recuperar el estado anterior del form..
		
		//Cuando para la actividad los eventos registrados se quitan evitando problemas de memory leak!
		this.eventBus = eventBus;
		this.eventBus.addHandler(SaveRoleEvent.TYPE, this);
		this.eventBus.addHandler(UpdateRoleEvent.TYPE, this);
		if (roleId != null){
			RoleDto filter = new RoleDto();
			filter.setId(roleId);
			//this.eventBus.fireEvent(new SearchRoleEvent(filter));
			onSearchRole(new SearchRoleEvent(filter));
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

		securityService.retriveRoles(event.getFilter(), new MyAsyncCallback<List<RoleDto>>() {

			public void onSuccess(List<RoleDto> roles) {
				
				// TODO mejorar esto!
				RoleDto roleDto = roles.get(0);
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
