package au.com.uptick.gwt.maven.sample.client.auth.view;

import java.util.List;
import java.util.Set;

import au.com.uptick.gwt.maven.sample.client.app.utils.CustomSimplePager;
import au.com.uptick.gwt.maven.sample.client.app.utils.handlers.HasSelectedValue;
import au.com.uptick.gwt.maven.sample.client.app.utils.widgets.SimpleListBox;
import au.com.uptick.gwt.maven.sample.client.app.utils.widgets.SimpleListBox.OptionFormatter;
import au.com.uptick.gwt.maven.sample.client.auth.presenter.RoleListPresenter;
import au.com.uptick.gwt.maven.sample.shared.auth.dto.RoleDto;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.Header;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;

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
	MultiSelectionModel<RoleDto> selectionModel;

	public RoleListView() {

		DecoratorPanel mainPanel = new DecoratorPanel(); 
		VerticalPanel tablePanel = new VerticalPanel();
		HorizontalPanel buttonPanel = new HorizontalPanel();

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
		selectionModel = new MultiSelectionModel<RoleDto>();
		table.setSelectionModel(selectionModel, DefaultSelectionEventManager.<RoleDto> createCheckboxManager());

		// Create a column definitions
		initColumns(selectionModel);
		
		// Create a Pager to control the table.
		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		
		// Esto soluciona un BUG que al paginar nos repite un valor en la ultima pagina!
		CustomSimplePager pager = new CustomSimplePager(TextLocation.CENTER, pagerResources, false, 0,true);

        pager.setRangeLimited(true);
				
		pager.setDisplay(table);

		VerticalPanel vp = new VerticalPanel();
		vp.add(table);
		vp.add(pager);
		return vp;
	}

	@SuppressWarnings("unchecked")
	private void initColumns(final MultiSelectionModel<RoleDto> selectionModel) {
				
		Column<RoleDto, Boolean> checkColumn = new Column<RoleDto, Boolean>(new CheckboxCell(true, false)) {
			  @Override
			  public Boolean getValue(RoleDto object) {
				  // Get the value from the selection model.
				  return selectionModel.isSelected(object);
			  }
		};
		
		checkColumn.setFieldUpdater(new FieldUpdater<RoleDto, Boolean>() { 
             public void update(int index, RoleDto object, Boolean value){
            	 // Called when the user clicks on a checkbox. 
                 selectionModel.setSelected(object, value); 
             } 
		 });
		
		Header selectAllHeader = new Header(new CheckboxCell()) { 
              @Override 
              public Boolean getValue(){
            	  return selectionModel.getSelectedSet().size() == table.getRowCount(); 
              } 
		}; 
		
		selectAllHeader.setUpdater(new ValueUpdater<Boolean>() { 
             public void update(Boolean value) 
             { 
                     List<RoleDto> displayedItems = table.getVisibleItems(); 
                     for (RoleDto contact : displayedItems) 
                     { 
                             selectionModel.setSelected(contact, value); 
                     } 
             } 
		 }); 
				
		table.addColumn(checkColumn, selectAllHeader);
				
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
	
	public Set<RoleDto> getSelectedRows() {
		return selectionModel.getSelectedSet();
	}

}
