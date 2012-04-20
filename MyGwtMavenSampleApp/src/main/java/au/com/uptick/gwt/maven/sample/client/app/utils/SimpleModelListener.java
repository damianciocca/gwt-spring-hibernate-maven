package au.com.uptick.gwt.maven.sample.client.app.utils;

/**
 * 
 * @author dciocca
 *
 * @param <M>
 */
public interface SimpleModelListener<M> {
	
    void onChange(SimpleModelEvent<M> t);
}
