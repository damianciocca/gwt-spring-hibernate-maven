package spring.ejemplos.cinco.pluginsfactorias;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Otra de las interfaces que ofrece acceso a los puntos de extensión de Spring es 
 * BeanPostProcessor, que tiene dos métodos. El primer método que se llama cuando se 
 * crea una instancia de un bean, justo antes de llamar a sus métodos de inicialización. 
 * Y el segundo método que se llama justo después de llamar a dichos 
 * métodos de inicialización.
 * 
 * @author dciocca
 */
public class Plugin2 implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {

		System.out.println("postProcessBeforeInitialization...");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {

		System.out.println("postProcessAfterInitialization...");
		return bean;
	}

}
