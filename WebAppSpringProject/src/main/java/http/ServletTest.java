package http;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.HttpRequestHandler;


public class ServletTest extends HttpServlet implements HttpRequestHandler{
	
	private static Logger log = LoggerFactory.getLogger(ServletTest.class);
	
	private String defaultService;
	
	@Autowired
	@Qualifier("customer")
	private Customer customer;
	

	public String getDefaultService() {
		return defaultService;
	}

	public void setDefaultService(String defaultService) {
		this.defaultService = defaultService;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		handleRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		handleRequest(req, resp);
	}

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		log.debug("handleRequest..... ServiceName: " + getDefaultService() + " CustomerName " + customer.getName());
		
	}

	

}
