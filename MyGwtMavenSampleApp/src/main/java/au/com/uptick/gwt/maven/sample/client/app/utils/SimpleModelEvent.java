package au.com.uptick.gwt.maven.sample.client.app.utils;


/**
 * 
 * @author dciocca
 *
 * @param <M>
 */
public class SimpleModelEvent<M> {

    M oldValue;
    M newValue;

    public SimpleModelEvent(M oldValue, M newValue) {
    	
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public M getOldValue() {
    	
        return oldValue;
    }

    public M getNewValue() {
    	
        return newValue;
    }
}