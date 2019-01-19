package io.github.ashayking.message;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Configuration
public class RabbitMqConfiguration {
	
	@Autowired
	protected ConnectionFactory connectionFactory;

//	@Bean
//	public ConnectionFactory connectionFactory() {
//		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
//		// connectionFactory.setUsername("user");
//		// connectionFactory.setPassword("password");
//		return connectionFactory;
//	}

//	@Bean
//	public AmqpAdmin amqpAdmin() {
//		return new RabbitAdmin(connectionFactory);
//	}

//	@Bean
//	public MessageConverter jsonMessageConverter() {
//		return new Jackson2JsonMessageConverter();
//	}
}