package com.paperless.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "";
    public static final String MESSAGE_IN_QUEUE = "Echo_In";
    public static final String MESSAGE_OUT_QUEUE = "Echo_Out";

    @Value("${rabbitmq.endpoint}")
    private String endpoint;

    @Value("${rabbitmq.username}")
    private String username;

    @Value("${rabbitmq.password}")
    private String password;

    @Bean
    public Queue echoInQueue() {return new Queue(MESSAGE_IN_QUEUE);}
    @Bean
    public Queue echoOutQueue() {return new Queue(MESSAGE_OUT_QUEUE);}

    @Bean
    public ConnectionFactory rabbitMQConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(endpoint);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitMQConnectionFactory());
        rabbitTemplate.setDefaultReceiveQueue(MESSAGE_IN_QUEUE);
        return rabbitTemplate;
    }

}

