package au.com.uptick.gwt.maven.sample.test.integers;

public class ComparingIntegersTest {
	
	public static void main(String args[]){
		
		Integer count = 0;
		
		if (count == 0){
			System.out.println("Son iguales");
		}
		
		if (count.equals(0)) {
			System.out.println("Son iguales");
		}
		
		if (count.compareTo(0) == 0){
			System.out.println("Son iguales");
		}
	}

}
