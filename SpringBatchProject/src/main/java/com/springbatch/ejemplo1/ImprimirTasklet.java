package com.springbatch.ejemplo1;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * This is because the Spring Batch 2.x tasklet interface has changed, 
 * it now takes a StepContribution object and ChunkConext as parameters to it's 
 * execute function, and it's return type is a RepeatStatus.
 * 
 * @author dciocca
 *
 */
public class ImprimirTasklet implements Tasklet {

	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {

		System.out.print(mensaje);
		return RepeatStatus.FINISHED;
	}
}