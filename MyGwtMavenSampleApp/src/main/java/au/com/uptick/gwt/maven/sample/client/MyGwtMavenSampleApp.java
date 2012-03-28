package au.com.uptick.gwt.maven.sample.client;

import au.com.uptick.gwt.maven.sample.client.app.AppController;
import au.com.uptick.gwt.maven.sample.shared.Customer;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyGwtMavenSampleApp implements EntryPoint {

	private final CustomerServiceAsync customerServiceAsync = GWT.create(CustomerService.class);

	/**
	 * This is the entry point method.
	 */

	public void onModuleLoad() {

		GWT.log("onModuleLoading...... INICIO");
		System.out.println("onModuleLoading...... INICIO");
		
	    HandlerManager eventBus = new HandlerManager(null);
	    AppController appViewer = new AppController(eventBus);
	    appViewer.go(RootPanel.get());
		
		
		/*
		final Button saveButton = new Button("SAVE - PERM_CREATE_USERS");
		final Button searchButton = new Button("EDIT - PERM_REMOVE_USERS");
		final Button updateButton = new Button("UPDATE - PERM_UPDATE_USERS");
		final Button helloButton = new Button("REMOVE - PERM_UPDATE_USERS");

		final TextBox nameTextbox = new TextBox();
		final Label infoLabel = new Label();

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameTextbox);
		VerticalPanel panel = new VerticalPanel();
		panel.add(saveButton);
		panel.add(searchButton);
		panel.add(updateButton);
		panel.add(helloButton);
		RootPanel.get("sendButtonContainer").add(panel);
		RootPanel.get("errorLabelContainer").add(infoLabel);

		// Focus the cursor on the name field when the app loads
		nameTextbox.setFocus(true);
		nameTextbox.selectAll();

		searchButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {

				System.out.println("search button (PERM_SEARCH_USERS)");

				customerServiceAsync.searchCustomer("", "", "", new MyAsyncCallback<Void>(){

					public void onSuccess(Void result) {
						System.out.println("onSuccess... metodo ejecutado satisfactoriamente");
					}

					@Override
					public void onError(Throwable caught, boolean alreadyHandledError) {
						System.out.println("onError... " + caught);
					}}
				);
			}
		});

		updateButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {

				System.out.println("search button (PERM_EDIT_USERS)");

				customerServiceAsync.updateCustomer("", "", "", new MyAsyncCallback<Void>(){

					public void onSuccess(Void result) {
						System.out.println("onSuccess... metodo ejecutado satisfactoriamente");
					}

					@Override
					public void onError(Throwable caught,boolean alreadyHandledError) {
						System.out.println("onError... " + caught);
					}}
				);
			}
		});

		saveButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {

				System.out.println("save button (PERM_CREATE_USERS)");

				customerServiceAsync.saveCustomer("NAME", "pepito", "JOB_DESC", new MyAsyncCallback<Customer>() {


					public void onSuccess(Customer result) {

						System.out.println("onSuccess... metodo ejecutado satisfactoriamente");
						infoLabel.setText(result.getEmployeeId() + " - " + result.getEmployeeSurname());

					}

					@Override
					public void onError(Throwable caught, boolean alreadyHandledError) {
						System.out.println("onError... " + caught);

					}
				});
			}
		});
		
		helloButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				
				System.out.println("hello button (PERM_HELLO_USERS)");

				customerServiceAsync.helloWorld("NAME", new MyAsyncCallback<String>() {

					public void onSuccess(String result) {
						
						System.out.println("onSuccess... metodo ejecutado satisfactoriamente");
					}

					@Override
					public void onError(Throwable caught, boolean alreadyHandledError) {
						
						System.out.println("onError... " + caught);
					}
				});
			}
		});

		*/
		
		GWT.log("onModuleLoading...... FIN");
		System.out.println("onModuleLoading...... FIN");
	}
}
