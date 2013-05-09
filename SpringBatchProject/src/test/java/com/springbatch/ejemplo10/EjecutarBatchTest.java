package com.springbatch.ejemplo10;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:appContext-spring-batch10.xml"
})
public class EjecutarBatchTest {

	@Autowired
	private SimpleJobLauncher launcher;

	@Autowired
	private CustomStaxEventItemReader customStaxEventItemReader;
	
	@Autowired
	private ProcessorItem processorItem; 

	@Autowired
	@Qualifier("xmlReadAndGeneratorStep")
	private Job job;

	@Test
	public void iniciarJob() throws Exception {


		JobParametersBuilder builder = new JobParametersBuilder();
		builder.addDate("Ejecucion", new Date());
		builder.addString("jobName", "Imprimir contactos por consola");
		JobParameters parameters = builder.toJobParameters();

		// Tmb se puede setear via XML
		customStaxEventItemReader.setResource(new FileSystemResource("/logs/SIM10000_GX98_16K.sec.xml"));
		processorItem.setFilePath("/logs/SIM10000_GX98_16K.card.xml");
		
		launcher.run(job, parameters);


		System.out.println("FIN");
	}

}
