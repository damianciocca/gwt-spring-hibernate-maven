package com.mkyong;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Este panel lo estamos reutilizando de dos lugares distintos...
 * @author dciocca
 *
 */
public class Ejemplo1Panel extends Panel {

	public Ejemplo1Panel(String id) {
		super(id);
		add(new Label("message", "Esto es un primer ejemplo de panel interno.."));
	}

}
