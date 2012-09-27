package spring.ejemplos.diez.resources.ejemplo1;

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
 * Bean resource loader (ResourceLoaderAware)
 * 
 * Since bean does not have the application context access, how can a bean access a resources? 
 * The workaround is implement the ResourceLoaderAware interface and create setter method for 
 * ResourceLoader object. Spring will DI the resource loader into your bean.
 * 
 */
public class MainTest {
	
	public static void main(String arg[]){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/ejemplos/diez/resources/ejemplo1/SpringIoC.xml");
		
		ResourceBean bean = (ResourceBean) context.getBean("resourceBean");
		
		Resource resource = bean.getResource("classpath:spring/ejemplos/diez/resources/ejemplo1/ejemplo.txt");
		
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


