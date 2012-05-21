package au.com.uptick.gwt.maven.sample.client.app.utils.widgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import au.com.uptick.gwt.maven.sample.client.app.utils.EntityToStringFormatter;
import au.com.uptick.gwt.maven.sample.client.app.utils.SimpleListModel;
import au.com.uptick.gwt.maven.sample.client.app.utils.SimpleModelEvent;
import au.com.uptick.gwt.maven.sample.client.app.utils.SimpleModelListener;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.ListBox;

/**
 * 
 * @author dciocca
 *
 * @param <T>
 * @deprecated Usar SimpleListBox
 * @see SimpleListBox
 */
public class ListBoxController<T> {

	private ListBox listBox;
	private SimpleListModel<T> simpleModel;
	private EntityToStringFormatter<T> formatter;
	private HashMap<T, EntityToStringFormatter> customFormatters;
	private boolean allowNull = true;

	public ListBoxController(ListBox listBox, List<T> entities, EntityToStringFormatter<T> defaultFormatter, T selectedEntity) {

		this.listBox = listBox;
		// Inicializo el modelo con una lista vacia.
		simpleModel = new SimpleListModel<T>();
		simpleModel.setModel(new ArrayList<T>());

		simpleModel.addListener(new SimpleModelListener<ArrayList<T>>() {
			public void onChange(SimpleModelEvent<ArrayList<T>> t) {
				modelChanged(t.getNewValue(), t.getOldValue());
			}
		});
		
		this.formatter = defaultFormatter;
		customFormatters = new HashMap<T, EntityToStringFormatter>();
		setEntities(entities);
		setSelectedEntity(selectedEntity);
	}

	public ListBoxController(ListBox listBox, List<T> entities, EntityToStringFormatter<T> defaultFormatter, T selectedEntity, boolean allowNull) {

		this(listBox, entities, defaultFormatter, selectedEntity);
		this.allowNull = allowNull;
	}

	public ListBox getUI() {

		return listBox;
	}

	public T getSelectedEntity() {

		int selectedIndex = listBox.getSelectedIndex();
		if (selectedIndex != -1) {
			return simpleModel.getModel().get(selectedIndex);
		} else {
			return null;
		}
	}

	public void setSelectedEntity(T entity) {

		int i = simpleModel.getModel().indexOf(entity);
		// -1 es que no esta en el modelo.
		if (i != -1) {
			// veo si cambio la seleccion.
			if(i!=listBox.getSelectedIndex()){
				listBox.setSelectedIndex(i);
				fireComboChangedProgramaticallyEvent();
			}
		} else {
			// la entity no esta en el modelo. no hacemos nada.
		}
	}

	public void setEntities(List<T> model) {

		ArrayList<T> result = new ArrayList<T>();
		if(allowNull){
			boolean nullFound = false;
			for (T t : model) {
				if (t == null) {
					// ok, null ya esta como opcion.
					nullFound = true;
					break;
				}
			}
			if(!nullFound){
				result.add(null);
			}
		}
		result.addAll(model);
		simpleModel.setModel(result);
	}

	public void addEntity(T entity, boolean atBeginning, EntityToStringFormatter<T> customFormatter) {

		customFormatters.put(entity, customFormatter);
		addEntity(entity, atBeginning);
	}

	public void addEntity(T entity, boolean atBeginning) {

		simpleModel.addItem(entity, atBeginning);
	}

	/*
    DO NOT remove or add any T to the returned list.
	 */
	public ArrayList<T> getEntities() {

		return simpleModel.getModel();
	}

	public ArrayList<T> getSelectedEntities() {

		ArrayList<T> result = new ArrayList<T>();
		for(int i = 0; i < listBox.getItemCount(); i++){
			if(listBox.isItemSelected(i)){
				result.add(simpleModel.getModel().get(i));
			}
		}
		return result;
	}

	public HandlerRegistration addComboChangeHandler(ChangeHandler handler) {

		return listBox.addChangeHandler(handler);
	}

	/**
	 * Este metodo refresca el combo con los nuevos valores. 
	 * A su vez trata de dejar el mismo item seleccionado que estaba antes.
	 *
	 * @param newEntities
	 * @param oldEntities
	 */
	private void modelChanged(ArrayList<T> newEntities, ArrayList<T> oldEntities) {

		int selectedIndex = listBox.getSelectedIndex();
		T oldSelectedEntity = selectedIndex != -1 ? oldEntities.get(selectedIndex) : null;
		int newSelectedIndex = newEntities.indexOf(oldSelectedEntity);

		listBox.clear();
		for (int i = 0; i < newEntities.size(); i++) {
			String label;
			T t = newEntities.get(i);
			if (customFormatters.get(t) == null) {
				label = formatter.format(t);
			} else {
				label = customFormatters.get(t).format(t);
			}
			listBox.addItem(label, String.valueOf(i));
		}
		if(newSelectedIndex != -1){
			listBox.setSelectedIndex(newSelectedIndex);
		}else{
			// efectivamente el combo cambio de seleccion, hay que llamar a los que dependen de mi para que
			// se refresquen.
			fireComboChangedProgramaticallyEvent();
		}
	}

	// notificamos a los listeners que los valores del combo han cambiado
	private void fireComboChangedProgramaticallyEvent() {

		DomEvent.fireNativeEvent(Document.get().createChangeEvent(), listBox);
	}



	//    public boolean setSelectedEntityUsing(EntityMatcher<T> evaluator) {
	//        ArrayList<T> model = simpleModel.getModel();
	//        for (T t : model) {
	//            if (evaluator.matches(t)) {
	//                setSelectedEntity(t);
	//                return true;
	//            }
	//        }
	//        return false;
	//    }



}

