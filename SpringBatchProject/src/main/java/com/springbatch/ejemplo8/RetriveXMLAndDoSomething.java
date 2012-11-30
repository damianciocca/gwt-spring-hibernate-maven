package com.springbatch.ejemplo8;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * Chunk-oriented processing is not the only way to process in a Step. What if a Step must consist as a simple stored 
 * procedure call? You could implement the call as an ItemReader and return null after the procedure finishes, 
 * but it is a bit unnatural since there would need to be a no-op ItemWriter. Spring Batch provides the 
 * TaskletStep for this scenario. The Tasklet is a simple interface that has one method, execute, 
 * which will be a called repeatedly by the TaskletStep until it either returns RepeatStatus.FINISHED 
 * or throws an exception to signal a failure. Each call to the Tasklet is wrapped in a transaction. 
 * Tasklet implementors might call a stored procedure, a script, or a simple SQL update statement. 
 * To create a TaskletStep, the 'ref' attribute of the <tasklet/> element should reference a 
 * bean defining a Tasklet object; no <chunk/> element should be used within the <tasklet/>:


 * @author dciocca
 *
 */
public class RetriveXMLAndDoSomething implements Tasklet{

	private StringBuffer someObject;

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		JobExecution jobExecution = chunkContext.getStepContext().getStepExecution().getJobExecution();
		//JobExecution jobExecution = stepExecution.getJobExecution();
		ExecutionContext jobContext = jobExecution.getExecutionContext();
		this.someObject = (StringBuffer) jobContext.get("xml");
		System.out.println(this.someObject != null ? this.someObject.toString() : " NO LLEGO NADA ");
		
		System.out.println("do something......: " + someObject);
		return RepeatStatus.FINISHED;
	}

}
