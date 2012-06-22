package au.com.uptick.gwt.maven.sample.test.spring;

import org.springframework.stereotype.Component;

@Component("CC")
public class CompC implements IComp{

	public void holaMundo() {
		System.out.println("HOLA C C");
		
	}

}
