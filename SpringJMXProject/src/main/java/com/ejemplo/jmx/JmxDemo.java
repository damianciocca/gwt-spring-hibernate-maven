package com.ejemplo.jmx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;

// http://www.mularien.com/blog/2007/11/09/5-minute-guide-to-spring-and-jmx/
// http://blog.synyx.de/2012/05/how-to-monitor-and-manage-your-java-application-with-jmx/

@ManagedResource(objectName = "mbeans:name=myJmxDemoBean", 
				 description = "My managed Bean.")
public class JmxDemo {
	
	private String level;

	@ManagedAttribute
	public String getLevel() {
		return level;
	}

	@ManagedAttribute
	public void setLevel(String level) {
		this.level = level;
	}
	
	@ManagedOperation(description = "Setting the level value.")
	@ManagedOperationParameters({
	    @ManagedOperationParameter(name = "level", description = "The level may be DEBUG or INFO.")
	})
	public void changeLevel(String level){
		
		System.out.println("Level before: " + getLevel());
		System.out.println("levelstring " + level);
		setLevel(level);
		System.out.println("Level changed: " + getLevel());
	}
	
}
