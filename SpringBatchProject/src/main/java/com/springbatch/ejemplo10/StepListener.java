package com.springbatch.ejemplo10;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class StepListener implements StepExecutionListener {

	/**
	 * The StepExecutionListener inspects the readCount property of the StepExecution during the }
	 * 'afterStep' phase to determine if no items were read. If that is the case, an exit code 
	 * of FAILED is returned, indicating that the Step should fail.
	 */
	@Override
	public ExitStatus afterStep(StepExecution arg0) {
		
		System.out.println("***********************");
		System.out.println("afterStep");
		System.out.println("***********************");
		
		System.out.println("ITEMS READ: " + arg0.getReadCount());
		System.out.println("ITEMS WRITE: " + arg0.getWriteCount());
		
		if (arg0.getReadCount() == 0){
			return ExitStatus.FAILED;
		}
		
		return ExitStatus.COMPLETED;
	}

	@Override
	public void beforeStep(StepExecution arg0) {
		
		System.out.println("beforeStep");
		
	}


}
