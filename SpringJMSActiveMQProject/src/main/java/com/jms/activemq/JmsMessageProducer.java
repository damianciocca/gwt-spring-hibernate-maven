package com.jms.activemq;


import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * http://briansjavablog.blogspot.com.ar/2012/09/spring-jms-tutorial-with-activemq.html
 * http://www.springbyexample.org/examples/simple-spring-jms.html
 * 
 * The Spring configuration shows a context:component-scan that picks up the JMS producer and listener. 
 * Following this the Spring custom namespace for Apache's ActiveMQ is used to create an embedded JMS broker. 
 * A queue is configured for 'org.apache.activemq.spring.Test.spring.embedded'. Then a JMS connection factory 
 * is made for the JmsTemplate to use. The template will be used by the producer to send messages.
 * 
 * @author dciocca
 *
 */
@Component
public class JmsMessageProducer {

	private static final Logger logger = LoggerFactory.getLogger(JmsMessageProducer.class);

	protected static final String MESSAGE_COUNT = "messageCount";

	@Autowired
	private JmsTemplate template = null;
	private int messageCount = 1000;

	/**
	 * Generates JMS messages
	 */
	@PostConstruct
	public void generateMessages() throws JMSException {
		
		for (int i = 0; i < messageCount; i++) {
			
			final int index = i;
			final String text = "Message number is " + i + ".";

			template.send(new MessageCreator() {
				
				public Message createMessage(Session session) throws JMSException {
					
					TextMessage message = session.createTextMessage(text);
					message.setIntProperty(MESSAGE_COUNT, index);

					System.out.println("Sending message: " + text);

					return message;
				}
			});
		}
	}

}