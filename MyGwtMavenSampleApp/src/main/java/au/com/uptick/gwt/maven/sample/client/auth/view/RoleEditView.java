package au.com.uptick.gwt.maven.sample.client.auth.view;

import au.com.uptick.gwt.maven.sample.client.auth.presenter.RoleEditPresenter;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RoleEditView extends Composite implements RoleEditPresenter.Display {

	private final TextBox nameTextBox;
	private final TextBox descriptionTextBox;
	private final Button saveButton;
	private final Button cancelButton;

	public RoleEditView() {

		DecoratorPanel mainPanel = new DecoratorPanel();
		mainPanel.setWidth("18em");

		VerticalPanel formPanel = new VerticalPanel();
		formPanel.setWidth("100%");

		HorizontalPanel buttonPanel = new HorizontalPanel();

		// Campos del formulario
		nameTextBox = new TextBox();
		nameTextBox.setFocus(true);
		descriptionTextBox = new TextBox();

		// Botones del formulario
		saveButton = new Button("Save");
		cancelButton = new Button("Cancel");

		// Formulario con los campos
		FlexTable formTable = new FlexTable();
		formTable.setCellSpacing(0);
		formTable.setWidth("100%");
		formTable.setWidget(0, 0, new Label("Nombre"));
		formTable.setWidget(0, 1, nameTextBox);
		formTable.setWidget(1, 0, new Label("Descripcion"));
		formTable.setWidget(1, 1, descriptionTextBox);

		// Panel con los botones del formulario
		buttonPanel.add(saveButton);
		buttonPanel.add(cancelButton);

		formPanel.add(formTable);
		formPanel.add(buttonPanel);

		mainPanel.add(formPanel);

		initWidget(mainPanel);
	}

	public HasClickHandlers getSaveButton() {
		return saveButton;
	}

	public HasClickHandlers getCancelButton() {
		return cancelButton;
	}

	public HasValue<String> getNameTxt() {
		return nameTextBox;
	}

	public HasValue<String> getDescriptionTxt() {
		return descriptionTextBox;
	}

}
