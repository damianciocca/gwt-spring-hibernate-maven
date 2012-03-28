package au.com.uptick.gwt.maven.sample.client.app;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * A presenter contains all of the logic for our application, including
 * history management, view transition and data sync via RPCs back to the
 * server. As a general rule, for every view you'll want a presenter to drive
 * the view and handle events that are sourced from the UI widgets within the
 * view.
 * 
 * @author dciocca
 * 
 */
public abstract interface Presenter {

	public abstract void go(final HasWidgets container);

}
