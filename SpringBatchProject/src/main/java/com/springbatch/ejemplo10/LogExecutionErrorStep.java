package com.springbatch.ejemplo10;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class LogExecutionErrorStep implements Tasklet{

	private StringBuffer someObject;

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		

		System.out.println("do something......: " + someObject);
		return RepeatStatus.FINISHED;
	}

}
