package spring.ejemplos.diez.resources.ejemplo1;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * Este bean como no tiene acceso al context de spring existe una forma de que Spring le inyecte
 * el recurso a este bean para lo cual tendra que implementar la interface ResourceLoaderAware
 * 
 * @author Damian Ciocca
 */
public class ResourceBean implements ResourceLoaderAware{

	// Spring Inyecta esta propiedad automaticamente!
	ResourceLoader resourceLoader;
	
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public Resource getResource(String path) {
		return resourceLoader.getResource(path);
	}
	

}
