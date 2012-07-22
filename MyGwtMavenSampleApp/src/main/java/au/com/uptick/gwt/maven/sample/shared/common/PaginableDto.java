package au.com.uptick.gwt.maven.sample.shared.common;

import java.io.Serializable;

public class PaginableDto implements Serializable{
	
	private int startIndex;
	private int endIndex;
	
	public PaginableDto() {
		super();
	}

	public PaginableDto(int startIndex, int endIndex) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
	

}
