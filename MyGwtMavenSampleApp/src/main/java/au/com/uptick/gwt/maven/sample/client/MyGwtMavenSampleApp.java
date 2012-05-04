package au.com.uptick.gwt.maven.sample.client;

import au.com.uptick.gwt.maven.sample.client.app.AppController;
import au.com.uptick.gwt.maven.sample.client.app.MyAsyncCallback;
import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityService;
import au.com.uptick.gwt.maven.sample.client.auth.services.SecurityServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyGwtMavenSampleApp implements EntryPoint {

	private static final String USER_DIV = "user";
	private static final String HOME_DIV = "home";
	private final SecurityServiceAsync securityService = GWT.create(SecurityService.class);

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

		HandlerManager eventBus = new HandlerManager(null);
		AppController appViewer = new AppController(eventBus, securityService);
		appViewer.go(RootPanel.get(HOME_DIV));

		GWT.log("onModuleLoading...... FIN");
		System.out.println("onModuleLoading...... FIN");
	}
}
