package au.com.uptick.gwt.maven.sample.client.auth.view;

import au.com.uptick.gwt.maven.sample.client.auth.presenter.MainPresenter;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainView extends Composite implements MainPresenter.Display {
	
	private final Label titleLbl;
	private final Button listRoleBtn;

	public MainView() {

		DecoratorPanel mainPanel = new DecoratorPanel();
		mainPanel.setWidth("18em");

		VerticalPanel vPanel = new VerticalPanel();
		vPanel.setWidth("100%");

		titleLbl = new Label();
		listRoleBtn = new Button("Roles");

		vPanel.add(titleLbl);
		vPanel.add(listRoleBtn);

		mainPanel.add(vPanel);

		initWidget(mainPanel);
	}

	public HasClickHandlers getRoleButton() {
		
		return listRoleBtn;
	}

}
