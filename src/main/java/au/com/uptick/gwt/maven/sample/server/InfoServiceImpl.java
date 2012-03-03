package au.com.uptick.gwt.maven.sample.server;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import au.com.uptick.gwt.maven.sample.client.CustomerService;
import au.com.uptick.gwt.maven.sample.client.InfoService;

@Service("infoService")
public class InfoServiceImpl implements InfoService{

//	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public String helloWorld(String name) {

		System.out.println("InfoServiceImpl => helloWorld()");
		
		return name + " !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
	}

}
