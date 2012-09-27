package spring.ejemplos.diez.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * http://www.mkyong.com/spring/spring-resource-loader-with-getresource-example/
 * http://www.inmensia.com/articulos/spring/applicationcontext_recursos.html
 * 
 * @author Damian Ciocca
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/diez/resources/SpringIoC.xml");
		
		Resource resource = context.getResource("classpath:spring/ejemplos/diez/resources/ejemplo.txt");
		
		try {
			InputStream is = resource.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String line;
			while( (line = br.readLine()) != null ){
				System.out.println(line);
			}
			
			br.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}


