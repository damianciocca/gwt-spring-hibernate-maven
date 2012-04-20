package au.com.uptick.gwt.maven.sample.client.auth.presenter;

import au.com.uptick.gwt.maven.sample.client.app.Presenter;
import au.com.uptick.gwt.maven.sample.client.auth.event.UpdateCancelledRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.UpdatedRoleEvent;
import au.com.uptick.gwt.maven.sample.shared.auth.model.dto.RoleDto;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class RoleEditPresenter implements Presenter {

	private HandlerManager eventBus;
	private Display display;
	private RoleDto role;

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
	
	public RoleEditPresenter(/** ContactsServiceAsync rpcService, */ HandlerManager eventBus, Display display) {
		// this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		bind();	
	}

	public RoleEditPresenter(/** ContactsServiceAsync rpcService, */ HandlerManager eventBus, Display display, RoleDto role) {
		this(eventBus, display);
		this.role = role;
		display.getNameTxt().setValue(role.getName());
		display.getDescriptionTxt().setValue(role.getDescription());
		// En caso que se requiera mas datos para mostrar en este formulario de edicion, medinate el ID que este en
		// el parametro role, se podra ir a la BD y recuperar los datos necesarios.
		// Para este caso, no hace falta ir a la BD.
	}

	public void bind() {

		this.display.getSaveButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				System.out.println("Procedemos a grabar el rol que estamos editando...");

				// Luego lanzamos el evento que se actualizo satisfactoriamente..
				// Le tenemos que pasar por parametro el role actualizado
				 eventBus.fireEvent(new UpdatedRoleEvent(role));
			}
		});

		this.display.getCancelButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				System.out.println("Se cancela la actualizacion del rol");
				eventBus.fireEvent(new UpdateCancelledRoleEvent(role));
			}
		});
	}

}
