package au.com.uptick.gwt.maven.sample.client.app.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author dciocca
 *
 * @param <I>
 */
public class SimpleListModel<I> extends SimpleModel<ArrayList<I>> {

    public void addItem(I item, boolean atBeginning) {
    	
        ArrayList<I> result = new ArrayList<I>();
        if(atBeginning){
            result.add(item);
            result.addAll(getModel());
        }else{
            result.addAll(getModel());
            result.add(item);
        }
        setModel(result);
    }

    public void addItems(List<I> itemsToAdd) {
    	
        ArrayList<I> result = new ArrayList<I>();
        result.addAll(getModel());
        result.addAll(itemsToAdd);
        setModel(result);
    }

    public I removeItem(int index) {
    	
        ArrayList<I> result = new ArrayList<I>();
        result.addAll(getModel());
        I removed = result.remove(index);
        setModel(result);
        return removed;
    }

    public void removeItems() {
    	
        setModel(new ArrayList<I>());
    }

    public void removeItem(I e) {
    	
        ArrayList<I> newList = new ArrayList<I>();
        ArrayList<I> result = new ArrayList<I>();
        newList.addAll(getModel());
        for (I item : newList) {
            if (item.equals(e)) {
                // este es el que queremos remover, por ende, no lo meto en la lista resultado
            } else {
                result.add(item);
            }
        }
        setModel(result);
    }
}
