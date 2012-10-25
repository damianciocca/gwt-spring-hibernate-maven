package com.jms.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class JmsMessageListener implements MessageListener { 

	/**
	 * Implementation of <code>MessageListener</code>.
	 */
	public void onMessage(Message message) {
		try {   

			if (message instanceof TextMessage) {
				TextMessage tm = (TextMessage)message;
				String msg = tm.getText();
				System.out.println("Processed message: " + msg);
			}

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
