package com.mkyong;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Este panel lo estamos reutilizando de dos lugares distintos...
 * @author dciocca
 *
 */
public class Ejemplo2Panel extends Panel {

	public Ejemplo2Panel(String id) {
		super(id);
		add(new Label("message", "Esto es un segundo ejemplo de panel interno.."));
	}

}
