package au.com.uptick.gwt.maven.sample.server.common;

import java.util.List;

public class QueryList<T> {

	List<T> list;
	int count;
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
