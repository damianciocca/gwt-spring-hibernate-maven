package spring.ejemplos.nueve.eventos;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class StartContextListener implements ApplicationListener<ContextStartedEvent>{

	public void onApplicationEvent(ContextStartedEvent s) {
		
		System.out.println("StartContextListener => " + s.getClass());
	}

}
