package com.mkyong;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

// Wicket:
// Existen dos formas de levantar modales:
// 	1. modales con webPage
// 	2. modales con paneles
// http://www.wicket-library.com/wicket-examples/ajax/modal-window?6

// http://www.mkyong.com/wicket/wicket-hello-world-example-with-maven-tutorial/
// http://javaeenotes.blogspot.com.ar/2011/05/creating-modal-window-page-with-apache.html

// Integracion con spring:
// http://www.mkyong.com/wicket/wicket-spring-integration-example/

// Form:
// http://www.mkyong.com/wicket/wicket-propertymodel-example/

public class MyApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return Hello.class; //return default page
	}
	
	// Esto es necesario para integrar spring con wicket
	@Override
	protected void init() {
 
		super.init();
		addComponentInstantiationListener(new SpringComponentInjector(this));
 
	}

}
