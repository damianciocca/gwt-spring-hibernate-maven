package au.com.uptick.gwt.maven.sample.server.dao;

import org.springframework.stereotype.Repository;

import au.com.uptick.gwt.maven.sample.shared.Customer;

@Repository("customerDAO")
public class CustomerDao extends JpaDao<Long, Customer>{
	

}
