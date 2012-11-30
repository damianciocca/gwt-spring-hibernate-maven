/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.springbatch.ejemplo8;

import java.util.List;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;

/**
 * 
 * @author dciocca
 *
 */
public class ConsolaItemWriter implements ItemWriter<Contact> {
	
	StringBuffer sb = new StringBuffer();
	private StepExecution stepExecution;

	/**
	 * Este metodo sera invocado varias veces a medida q va leyendo el XML de acuerdo al valor que coloquemos
	 * en el commit-interval del tasklet
	 * 
	 */
    public void write (List<? extends Contact> items) {
    	
    	System.out.println("Write...");
		for (Contact item : items) {
			System.out.println("write() - " + item.toString());
			sb.append(item.toString()).append(" **** ");
		}
		
		System.out.println("++++++++++++++++++++++++");
		System.out.println("StringBuffer: " + sb.toString());
		System.out.println("++++++++++++++++++++++++");
		
		// Guardamos en el contexto (stepexecution) el objeto que queremos pasar al proximo step
		ExecutionContext stepContext = this.stepExecution.getExecutionContext();
        stepContext.put("xml", sb);
	}
    
    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
    	
    	System.out.println("@BeforeStep....saveStepExecution....");
        this.stepExecution = stepExecution;
    }
}
