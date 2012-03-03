package au.com.uptick.gwt.maven.sample.server;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import au.com.uptick.gwt.maven.sample.client.CustomerService;
import au.com.uptick.gwt.maven.sample.client.InfoService;
import au.com.uptick.gwt.maven.sample.server.dao.CustomerDao;
import au.com.uptick.gwt.maven.sample.shared.Customer;


@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	InfoService infoService;
	
	@Autowired
	CustomerDao customerDao;
	
//	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public String helloWorld(String name) {

		System.out.println("CustomerServiceImpl => helloWorld()");
		
		return infoService.helloWorld(name);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Customer saveCustomer(String name, String surname, String jobDescription) {

		System.out.println("CustomerServiceImpl => saveCustomer()");
		
		Customer customerPersisted1 = customerDao.persist(new Customer(name, surname, jobDescription));
		System.out.println("CUSTOMER ID: " + customerPersisted1.getEmployeeId());
		

		return customerPersisted1;
		
		
	}

}
