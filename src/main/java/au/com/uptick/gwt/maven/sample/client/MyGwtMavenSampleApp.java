package au.com.uptick.gwt.maven.sample.client;

import au.com.uptick.gwt.maven.sample.shared.Customer;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

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
		
		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();
		
		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();


		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				sendButton.setEnabled(false);

				customerServiceAsync.helloWorld(textToServer, new AsyncCallback<String>() {

					public void onFailure(Throwable caught) {
						
						System.out.println("onFailure..." + caught);
						
					}

					public void onSuccess(String result) {

						System.out.println("onSuccess...");
						
						customerServiceAsync.saveCustomer("NAME", "pepito", "JOB_DESC", new AsyncCallback<Customer>() {

							public void onFailure(Throwable caught) {
								
								System.out.println("onFailure... " + caught);
								
							}

							public void onSuccess(Customer result) {

								System.out.println("onSuccess...");
								errorLabel.setText(result.getEmployeeId() + " - " + result.getEmployeeSurname());
								
							}
						});
					}
				});
				
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);
		
		GWT.log("onModuleLoading...... FIN");
		System.out.println("onModuleLoading...... FIN");
	}
}
