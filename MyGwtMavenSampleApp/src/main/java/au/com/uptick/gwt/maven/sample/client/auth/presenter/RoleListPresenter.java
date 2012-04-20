package au.com.uptick.gwt.maven.sample.client.auth.presenter;

import java.util.ArrayList;
import java.util.List;

import au.com.uptick.gwt.maven.sample.client.app.Presenter;
import au.com.uptick.gwt.maven.sample.client.auth.event.AddRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.EditRoleEvent;
import au.com.uptick.gwt.maven.sample.shared.auth.model.Role;
import au.com.uptick.gwt.maven.sample.shared.auth.model.dto.RoleDto;

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
		// TODO aqui deberemos ir con el servicio a la BD y obtenerlos de esa manera.
		List<RoleDto> roles = retriveRoles();
		display.setData(roles);
	}

	// TODO cuando se arme el servicio, tmb debe ir como parametro de entrada en
	// el constructor.
	public RoleListPresenter(HandlerManager eventBus, Display display) {
		
		super();
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
					eventBus.fireEvent(new EditRoleEvent(selectedRows.get(0)));
				} else {
					System.out.println("Debe seleccionar solo un elemento");
				}
			}
		});
		
		display.getDeleteButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				// Aqui no invocamos al eventBus. 
			}
		});
	}

	private List<RoleDto> retriveRoles() {

		// OJO no llevar las entities de JPA clientside
		/*
		 * Lazy properties issue : when trying to send a partially loaded Hibernate POJO to the client-side 
		 * of GWT (Javascript), the GWT compiler throws a Serialization exception because it the CGLIB generated proxy 
		 * does not belong to the JRE emulation.
		 * 
		 * Type issue : Hibernate replaces some basic Java types with various subclassed implementation (such as java.sql.Timestamp 
		 * instead of java.util.Date or PersistentList for List collections). 
		 * Javascript serialization of these classes will fail, since they do not belong to the JRE emulation 
		 * supported by GWT 1.4 (note : the Java SQL dates are now supported by GWT 1.5)
		 * 
		 */
		
		List<RoleDto> data = new ArrayList<RoleDto>();
		data.add(new RoleDto(1, "ADMINISTRADOR1", ""));
		data.add(new RoleDto(2, "ADMINISTRADOR2", ""));
		data.add(new RoleDto(3, "ADMINISTRADOR3", ""));
		return data;
	}
}
