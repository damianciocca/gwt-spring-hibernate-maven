package au.com.uptick.gwt.maven.sample.client.app.utils.test.spring;

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
	ICompB compB;
	
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

	public ICompB getCompB() {
		return compB;
	}

	public void setCompB(ICompB compB) {
		this.compB = compB;
	}

	public CompB getComponenete() {
		return componenete;
	}

	public void setComponenete(CompB componenete) {
		this.componenete = componenete;
	} 

}
