package com.mkyong;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

// http://www.mkyong.com/wicket/wicket-hello-world-example-with-maven-tutorial/
// http://javaeenotes.blogspot.com.ar/2011/05/creating-modal-window-page-with-apache.html

public class MyApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return Hello.class; //return default page
	}

}
