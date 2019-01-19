package io.github.ashayking;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Configuration
public class RabbitMQConfig {

	private final static String queueName = "email-queue";

	@Bean
	Queue queue() {
		return QueueBuilder.nonDurable(queueName).build();
	}

	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange("email-exchange");
	}

	@Bean
	Binding queueBinding() {
		return BindingBuilder.bind(queue()).to(topicExchange()).with(queueName);
	}

	@Bean
	SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer messageListenerContainer = new SimpleMessageListenerContainer();
		messageListenerContainer.setConnectionFactory(connectionFactory);
		messageListenerContainer.setMessageListener(listenerAdapter);
		messageListenerContainer.setQueueNames(queueName);
		return messageListenerContainer;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(EmailMessageReciever emailMessageReciever) {
		return new MessageListenerAdapter(emailMessageReciever, "receiveMessage");
	}

}
