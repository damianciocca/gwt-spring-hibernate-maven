package com.springbatch.ejemplo10;

import java.util.Map;

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

	/*
	 * NECESITAMOS SABER COMO ESTE PASO PUEDE DARSE CUENTA Q EL XML GENERADO ESTA VACIO Y ASI EVITAR
	 * LLAMAR AL LPM
	 * 
	 *  todo: TAL VEZ UNA OPCION SERIA SABER QUE LA CANTIDAD DE CHUNK PROCESADOS FUE 0.....
	 * 
	 */
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {

		System.out.println(arg0);
		System.out.println(arg1);
		Map<String, Object> jobParameters = arg1.getStepContext().getJobParameters();
		
		System.out.println("INPUT 1: " + jobParameters.get("INPUT1"));
		System.out.println("INPUT 2: " + jobParameters.get("INPUT2"));
		System.out.print(mensaje);
		return RepeatStatus.FINISHED;
	}
}
