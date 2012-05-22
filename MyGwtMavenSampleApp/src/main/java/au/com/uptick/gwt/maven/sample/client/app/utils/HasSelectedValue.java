package au.com.uptick.gwt.maven.sample.client.app.utils;

import java.util.Collection;

import com.google.gwt.user.client.ui.HasValue;

/**
 * MVP-friendly interface for use with any widget that can be populated
 * with a Collection of items, one of which may be selected
 * 
 * Por ejemplo, el componente ListBox solo implementa las interfaces 
 * HasChangeHandlers, HasName y no HasValue como si lo tiene implementado
 * el componente TextBox
 * 
 * According to the Model-View-Presenter approach to GWT development, presenters 
 * should not know about specific Widgets in views, but rather call methods on 
 * interfaces like HasValue and HasClickHandlers. In practice, this works well 
 * with relatively simple widgets like TextBox whose behavior can be described 
 * to the presenter in terms of a single interface such as HasValue. However, 
 * GWT doesn’t yet provide suitable interfaces for all Widgets. One such example 
 * is the ListBox, which implements only HasChangeHandlers and HasName. Wouldn’t 
 * it be nice if there were a HasValue equivalent for ListBox that would let you get 
 * and set the selected value as well as populate the list?
 * 
 * http://turbomanage.wordpress.com/2010/04/01/selectonelistbox-for-use-with-gwtmvp/
 *  
 * @author dciocca
 */
public interface HasSelectedValue<T> extends HasValue<T>{

	void setValues(Collection<T> values, boolean allowNull);
 
    void setSelectedValue(T selected);
     
    T getSelectedValue();
    
}
