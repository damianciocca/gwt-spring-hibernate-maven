package au.com.uptick.gwt.maven.sample.client.app.utils.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Component10 {
	
	@Autowired
	private Component20 c1;
	@Autowired
	private Component20 c2;
	
	public Component20 getC1() {
		return c1;
	}
	public void setC1(Component20 c1) {
		this.c1 = c1;
	}
	public Component20 getC2() {
		return c2;
	}
	public void setC2(Component20 c2) {
		this.c2 = c2;
	}
}
