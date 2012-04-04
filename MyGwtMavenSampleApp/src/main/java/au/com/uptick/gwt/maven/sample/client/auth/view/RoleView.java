package au.com.uptick.gwt.maven.sample.client.auth.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import au.com.uptick.gwt.maven.sample.client.auth.presenter.RoleListPresenter;
import au.com.uptick.gwt.maven.sample.shared.auth.model.Role;

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
public class RoleView extends Composite implements RoleListPresenter.Display {

	private final Button addButton = new Button("Add");
	private final Button deleteButton = new Button("Remove");;
	private final Button editButton = new Button("Edit");;
	private FlexTable rolesTable = new FlexTable();
	private final FlexTable contentTable = new FlexTable();;

	public RoleView() {

		DecoratorPanel mainPanel = new DecoratorPanel();
		mainPanel.setWidth("100%");

		// Create the menu
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setBorderWidth(0);
		hPanel.setSpacing(0);
		hPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
		hPanel.add(addButton);
		hPanel.add(deleteButton);
		hPanel.add(editButton);

		// Create the roles list
		contentTable.setWidth("100%");
		rolesTable = new FlexTable();
		rolesTable.setCellSpacing(0);
		rolesTable.setCellPadding(0);
		rolesTable.setWidth("100%");
		rolesTable.getColumnFormatter().setWidth(0, "15px");
		
		contentTable.setWidget(0, 0, rolesTable);
		contentTable.setWidget(1, 0, hPanel);

		mainPanel.add(contentTable);
		initWidget(mainPanel);

	}

	public HasClickHandlers getAddButton() {
		return addButton;
	}

	public HasClickHandlers getDeleteButton() {
		return deleteButton;
	}

	public HasClickHandlers getEditButton() {
		return editButton;
	}
	
	public HasClickHandlers getList() {
		return rolesTable;
	}
	
	public List<Integer> getSelectedRows() {
		List<Integer> selectedRows = new ArrayList<Integer>();
		for (int i = 0; i < rolesTable.getRowCount(); ++i) {
			CheckBox checkBox = (CheckBox) rolesTable.getWidget(i, 0);
			if (checkBox.getValue()) {
				selectedRows.add(i);
			}
		}
		return selectedRows;
	}

	public void setData(List<String> data) {
		
		System.out.println("RoleView => setData [INICIO]");
		rolesTable.removeAllRows();
	    for (int i = 0; i < data.size(); ++i) {
	      rolesTable.setWidget(i, 0, new CheckBox());
	      rolesTable.setText(i, 1, data.get(i));
	    }
	    System.out.println("RoleView => setData [FIN]");
	}
	
}
