package au.com.uptick.gwt.maven.sample.client.auth.presenter;

import au.com.uptick.gwt.maven.sample.client.app.MyAsyncCallback;
import au.com.uptick.gwt.maven.sample.client.app.Presenter;
import au.com.uptick.gwt.maven.sample.client.app.utils.FormTypeEnum;
import au.com.uptick.gwt.maven.sample.client.auth.event.AddedRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.CancelledUpdateOrAddRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.UpdatedRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityServiceAsync;
import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class RoleFormPresenter implements Presenter {

	private HandlerManager eventBus;
	private Display display;
	private RoleDto role;
	private FormTypeEnum formType;
	private final SecurityServiceAsync securityService;
	
	public interface Display {

		HasClickHandlers getSaveButton();
		HasClickHandlers getCancelButton();
		HasValue<String> getNameTxt();
		HasValue<String> getDescriptionTxt();
		Widget asWidget();
	}

	public void go(HasWidgets container) {
		
		container.clear();
	    container.add(display.asWidget());
	}
	
	/**
	 * Constructor que arma el formulario vacio. 
	 * Para ejecutar un alta.
	 * 
	 * @param eventBus
	 * @param display
	 */
	public RoleFormPresenter(SecurityServiceAsync securityService,  HandlerManager eventBus, Display display) {
		
		this.securityService = securityService;
		this.eventBus = eventBus;
		this.display = display;
		bind();	
		this.formType = FormTypeEnum.ADD_FORM;
	}

	/**
	 * Constructor que arma el formulario vacio. 
	 * Para ejecutar una modificacion.
	 * 
	 * @param eventBus
	 * @param display
	 * @param role
	 */
	public RoleFormPresenter(SecurityServiceAsync securityService, HandlerManager eventBus, Display display, RoleDto role) {
		
		this(securityService, eventBus, display);
		this.role = role;
		display.getNameTxt().setValue(role.getName());
		display.getDescriptionTxt().setValue(role.getDescription());
		this.formType = FormTypeEnum.EDIT_FORM;
		// En caso que se requiera mas datos para mostrar en este formulario de edicion, medinate el ID que este en
		// el parametro role, se podra ir a la BD y recuperar los datos necesarios.
		// Para este caso, no hace falta ir a la BD.
	}

	public void bind() {

		this.display.getSaveButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				if(FormTypeEnum.ADD_FORM.equals(formType)){
					doSave();
					
				} else if(FormTypeEnum.EDIT_FORM.equals(formType)){
					doUpdate();
					
				} else {
					throw new AssertionError("Unexcpected formType value " + formType); 
				}
			}
		});

		this.display.getCancelButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				System.out.println("Se cancela la actualizacion del rol");
				eventBus.fireEvent(new CancelledUpdateOrAddRoleEvent(role));
			}
		});
	}
	
	private void doSave() {
		
		role = new RoleDto();
		role.setName(display.getNameTxt().getValue());
		role.setDescription(display.getDescriptionTxt().getValue());
		securityService.saveRole(role, new MyAsyncCallback<RoleDto>(){
			public void onSuccess(RoleDto result) {
				
				System.out.println("onSuccess...");
				eventBus.fireEvent(new AddedRoleEvent(result));
			}

			@Override
			public void onError(Throwable caught, boolean alreadyHandledError) {
				
				System.out.println("onError...");
			}}
		);
	}
	
	public void doUpdate() {
		
		role.setName(display.getNameTxt().getValue());
		role.setDescription(display.getDescriptionTxt().getValue());
		securityService.upateRole(role, new MyAsyncCallback<RoleDto>() {

			public void onSuccess(RoleDto result) {
				
				System.out.println("onSuccess...");
				eventBus.fireEvent(new UpdatedRoleEvent(result));
			}

			@Override
			public void onError(Throwable caught, boolean alreadyHandledError) {
				
				System.out.println("onError...");
			}
		});
	}

}
