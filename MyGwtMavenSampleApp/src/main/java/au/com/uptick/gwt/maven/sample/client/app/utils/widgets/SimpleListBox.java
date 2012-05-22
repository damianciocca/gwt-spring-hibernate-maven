package au.com.uptick.gwt.maven.sample.client.app.utils.widgets;

import java.util.ArrayList;
import java.util.Collection;

import au.com.uptick.gwt.maven.sample.client.app.utils.HasSelectedValue;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.ListBox;

/**
 * Custom ListBox que maneja implementa la interface HasSelectedValue ideal para
 * utilizar bajo el patron MVP
 * 
 * @author dciocca
 * 
 * @param <T>
 */
public class SimpleListBox<T> extends ListBox implements HasSelectedValue<T> {

	public interface OptionFormatter<T> {

		abstract String getLabel(T option);

		abstract String getValue(T option);
	}

	private boolean valueChangeHandlerInitialized;
	private T[] options;
	private OptionFormatter<T> formatter;

	/**
	 * 
	 * @param values
	 * @param formatter
	 */
	public SimpleListBox(Collection<T> values, OptionFormatter<T> formatter, boolean allowNull) {

		setValues(values, allowNull);
		setFormatter(formatter);
	}	
	
	/**
	 * 
	 * @param values
	 * @param formatter
	 */
	public SimpleListBox(OptionFormatter<T> formatter, boolean allowNull) {

		this(new ArrayList<T>(), formatter, allowNull);
	}

	public void setFormatter(OptionFormatter<T> formatter) {
		this.formatter = formatter;
	}

	public T getValue() {

		return this.getSelectedValue();
	}

	public void setValue(T value) {

		this.setValue(value, false);

	}

	public void setValue(T value, boolean fireEvents) {

		T oldValue = getValue();
		this.setSelectedValue(value);
		if (fireEvents) {
			ValueChangeEvent.fireIfNotEqual(this, oldValue, value);
		}

	}

	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<T> handler) {

		// Initialization code
		if (!valueChangeHandlerInitialized) {
			valueChangeHandlerInitialized = true;
			super.addChangeHandler(new ChangeHandler() {
				public void onChange(ChangeEvent event) {
					ValueChangeEvent.fire(SimpleListBox.this, getValue());
				}
			});
		}
		return addHandler(handler, ValueChangeEvent.getType());

	}

	public void setValues(Collection<T> values, boolean allowNull) {

		// Remove prior options
		if (options != null) {
			int numItems = this.getItemCount();
			int firstOption = numItems - options.length;
			for (int i = firstOption; i < numItems; i++)
				this.removeItem(firstOption);
		}
		options = (T[]) values.toArray();
		// Permite null
		if (allowNull) {
			// verificamos si ya existe NULL como opcion, para no agregarlo dos veces.
			boolean nullFound = false;
			for (int i = 0; i < this.getItemCount(); i++) {
				if ("".equals(this.getItemText(i))){
					// ok, null ya esta como opcion.
					nullFound = true;
					break;
				}
			}
			if(!nullFound){
				this.addItem("", null);
			}
		}
		// Se agregan los items al combo
		for (T option : options) {
			String optionLabel = formatter.getLabel(option);
			String optionValue = formatter.getValue(option);
			this.addItem(optionLabel, optionValue);
		}
	}

	public void setSelectedValue(T value) {

		if (value == null) {
			return;
		}

		for (int i = 0; i < this.getItemCount(); i++) {
			String thisLabel = this.getItemText(i);
			if (formatter.getLabel(value).equals(thisLabel)) {
				this.setSelectedIndex(i);
				return;
			}
		}

		throw new IllegalArgumentException("No index found for value "
				+ value.toString());
	}

	public T getSelectedValue() {

		if (getSelectedIndex() >= 0) {
			String value = getValue(getSelectedIndex());
			for (T option : options) {
				if (formatter.getValue(option).equals(value))
					return option;
			}
		}

		return null;
	}

}
