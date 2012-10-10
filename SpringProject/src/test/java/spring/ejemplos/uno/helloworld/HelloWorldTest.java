package spring.ejemplos.uno.helloworld;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"SpringHelloWorld-test.xml"})
public class HelloWorldTest {

	@Autowired
	private Spring3HelloWorld bean;

	@Before	
	public void setUp() throws Exception {

		System.out.println("before...");

	}
	
	@After
	public void tearDown() throws Exception {

		System.out.println("after...");

	}


	@Test
	public void testSayHello() throws Exception {

		String sayHello = bean.sayHello();
		assertNotNull(sayHello);

	}
	
	@Test
	public void testSayHello2() throws Exception {

		String sayHello = bean.sayHello();
		assertNotSame("", sayHello);

	}
	
	@Test
	public void testSayHello3() throws Exception {

		String sayHello = bean.sayHello();
		assertEquals("Hello Spring 3.0", sayHello);

	}

}
