package au.com.uptick.gwt.maven.sample.client.auth.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import au.com.uptick.gwt.maven.sample.client.app.utils.SimpleListModel;
import au.com.uptick.gwt.maven.sample.client.app.utils.SimpleModelEvent;
import au.com.uptick.gwt.maven.sample.client.app.utils.SimpleModelListener;
import au.com.uptick.gwt.maven.sample.client.auth.presenter.RoleListPresenter;
import au.com.uptick.gwt.maven.sample.shared.auth.model.dto.RoleDto;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

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
public class RoleListView extends Composite implements RoleListPresenter.Display {

	private final Button addButton = new Button("Add");
	private final Button deleteButton = new Button("Remove");;
	private final Button editButton = new Button("Edit");;
	private FlexTable table = new FlexTable();
	CheckBox roleCheckBox = new CheckBox();
	SimpleListModel<RoleDto> tableModel;

	public RoleListView() {

		DecoratorPanel mainPanel = new DecoratorPanel(); 
		VerticalPanel tablePanel = new VerticalPanel();
		HorizontalPanel buttonPanel = new HorizontalPanel();

		// Agregamos el header a la tabla.
		table.setText(0, 0, "ID");
		table.setText(0, 1, "Nombre");
		table.setText(0, 2, "Descripcion");
		table.setText(0, 3, "Seleccion");
		table.getCellFormatter().setWidth(0, 0, "50px");
		table.getCellFormatter().setWidth(0, 1, "135px");
		table.getCellFormatter().setWidth(0, 2, "350px");
		table.getCellFormatter().setWidth(0, 3, "50px");
		table.getCellFormatter().setAlignment(0, 0,
				HasHorizontalAlignment.ALIGN_CENTER,
				HasVerticalAlignment.ALIGN_MIDDLE);
		table.getCellFormatter().setAlignment(0, 1,
				HasHorizontalAlignment.ALIGN_CENTER,
				HasVerticalAlignment.ALIGN_MIDDLE);
		table.getCellFormatter().setAlignment(0, 2,
				HasHorizontalAlignment.ALIGN_CENTER,
				HasVerticalAlignment.ALIGN_MIDDLE);
		table.getCellFormatter().setAlignment(0, 3,
				HasHorizontalAlignment.ALIGN_CENTER,
				HasVerticalAlignment.ALIGN_MIDDLE);
		table.setCellPadding(2);
		table.setCellSpacing(0);
		table.setBorderWidth(1);

		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(editButton);
		
		tablePanel.add(table);
		tablePanel.add(buttonPanel);
		mainPanel.add(tablePanel);
		
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
		return table;
	}

	public List<RoleDto> getSelectedRows() {

		ArrayList<RoleDto> result = new ArrayList<RoleDto>();
		int rowCount = table.getRowCount();
		for (int i = 1; i < rowCount; i++) {
			Widget widget = table.getWidget(i, 3);
			if (widget instanceof CheckBox && ((CheckBox) widget).getValue()) {
				result.add(tableModel.getModel().get(i - 1));
			}
		}
		return result;
	}

	public void setData(List<RoleDto> data) {

		System.out.println("RoleView => setData [INICIO]");
		tableModel = bindTableModel(table, data);
		System.out.println("RoleView => setData [FIN]");
	}

	private SimpleListModel<RoleDto> bindTableModel(final FlexTable table,
											   		final List<RoleDto> roles) {

		SimpleListModel<RoleDto> simpleModel = new SimpleListModel<RoleDto>();

		// Listener que escucha ante un cambio del modelo de la tabla de roles
		simpleModel.addListener(new SimpleModelListener<ArrayList<RoleDto>>() {

			public void onChange(SimpleModelEvent<ArrayList<RoleDto>> roleModelEvent) {

				ArrayList<RoleDto> roleList = roleModelEvent.getNewValue();

				// removemos todos los rows menos el header...
				final int count = table.getRowCount() - 1;
				for (int i = 0; i < count; i++) {
					table.removeRow(1);
				}

				int row = 1;
				for (RoleDto role : roles) {

					table.setText(row, 0, String.valueOf(role.getId()));
					table.setText(row, 1, role.getName());
					table.setText(row, 2, role.getDescription());
					CheckBox checkBox = new CheckBox();
					table.setWidget(row, 3, checkBox);
					row++;
				}
			}
		});
		
		// seteando el nuevo modelo, se invara a los listeners que tenga asociado 
		// dicho tablemodel (simpleModel)
		simpleModel.setModel((ArrayList<RoleDto>) roles);

		return simpleModel;
	}
}
