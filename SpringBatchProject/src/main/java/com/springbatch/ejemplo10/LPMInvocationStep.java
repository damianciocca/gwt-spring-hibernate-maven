package com.springbatch.ejemplo10;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class LPMInvocationStep implements Tasklet {

	private String mensaje;

	public String getMensaje() {
		
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		
		this.mensaje = mensaje;
	}

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {

		System.out.println(arg0);
		System.out.println(arg1);
		System.out.print(mensaje);
		return RepeatStatus.FINISHED;
	}
}
