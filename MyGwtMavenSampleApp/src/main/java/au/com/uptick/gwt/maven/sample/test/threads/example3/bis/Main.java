package au.com.uptick.gwt.maven.sample.test.threads.example3.bis;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Elemento elemento= new Elemento();
		TP tp = new TP(elemento);
		TC tc = new TC(elemento);
		
		tp.start();
		tc.start();
	}

}
