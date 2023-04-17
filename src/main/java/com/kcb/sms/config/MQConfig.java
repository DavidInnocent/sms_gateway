package com.kcb.sms.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

  public static final String QUEUE = "sms_queue";
  public static final String TOPIC_EXCHANGE = "sms_exchange";
  public static final String ROUTING_KEY = "sms_routingKey";

  @Bean
  public Queue getQueue() {
    return new Queue(QUEUE);
  }

  @Bean
  public TopicExchange getTopicExchange() {
    return new TopicExchange(TOPIC_EXCHANGE);
  }

  @Bean
  public Binding createBinding(Queue queue, TopicExchange topicExchange) {
    return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY);
  }

  @Bean
  public MessageConverter messageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public RabbitTemplate asyncAmqpTemplate(ConnectionFactory connectionFactory){
    RabbitTemplate template=new RabbitTemplate(connectionFactory);
    template.setMessageConverter(messageConverter());
    return template;
  }
}

