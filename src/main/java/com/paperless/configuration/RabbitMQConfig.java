package com.paperless.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {

    public static final String MESSAGE_IN_QUEUE = "Echo_In";
    public static final String MESSAGE_OUT_QUEUE = "Echo_Out";

    @Bean
    public Queue echoInQueue() {return new Queue(MESSAGE_IN_QUEUE);}
    @Bean
    public Queue echoOutQueue() {return new Queue(MESSAGE_OUT_QUEUE);}

    @Bean
    public ConnectionFactory rabbitMQConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("http://localhost:9093");
        connectionFactory.setUsername("rabbitmq_user");
        connectionFactory.setPassword("rabbitmq_password");
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitMQConnectionFactory());
        rabbitTemplate.setDefaultReceiveQueue(MESSAGE_IN_QUEUE);
        return rabbitTemplate;
    }

}

