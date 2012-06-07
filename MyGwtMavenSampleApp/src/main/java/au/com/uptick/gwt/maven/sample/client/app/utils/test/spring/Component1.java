package au.com.uptick.gwt.maven.sample.client.app.utils.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("C1")
public class Component1 {
	
	@Autowired
	@Qualifier("C2")
	Component2 component;

	public Component2 getComponent() {
		return component;
	}

	public void setComponent(Component2 component) {
		this.component = component;
	}
	
}
