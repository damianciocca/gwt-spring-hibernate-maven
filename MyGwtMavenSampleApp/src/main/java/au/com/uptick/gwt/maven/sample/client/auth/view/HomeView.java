package au.com.uptick.gwt.maven.sample.client.auth.view;

import au.com.uptick.gwt.maven.sample.client.auth.presenter.HomePresenter;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

public class HomeView extends Composite implements HomePresenter.Display{

	public HomeView() {
		
		super();
		SimplePanel sp = new SimplePanel();
		initWidget(sp);
	}
	
	

}
