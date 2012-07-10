package au.com.uptick.gwt.maven.sample.client.auth.view;

import java.util.List;

import au.com.uptick.gwt.maven.sample.client.app.utils.SimpleListModel;
import au.com.uptick.gwt.maven.sample.client.app.utils.handlers.HasSelectedValue;
import au.com.uptick.gwt.maven.sample.client.app.utils.widgets.SimpleListBox;
import au.com.uptick.gwt.maven.sample.client.app.utils.widgets.SimpleListBox.OptionFormatter;
import au.com.uptick.gwt.maven.sample.client.auth.presenter.RoleListPresenter;
import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

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
	private final Button searchButton = new Button("Buscar");
	private SimpleListBox<RoleDto> roleLbox;
	private final CellTable<RoleDto> table = new CellTable<RoleDto>();
	private final CheckBox roleCheckBox = new CheckBox();
	SimpleListModel<RoleDto> tableModel;

	public RoleListView() {

		DecoratorPanel mainPanel = new DecoratorPanel(); 
		VerticalPanel tablePanel = new VerticalPanel();
		HorizontalPanel buttonPanel = new HorizontalPanel();

		// Agregamos el header a la tabla.
		//		table.setText(0, 0, "ID");
		//		table.setText(0, 1, "Nombre");
		//		table.setText(0, 2, "Descripcion");
		//		table.setText(0, 3, "Seleccion");
		//		table.getCellFormatter().setWidth(0, 0, "50px");
		//		table.getCellFormatter().setWidth(0, 1, "135px");
		//		table.getCellFormatter().setWidth(0, 2, "350px");
		//		table.getCellFormatter().setWidth(0, 3, "50px");
		//		table.getCellFormatter().setAlignment(0, 0,
		//				HasHorizontalAlignment.ALIGN_CENTER,
		//				HasVerticalAlignment.ALIGN_MIDDLE);
		//		table.getCellFormatter().setAlignment(0, 1,
		//				HasHorizontalAlignment.ALIGN_CENTER,
		//				HasVerticalAlignment.ALIGN_MIDDLE);
		//		table.getCellFormatter().setAlignment(0, 2,
		//				HasHorizontalAlignment.ALIGN_CENTER,
		//				HasVerticalAlignment.ALIGN_MIDDLE);
		//		table.getCellFormatter().setAlignment(0, 3,
		//				HasHorizontalAlignment.ALIGN_CENTER,
		//				HasVerticalAlignment.ALIGN_MIDDLE);
		//		table.setCellPadding(2);
		//		table.setCellSpacing(0);
		//		table.setBorderWidth(1);

		// Creamos el filtro de roles (combo)
		HorizontalPanel hp = buildRoleFilterCombo();

		// Creamos la tabla
		VerticalPanel vp = buildTable();

		// Creamos el panel de botones
		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(editButton);
		buttonPanel.add(searchButton);
		buttonPanel.setSpacing(10);

		// Asociamos todos los paneles creados previamente (filtros, tabla y botones)
		tablePanel.add(hp);
		tablePanel.add(vp);
		tablePanel.setSpacing(10);
		tablePanel.add(buttonPanel);

		mainPanel.add(tablePanel);

		initWidget(mainPanel);
	}

	public HorizontalPanel buildRoleFilterCombo() {
		HorizontalPanel hp = new HorizontalPanel();
		Label roleLbl = new Label();
		roleLbl.setText("Roles");
		roleLbox = new SimpleListBox<RoleDto>(new OptionFormatter<RoleDto>() {

			public String getLabel(RoleDto option) {
				return option.getName();
			}

			public String getValue(RoleDto option) {
				return option.getId().toString();
			}
		}, true);
		hp.add(roleLbl);
		hp.setSpacing(10);
		hp.add(roleLbox);
		return hp;
	}

	public VerticalPanel buildTable() {
		table.setPageSize(3);

		TextColumn<RoleDto> idColumn = new TextColumn<RoleDto>() {
			@Override
			public String getValue(RoleDto object) {
				return object.getId().toString();
			}
		};
		table.addColumn(idColumn, "ID");

		TextColumn<RoleDto> nameColumn = new TextColumn<RoleDto>() {
			@Override
			public String getValue(RoleDto object) {
				return object.getName();
			}
		};
		table.addColumn(nameColumn, "Nombre");

		TextColumn<RoleDto> descColumn = new TextColumn<RoleDto>() {
			@Override
			public String getValue(RoleDto object) {
				return object.getDescription();
			}
		};
		table.addColumn(descColumn, "Descripcion");

		final SingleSelectionModel<RoleDto> selectionModel = new SingleSelectionModel<RoleDto>();
		table.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
				RoleDto roleSelected = selectionModel.getSelectedObject();
				if (roleSelected != null) {
					Window.alert("You selected: " + roleSelected);
				}
			}
		});

		// Create a Pager to control the table.
		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		SimplePager pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0,
                true) {
            private int pageSize = 3;

            @Override
            public int getPageSize() {
                return pageSize;
            }

            @Override
            public void previousPage() {
                if (getDisplay() != null) {
                    Range range = getDisplay().getVisibleRange();
                    setPageStart(range.getStart() - getPageSize());
                }
            }

            @Override
            public void setPageStart(int index) {
                if (getDisplay() != null) {
                    Range range = getDisplay().getVisibleRange();
                    int displayPageSize = getPageSize();
                    if (isRangeLimited() && getDisplay().isRowCountExact()) {
                        displayPageSize = Math.min(getPageSize(), getDisplay()
                                .getRowCount() - index);
                    }
                    index = Math.max(0, index);
                    if (index != range.getStart()) {
                        getDisplay().setVisibleRange(index, displayPageSize);
                    }
                }
            }

            @Override
            public void nextPage() {
               
            	if (getDisplay() != null) {
                    Range range = getDisplay().getVisibleRange();
                    setPageStart(range.getStart() + getPageSize());
                }
            }

			@Override
			public boolean hasNextPage() {
				
				if(this.getPage()<(this.getPageCount()-1)) { 
					return true; 
				} 
				return false; 
			}
            
			
            
        };

        pager.setRangeLimited(true);
		
		
		pager.setDisplay(table);

		VerticalPanel vp = new VerticalPanel();
		vp.add(table);
		vp.add(pager);
		return vp;
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

	public HasClickHandlers getSearchButton() {
		return searchButton;
	}

	public HasSelectedValue<RoleDto> getRoleFilter() {
		return roleLbox;
	}

	public HasData<RoleDto> getCellTable() {	
		return table;
	}

	//	public HasClickHandlers getList() {
	//		return table;
	//	}


	public List<RoleDto> getListSelectedRows() {

		//		ArrayList<RoleDto> result = new ArrayList<RoleDto>();
		//		int rowCount = table.getRowCount();
		//		for (int i = 1; i < rowCount; i++) {
		//			Widget widget = table.getWidget(i, 3);
		//			if (widget instanceof CheckBox && ((CheckBox) widget).getValue()) {
		//				result.add(tableModel.getModel().get(i - 1));
		//			}
		//		}
		//		return result;
		return null;
	}

	public void setListRows(List<RoleDto> data) {

		//		System.out.println("RoleView => setData [INICIO]");
		//		tableModel = bindTableModel(table, data);
		//		System.out.println("RoleView => setData [FIN]");
	}

	//TODO esto tendriamos que mejorarlo ya que deberiamos crear un componente que haga todo esto internamente...	
	private SimpleListModel<RoleDto> bindTableModel(final FlexTable table,
			final List<RoleDto> roles) {

		//		SimpleListModel<RoleDto> simpleModel = new SimpleListModel<RoleDto>();
		//
		//		// Listener que escucha ante un cambio del modelo de la tabla de roles
		//		simpleModel.addListener(new SimpleModelListener<ArrayList<RoleDto>>() {
		//
		//			public void onChange(SimpleModelEvent<ArrayList<RoleDto>> roleModelEvent) {
		//
		//				ArrayList<RoleDto> roleList = roleModelEvent.getNewValue();
		//
		//				// removemos todos los rows menos el header...
		//				final int count = table.getRowCount() - 1;
		//				for (int i = 0; i < count; i++) {
		//					table.removeRow(1);
		//				}
		//
		//				int row = 1;
		//				for (RoleDto role : roles) {
		//
		//					table.setText(row, 0, String.valueOf(role.getId()));
		//					table.setText(row, 1, role.getName());
		//					table.setText(row, 2, role.getDescription());
		//					CheckBox checkBox = new CheckBox();
		//					table.setWidget(row, 3, checkBox);
		//					row++;
		//				}
		//			}
		//		});
		//		
		//		// seteando el nuevo modelo, se invara a los listeners que tenga asociado 
		//		// dicho tablemodel (simpleModel)
		//		simpleModel.setModel((ArrayList<RoleDto>) roles);
		//
		//		return simpleModel;
		return null;
	}

}
