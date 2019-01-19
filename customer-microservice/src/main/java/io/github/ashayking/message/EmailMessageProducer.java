package io.github.ashayking.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Slf4j
@Component
public class EmailMessageProducer {

	@Autowired
	private EmailMessageProducerConfiguration taskProducerConfiguration;

	public void sendNewTask(EmailMessage email) {
		log.info("Sending message from task producer!!");
		byte[] data = email.getEmailId().getBytes();
		log.info("TASK PRODUCER BYTE DATA " + data);
		taskProducerConfiguration.rabbitTemplate().convertAndSend(taskProducerConfiguration.tasksQueue, data);
		log.info("Successfully sent message from task producer!!");
	}

}