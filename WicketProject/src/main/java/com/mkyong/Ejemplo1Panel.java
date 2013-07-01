package com.mkyong;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.mkyong.service.HelloServiceImpl;

/**
 * Este panel lo estamos reutilizando de dos lugares distintos...
 * @author dciocca
 *
 */
public class Ejemplo1Panel extends Panel {

	@SpringBean
	private HelloServiceImpl helloService;
	
	public Ejemplo1Panel(String id) {
		super(id);
		add(new Label("message", "Esto es un primer ejemplo de panel interno.. " + helloService.getHelloWorldMsg()));
	}

}
