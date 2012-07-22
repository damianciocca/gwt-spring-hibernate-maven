package au.com.uptick.gwt.maven.sample.client.auth.presenter;

import java.util.Set;

import au.com.uptick.gwt.maven.sample.client.app.ClientFactory;
import au.com.uptick.gwt.maven.sample.client.app.MyAsyncCallback;
import au.com.uptick.gwt.maven.sample.client.app.utils.handlers.HasSelectedValue;
import au.com.uptick.gwt.maven.sample.client.auth.event.IPopulateRoleListPageEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.IRemoveRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.ISearchRoleEventHandler;
import au.com.uptick.gwt.maven.sample.client.auth.event.PopulateRoleListPageEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.RemoveRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.event.SearchRoleEvent;
import au.com.uptick.gwt.maven.sample.client.auth.place.RoleFormPlace;
import au.com.uptick.gwt.maven.sample.client.auth.place.RoleListPlace;
import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityServiceAsync;
import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;
import au.com.uptick.gwt.maven.sample.shared.auth.rpc.response.RoleListData;
import au.com.uptick.gwt.maven.sample.shared.auth.rpc.response.RoleListPageData;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.ResettableEventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;

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
public class RoleListPresenter extends AbstractActivity implements IRemoveRoleEventHandler, 
																   ISearchRoleEventHandler, 
																   IPopulateRoleListPageEventHandler{

	private final Display display;
	private final SecurityServiceAsync securityService;
	private final ClientFactory clientFactory;
	private final RoleListPlace place;
	private EventBus eventBus;
	private RoleDto roleDtoPaginableFilter;
	
	/**
	 * Interafce que debera implementar la vista (RoleView) 	
	 * @author dciocca
	 *
	 */
	public interface Display extends IsWidget {

		HasClickHandlers getAddButton();
		HasClickHandlers getDeleteButton();
		HasClickHandlers getEditButton();
		HasClickHandlers getSearchButton();
		HasSelectedValue<RoleDto> getRoleFilter();
		HasData<RoleDto> getCellTable();
		Set<RoleDto> getSelectedRows();

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
		
		//Cuando para la actividad los eventos registrados se quitan evitando problemas de memory leak!
		this.eventBus = new ResettableEventBus(eventBus);
		this.eventBus.addHandler(RemoveRoleEvent.TYPE, this);
		this.eventBus.addHandler(SearchRoleEvent.TYPE, this);
		this.eventBus.addHandler(PopulateRoleListPageEvent.TYPE, this);
		
		panel.setWidget(display.asWidget());
		// If you fire an event inside a start(), the event will be dispatched before the remaining activities are started. 
		// So there is a good chance that the activity handling that event has not been started yet (the registration was not done).
		// Scheduler is a utility class provided by GWT. ScheduleDeferred will execute the command after the current browser event loop returns.
		Scheduler.get().scheduleDeferred(new ScheduledCommand(){
		    public void execute(){
		    	System.out.println("Fires the event and handler receive events of this type: PopulateRoleListPageEvent");
		    	
		    	// TODO aca mediante el place, podemos recuperar el estado anterior de la grilla..
		    	// Esto queda pendiente ya que no nos cierra como obtener esos datos...
				
		    	eventBus.fireEvent(new PopulateRoleListPageEvent());
		    }
		});
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
				Set<RoleDto> selectedRows = display.getSelectedRows();
				if (selectedRows.size() == 1){
					RoleDto role = selectedRows.iterator().next();					
					clientFactory.getPlaceController().goTo(new RoleFormPlace(role.getId()));
				} else {
					Window.alert("Debe seleccionar solo un elemento");
				}
			}
		});
		
		display.getDeleteButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				if (!display.getSelectedRows().isEmpty()){
					Set<RoleDto> selectedRows = display.getSelectedRows();
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
	
	public void onPopulateRoleListPage(PopulateRoleListPageEvent event) {

		this.roleDtoPaginableFilter = event.getFilterRole();
		
		doSearchRoleGrid();
		doSearchRolePage();
	}
	
	public void onSearchRole(SearchRoleEvent event) {

		this.roleDtoPaginableFilter = event.getFilterRole();
		
		// De esta forma, limpiamos el contenido de la grilla. Resetamos la grilla.
		// Al pasarle FALSE, nos muestra la animacion del LOADING, si le pasamos TRUE o no le pasamos nada, 
		// no muestra la animacion. 
		display.getCellTable().setRowCount(0, false);
		// Y reseteamos el rango de paginacion y relanzamos la busqueda (gracias al TRUE, relanza el metodo 
		// onRangeChanged del AsyncDataProvider).
		display.getCellTable().setVisibleRangeAndClearData(new Range(0, 3), true);
	}	
	
	
	public void onRemoveRole(RemoveRoleEvent event) {
	
		securityService.deleteRoles(event.getRoles(), new MyAsyncCallback<Set<RoleDto>>() {

			public void onSuccess(Set<RoleDto> result) {
				
				System.out.println("onSuccess...");
				clientFactory.getEventBus().fireEvent(new SearchRoleEvent());
			}

			@Override
			public void onError(Throwable caught, boolean alreadyHandledError) {
				
				System.out.println("onError...");
			}
		});
	}	

	private void doSearchRoleGrid() {		
		
		AsyncDataProvider<RoleDto> provider = new AsyncDataProvider<RoleDto>() {

			@Override
			protected void onRangeChanged(HasData<RoleDto> display) {

				final int start = display.getVisibleRange().getStart();
				final int end = display.getVisibleRange().getLength();
				roleDtoPaginableFilter.setStartIndex(start);
				roleDtoPaginableFilter.setEndIndex(end);
				
				// Solo buscamos los datos de la grilla de roles.
				securityService.retriveRoleList(roleDtoPaginableFilter, new MyAsyncCallback<RoleListData>() {

					public void onSuccess(RoleListData roleListData) {

						System.out.println("onSuccess...");
						updateRowData(start, roleListData.getListRoles());
						updateRowCount(roleListData.getListRolesSize(), true);
									
					}

					@Override
					public void onError(Throwable caught, boolean alreadyHandledError) {

						System.out.println("onError...");

					}
				});
			}			
		};				
	
		provider.addDataDisplay(display.getCellTable());
	}
	
	private void doSearchRolePage() {
		
		// Aca buscamos todos los datos restantes de la pantalla del listado de roles.
		securityService.retriveRoleListPage(roleDtoPaginableFilter, new MyAsyncCallback<RoleListPageData>() {

			public void onSuccess(RoleListPageData roleListPageData) {

				System.out.println("onSuccess...");
				display.getRoleFilter().setValues(roleListPageData.getListRoles(), true);
			}

			@Override
			public void onError(Throwable caught, boolean alreadyHandledError) {

				System.out.println("onError...");
			}
		});
	}
	
}
