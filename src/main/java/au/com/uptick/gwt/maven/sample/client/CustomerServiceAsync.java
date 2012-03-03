package au.com.uptick.gwt.maven.sample.client;

import au.com.uptick.gwt.maven.sample.shared.Customer;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CustomerServiceAsync {
	
	public void helloWorld(String name, AsyncCallback<String> callback);

	public void saveCustomer(String name, String surname,String jobDescription, AsyncCallback<Customer> callback);

}
