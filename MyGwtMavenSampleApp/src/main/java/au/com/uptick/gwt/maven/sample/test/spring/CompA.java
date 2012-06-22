package au.com.uptick.gwt.maven.sample.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("CA")
public class CompA {

	/**
	 * Inyeccion por interface
	 */
	@Autowired
	@Qualifier("CB")
	IComp compB;
	
	/**
	 * Inyeccion por metodo
	 * @param componenete
	 */
	CompB componenete;
	
	@Autowired
	@Qualifier("CB")
	public void init(CompB componenete){
		this.componenete = componenete;		
	}

	public IComp getCompB() {
		return compB;
	}

	public void setCompB(IComp compB) {
		this.compB = compB;
	}

	public CompB getComponenete() {
		return componenete;
	}

	public void setComponenete(CompB componenete) {
		this.componenete = componenete;
	} 

}
