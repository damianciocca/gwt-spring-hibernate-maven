package spring.ejemplos.nueve.eventos.customevent;

import org.springframework.context.ApplicationEvent;

public class SaludarEvent extends ApplicationEvent{

	private String motivo;

	public SaludarEvent(Object source, String motivo) {
		super(source);
		this.motivo = motivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
}
