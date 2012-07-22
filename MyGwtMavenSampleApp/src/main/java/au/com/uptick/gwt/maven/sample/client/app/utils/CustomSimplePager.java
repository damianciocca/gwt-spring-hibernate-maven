package au.com.uptick.gwt.maven.sample.client.app.utils;

import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.view.client.Range;

/**
 * Esto soluciona un BUG que al paginar nos repite un valor en la ultima pagina!
 * 
 * @author Damian Ciocca
 */
public class CustomSimplePager extends SimplePager{
	
	// TODO esto lo tenemos q pasar como parametro!
	private int pageSize = 3;
	
    public CustomSimplePager() {
		super();
	}

	public CustomSimplePager(TextLocation location, Resources resources,
			boolean showFastForwardButton, int fastForwardRows,
			boolean showLastPageButton) {
		super(location, resources, showFastForwardButton, fastForwardRows,
				showLastPageButton);
	}

	public CustomSimplePager(TextLocation location) {
		super(location);
	}

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


}
