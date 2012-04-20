package au.com.uptick.gwt.maven.sample.client.app.utils;

import java.util.ArrayList;

/**
 * Modelo generico para usar con componentes de UI
 * @author dciocca
 *
 * @param <M>
 */
public class SimpleModel<M> {

    M model;

    // Conjunto de listener registrados que escucharan ante el cambio en un modelo 
    ArrayList<SimpleModelListener<M>> listeners = new ArrayList<SimpleModelListener<M>>();

    public SimpleModel() {
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
    	
        M old = this.model;
        this.model = model;
        notifyListener(model, old);
    }

    protected void notifyListener(M newModel, M oldModel) {
    	
        SimpleModelEvent<M> simpleModelEvent = new SimpleModelEvent<M>(oldModel, newModel);
        for (SimpleModelListener<M> modelListener : listeners) {
            modelListener.onChange(simpleModelEvent);
        }
    }

    public void addListener(SimpleModelListener<M> listener) {
    	
        listeners.add(listener);
    }
}
