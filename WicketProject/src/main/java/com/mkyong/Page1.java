package com.mkyong;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class Page1 extends WebPage {

	private static final long serialVersionUID = 1L;

	public Page1(final PageParameters parameters) {

		add(new Label("message", "Esta es la segunda pagina..."));
		add(new Ejemplo1Panel("panel1"));
		add(new Ejemplo2Panel("panel2"));

	}

}
