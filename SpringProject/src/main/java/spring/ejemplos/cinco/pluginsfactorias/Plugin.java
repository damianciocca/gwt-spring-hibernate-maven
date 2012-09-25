package spring.ejemplos.cinco.pluginsfactorias;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Ofrece un método que se llama antes de instanciar cualquier bean, y que recibe como 
 * parámetro la configuración de beans de Spring. Importante fijarse en que recibe 
 * la "configuración" de beans, no las instancias creadas a partir de dicha configuración.
 *  
 * No hace falta obtener ninguna instancia del bean mediante código, Spring automáticamente detecta 
 * que el bean implementa la interface, y lo añade a su lista de plugins a llamar.
 *  
 * @author dciocca
 */
public class Plugin implements BeanFactoryPostProcessor{

	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		System.out.println("postProcessBeanFactory...");
		
	}

}
