package com.springbatch.ejemplo10;

import java.util.Map;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class MyDecider implements JobExecutionDecider {
    
	public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        
		JobParameters jobParameters = jobExecution.getJobInstance().getJobParameters();
		String action = jobParameters.getString("ACTION_TYPE");
		System.out.println("ACTION_TYPE : " + action);
		
		return new FlowExecutionStatus(action);
    }

}
