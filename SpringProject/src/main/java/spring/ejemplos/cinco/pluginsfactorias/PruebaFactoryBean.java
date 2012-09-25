package spring.ejemplos.cinco.pluginsfactorias;

import org.springframework.beans.factory.FactoryBean;

/**
 * La interface FactoryBean tiene tres métodos que hay que implementar: getObjectType para 
 * obtener el tipo del objeto que produce la fábrica, isSingleton para indicar si el 
 * objeto devuelto es un Singleton, y getObject para devolver los objetos creados por la fábrica.
 * 
 * @author dciocca
 */
public class PruebaFactoryBean implements FactoryBean<PruebaBean>{

	public PruebaBean getObject() throws Exception {
		return new PruebaBean();
	}

	public Class<?> getObjectType() {
		return PruebaBean.class;
	}

	public boolean isSingleton() {
		return false;
	}


}
