package com.springbatch.ejemplo10;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Launcher {

	private JobLauncher jobLauncher;

	private Job job;

	public void launch() {

		JobParameters jobParameters = new JobParametersBuilder().addLong("time",
				System.currentTimeMillis()).toJobParameters();

		try {
			JobExecution execution = jobLauncher.run(job, jobParameters);
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			System.out.println("Unable to execute job");
			e.printStackTrace();
		}

	}

	public static void main(String arg[]){

		//AppContext
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:appContext-spring-batch10.xml"); 
		final Job job = (Job) context.getBean("xmlReadAndGeneratorStep");
		final SimpleJobLauncher launcher = (SimpleJobLauncher) context.getBean("jobLauncher"); 

		//Set XML Inputs
		CustomStaxEventItemReader customStaxEventItemReader = (CustomStaxEventItemReader) context.getBean(CustomStaxEventItemReader.class); 
		customStaxEventItemReader.setResource(new FileSystemResource("/logs/SIM10000_GX98_16K.sec.xml"));
		ProcessorItem processorItem = (ProcessorItem) context.getBean(ProcessorItem.class);
		processorItem.setFilePath("/logs/SIM10000_GX98_16K.card.xml");

	}

	public JobLauncher getJobLauncher() {
		return jobLauncher;
	}

	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}
