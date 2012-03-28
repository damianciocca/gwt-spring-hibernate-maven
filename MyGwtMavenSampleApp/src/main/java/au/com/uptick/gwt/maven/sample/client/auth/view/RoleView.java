package au.com.uptick.gwt.maven.sample.client.auth.view;

import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import au.com.uptick.gwt.maven.sample.client.auth.presenter.RolePresenter;

/**
 * A view contains all of the UI components that make up our application. This
 * includes any tables, labels, buttons, textboxes, etc...
 * 
 * Views are responsible for the layout of the UI components and have no notion
 * of the model.
 * 
 * That is to say a view doesn't know that it is displaying a Role, it simply
 * knows that it has, for example, 3 labels, 3 textboxes, and 2 buttons that are
 * organized in a vertical fashion.
 * 
 * @author dciocca
 */
public class RoleView extends Composite implements RolePresenter.Display {

	private final Button addButton = new Button("Add");
	private final Button deleteButton = new Button("Remove");;
	private FlexTable rolesTable = new FlexTable();
	private final FlexTable contentTable = new FlexTable();;

	public RoleView() {

		DecoratorPanel mainPanel = new DecoratorPanel();
		initWidget(mainPanel);
		mainPanel.setWidth("100%");
		mainPanel.setWidth("18em");

		contentTable.setWidth("100%");
		contentTable.getCellFormatter().addStyleName(0, 0,
				"roles-ListContainer");
		contentTable.getCellFormatter().setWidth(0, 0, "100%");
		contentTable.getFlexCellFormatter().setVerticalAlignment(0, 0,
				DockPanel.ALIGN_TOP);

		// Create the menu
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setBorderWidth(0);
		hPanel.setSpacing(0);
		hPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
		hPanel.add(addButton);
		hPanel.add(deleteButton);
		contentTable.getCellFormatter().addStyleName(0, 0, "roles-ListMenu");
		contentTable.setWidget(0, 0, hPanel);

		// Create the roles list
		rolesTable = new FlexTable();
		rolesTable.setCellSpacing(0);
		rolesTable.setCellPadding(0);
		rolesTable.setWidth("100%");
		rolesTable.addStyleName("contacts-ListContents");
		rolesTable.getColumnFormatter().setWidth(0, "15px");
		contentTable.setWidget(1, 0, rolesTable);

		mainPanel.add(contentTable);

	}

	public HasClickHandlers getAddButton() {
		return addButton;
	}

	public HasClickHandlers getDeleteButton() {
		return deleteButton;
	}

	public HasClickHandlers getList() {
		return rolesTable;
	}

	public void setData(List<String> data) {
		rolesTable.removeAllRows();
	    for (int i = 0; i < data.size(); ++i) {
	      rolesTable.setWidget(i, 0, new CheckBox());
	      rolesTable.setText(i, 1, data.get(i));
	    }
	}
}
