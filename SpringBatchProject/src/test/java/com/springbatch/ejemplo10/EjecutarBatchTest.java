package com.springbatch.ejemplo10;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:appContext-spring-batch10.xml"})
public class EjecutarBatchTest {

	@Autowired
	private SimpleJobLauncher launcher;

	@Autowired
	private CustomStaxEventItemReader customStaxEventItemReader;

	@Autowired
	private ProcessorItemUpdateSubscriber processorItem; 

	@Autowired
	@Qualifier("xmlReadAndGeneratorStep")
	private Job job;
	
	/**
	 * Nota: Para lanzar el JOB como un thread aparte, no podemos lanzarlo como un TEST...
	 * Es por esto q se opto por hacer un main y que se lance de esta manera.... Igula dejo comentado la parte del TEST
	 * @param arg
	 * @throws InterruptedException 
	 */
	public static void main(String arg[]) throws InterruptedException{
		
		//AppContext
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:appContext-spring-batch10.xml"); 
		final Job job = (Job) context.getBean("xmlReadAndGeneratorStep");
		final SimpleJobLauncher launcher = (SimpleJobLauncher) context.getBean("jobLauncher"); 
		
		//Set XML Inputs
		CustomStaxEventItemReader customStaxEventItemReader = (CustomStaxEventItemReader) context.getBean(CustomStaxEventItemReader.class); 
		customStaxEventItemReader.setResource(new FileSystemResource("/logs/SIM10000_GX98_16K.sec.xml"));
		
		ProcessorItemUpdateSubscriber processorItem1 = (ProcessorItemUpdateSubscriber) context.getBean(ProcessorItemUpdateSubscriber.class);
		processorItem1.setFilePath("/logs/SIM10000_GX98_16K.card.xml");
		
		ProcessorItemChangeMsisdn processorItem2 = (ProcessorItemChangeMsisdn) context.getBean(ProcessorItemChangeMsisdn.class);
		processorItem2.setFilePath("/logs/SIM10000_GX98_16K.card.xml");
		
		
		JobParametersBuilder builder = new JobParametersBuilder();
		builder.addDate("Ejecucion", new Date());
		builder.addString("jobName", "Imprimir contactos por consola");
		builder.addString("INPUT1", "/logs/SIM10000_GX98_16K.sec.xml");
		builder.addString("INPUT2", "/logs/SIM10000_GX98_16K.card.xml");
		
		// Con este parametro vamos a decidir si vamos por un tipo de itemProcessor o por otro...
		// Antes de lanzar el JOB tenemos que saber que tipo de action se va a tomar.. 
		builder.addString("ACTION_TYPE", "UPDATE_SUBSCRIBER");
//		builder.addString("ACTION_TYPE", "CHANGE_MSISDN");
		
		final JobParameters parameters = builder.toJobParameters();
		
		Thread t1 = new Thread(new Runnable() {

			// http://stackoverflow.com/questions/9114162/spring-batch-starting-a-job-from-within-a-spring-mvc-contorller-with-a-new-thre	
			@Override
			public void run() {
				
				try {
					//Run Job
					launcher.run(job, parameters);
				} catch (JobExecutionAlreadyRunningException e) {
					System.out.println("JobExecutionAlreadyRunningException");
					e.printStackTrace();
				} catch (JobRestartException e) {
					System.out.println("JobRestartException");
					e.printStackTrace();
				} catch (JobInstanceAlreadyCompleteException e) {
					System.out.println("JobInstanceAlreadyCompleteException");
					e.printStackTrace();
				} catch (JobParametersInvalidException e) {
					System.out.println("JobParametersInvalidException");
					e.printStackTrace();
				}
				
			}
		});
		
		t1.start();
		
//		Thread.sleep(1000);
		
		// En este caso, como vamos a querer lanzar nuevamente el JOB (es la misma instancia), sin haber terminado el anterior nos va a arrojar el siguiente error:
		// JobExecutionAlreadyRunningException
		// Esto esta piola en el caso que se intente desde una app web invocar dos veces seguidas al mismo JOB.
		
//		Thread t2 = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				
//				try {
//					//Run Job
//					launcher.run(job, parameters);
//				} catch (JobExecutionAlreadyRunningException e) {
//					System.out.println("JobExecutionAlreadyRunningException");
//					e.printStackTrace();
//				} catch (JobRestartException e) {
//					System.out.println("JobRestartException");
//					e.printStackTrace();
//				} catch (JobInstanceAlreadyCompleteException e) {
//					System.out.println("JobInstanceAlreadyCompleteException");
//					e.printStackTrace();
//				} catch (JobParametersInvalidException e) {
//					System.out.println("JobParametersInvalidException");
//					e.printStackTrace();
//				}
//				
//			}
//		});
//		
//		t2.start();
		
		System.out.println("FIN");
	}

//	@Test
//	public void iniciarJob() {
//
//		JobParametersBuilder builder = new JobParametersBuilder();
//		builder.addDate("Ejecucion", new Date());
//		builder.addString("jobName", "Imprimir contactos por consola");
//		final JobParameters parameters = builder.toJobParameters();
//
//		// Tmb se puede setear via XML
//		customStaxEventItemReader.setResource(new FileSystemResource("/logs/SIM10000_GX98_16K.sec.xml"));
//		processorItem.setFilePath("/logs/SIM10000_GX98_16K.card.xml");
//
//		Thread t = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//
//				try {
//					launcher.run(job, parameters);
//				} catch (JobExecutionAlreadyRunningException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (JobRestartException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (JobInstanceAlreadyCompleteException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (JobParametersInvalidException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//			}
//		});	
//
//		t.start();
//
//		System.out.println("FIN");
//
//	}
	
}
