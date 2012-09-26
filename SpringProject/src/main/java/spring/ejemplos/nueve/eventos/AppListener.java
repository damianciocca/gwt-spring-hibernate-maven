package spring.ejemplos.nueve.eventos;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class AppListener implements ApplicationListener<ApplicationEvent>{

	public void onApplicationEvent(ApplicationEvent s) {
		
		System.out.println("AppListener => " + s.getClass());
	}

}
