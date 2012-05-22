package au.com.uptick.gwt.maven.sample.client.app.utils.widgets;

import au.com.uptick.gwt.maven.sample.client.app.utils.handlers.HasCommandHandler;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuItem;

/**
 * Custom MenuItem que implementa la interface HasCommand ideal para
 * utilizar bajo el patron MVP
 * 
 * @author dciocca
 *
 */
public class SimpleMenuItem extends MenuItem implements HasCommandHandler{

	public SimpleMenuItem(String text) {
		
		super(text, (Command)null);
	}

	public void addCommandHandler(Command command) {
		
		super.setCommand(command);
	}
}
