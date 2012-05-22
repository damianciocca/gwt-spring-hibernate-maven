package au.com.uptick.gwt.maven.sample.client;

import au.com.uptick.gwt.maven.sample.client.app.ClientFactory;
import au.com.uptick.gwt.maven.sample.client.app.MyAsyncCallback;
import au.com.uptick.gwt.maven.sample.client.auth.place.AppPlaceHistoryMapper;
import au.com.uptick.gwt.maven.sample.client.auth.place.MainPlace;
import au.com.uptick.gwt.maven.sample.client.auth.place.RoleListPlace;
import au.com.uptick.gwt.maven.sample.client.auth.presenter.AppActivityMapper;
import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityService;
import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityServiceAsync;
import au.com.uptick.gwt.maven.sample.client.auth.view.MainView;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyGwtMavenSampleApp implements EntryPoint {

	private static final String USER_DIV = "user";
	private static final String HOME_DIV = "home";
	private final SecurityServiceAsync securityService = GWT.create(SecurityService.class);
	
	private Place defaultPlace = new MainPlace();
	private SimplePanel appWidget = new SimplePanel();

	/**
	 * This is the entry point method.
	 */

	public void onModuleLoad() {

		GWT.log("onModuleLoading...... INICIO");
		System.out.println("onModuleLoading...... INICIO");

		securityService.getUserLogged(new MyAsyncCallback<String>() {

			public void onSuccess(String result) {
				
				SimplePanel panel = new SimplePanel();
				Label userLoggedLbl = new Label();
				userLoggedLbl.setText(result);
				panel.add(userLoggedLbl);
				RootPanel.get(USER_DIV).add(panel);
			}

			@Override
			public void onError(Throwable caught, boolean alreadyHandledError) {

				System.out.println("error..");
			}
		});

		// Create ClientFactory using deferred binding so we can replace with different impls in gwt.xml
		ClientFactory clientFactory = GWT.create(ClientFactory.class);
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();

		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(appWidget);

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootPanel.get(HOME_DIV).add(appWidget);
		
		// Goes to place represented on URL or default place
		historyHandler.handleCurrentHistory();
		
		

		GWT.log("onModuleLoading...... FIN");
		System.out.println("onModuleLoading...... FIN");
	}
}
