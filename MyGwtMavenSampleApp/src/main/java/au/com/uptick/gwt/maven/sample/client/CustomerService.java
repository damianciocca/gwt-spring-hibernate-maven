package au.com.uptick.gwt.maven.sample.client;

import org.springframework.security.access.prepost.PreAuthorize;

import au.com.uptick.gwt.maven.sample.shared.Customer;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("services/customerService")
public interface CustomerService extends RemoteService {

	@PreAuthorize("hasRole('PERM_VIEW_REPORTS')")
	public String helloWorld(String name);
	
	public Customer saveCustomer(String name, String surname, String jobDescription);



}
