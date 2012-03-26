package au.com.uptick.gwt.maven.sample.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import au.com.uptick.gwt.maven.sample.client.CustomerService;
import au.com.uptick.gwt.maven.sample.client.auth.CustomAuthorizationException;
import au.com.uptick.gwt.maven.sample.server.dao.CustomerDao;
import au.com.uptick.gwt.maven.sample.shared.Customer;


@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	public String helloWorld(String name) throws CustomAuthorizationException{

		System.out.println("CustomerServiceImpl => helloWorld()");
		return "Hello " + name + " !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Customer saveCustomer(String name, String surname, String jobDescription) throws CustomAuthorizationException{

		System.out.println("CustomerServiceImpl => saveCustomer()");
		Customer customerPersisted1 = customerDao.persist(new Customer(name, surname, jobDescription));
		System.out.println("CUSTOMER ID: " + customerPersisted1.getEmployeeId());
		return customerPersisted1;
	}
}
