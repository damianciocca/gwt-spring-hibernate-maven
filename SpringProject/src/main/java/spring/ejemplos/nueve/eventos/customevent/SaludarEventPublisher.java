package spring.ejemplos.nueve.eventos.customevent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class SaludarEventPublisher implements ApplicationEventPublisherAware{

	// Spring automaticamente inyecta el valor en esta propiedad
	// Spring detecta automáticamente cuando un bean implementa la interface, e inyecta 
	// directamente la dependencia, de forma que pueda utilizarla para publicar eventos.
	private ApplicationEventPublisher publisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
	
	public void publish(String motivo){
		SaludarEvent event = new SaludarEvent(this, motivo);
		this.publisher.publishEvent(event);
	}

}
