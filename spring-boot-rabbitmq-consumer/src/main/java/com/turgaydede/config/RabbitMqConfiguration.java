package com.turgaydede.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfiguration {
   @Autowired
   private ApplicationConfiguration configuration;

    @Bean
    public Queue queue() {
        return new Queue(configuration.getQueueName());
    }

    @Bean
    public TopicExchange directExchange(){
        return new TopicExchange(configuration.getExchangeName());
    }

    @Bean
    public Binding binding(final Queue queue, final TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with(configuration.getRoutingName());
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
