package spring.ejemplos.nueve.eventos.customevent;

import org.springframework.context.ApplicationListener;

public class SaludarListener implements ApplicationListener<SaludarEvent>{

	public void onApplicationEvent(SaludarEvent s) {
		
		System.out.println("SaludarListener => " + s.getClass());
		System.out.println("SaludarListener => " + s.getMotivo());
	}

}
