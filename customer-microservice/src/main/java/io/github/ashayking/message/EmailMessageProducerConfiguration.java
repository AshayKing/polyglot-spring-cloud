package io.github.ashayking.message;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Configuration
public class EmailMessageProducerConfiguration {

	protected final String tasksQueue = "email-queue";

	@Autowired
	private ConnectionFactory connectionFactory;

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setRoutingKey(tasksQueue);
		template.setDefaultReceiveQueue(tasksQueue);
		return template;
	}

	@Bean
	public Queue tasksQueue() {
		return QueueBuilder.nonDurable(tasksQueue).build();
	}

}