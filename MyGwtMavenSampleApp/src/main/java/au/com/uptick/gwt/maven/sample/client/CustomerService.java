package au.com.uptick.gwt.maven.sample.client;

import org.springframework.security.access.prepost.PreAuthorize;

import au.com.uptick.gwt.maven.sample.client.auth.CustomAuthorizationException;
import au.com.uptick.gwt.maven.sample.shared.Customer;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("services/customerService")
public interface CustomerService extends RemoteService {

	@PreAuthorize("hasRole('PERM_VIEW_REPORTS2')")
	public String helloWorld(String name) throws CustomAuthorizationException;
	
	public Customer saveCustomer(String name, String surname, String jobDescription) throws CustomAuthorizationException;



}
