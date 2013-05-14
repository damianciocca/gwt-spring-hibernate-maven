package com.springbatch.ejemplo10;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class StartInvocationStep implements Tasklet {

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {

		System.out.println("PASO POR ACA...");
		return RepeatStatus.FINISHED;
	}

}
