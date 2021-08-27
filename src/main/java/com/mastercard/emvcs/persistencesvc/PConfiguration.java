package com.mastercard.emvcs.persistencesvc;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;

public class PConfiguration {

    /* s must be an even-length string. */
    @Bean
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

//    static final String topicExchangeName = "emvcs-exchange";
//    static final String requestQueueName = "emvcs_request_queue";
//    static final String responseQueueName = "emvcs_response_queue";
//    static final String routingKey = "emvcs_routing_key";
//    static final String directExchangeName = "emvcs_direct_exchange";
//
//    @Bean
//    Queue emvcsRequestQueue() {
//        return new Queue(requestQueueName, false);
//    }
//
//    @Bean
//    Queue emvcsResponseQueue() {
//        return new Queue(responseQueueName, false);
//    }
//
//
//    @Bean
//    public DirectExchange directExchange() {
//        return new DirectExchange(directExchangeName);
//    }
//
//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange(topicExchangeName);
//    }
//
//    @Bean
//    Binding binding(Queue queue, TopicExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
//    }
//
//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//                                             MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(responseQueueName);
//        container.setMessageListener(listenerAdapter);
//        return container;
//    }
//
//    @RabbitListener(queues = responseQueueName)
//    public void listen(String in) {
//        System.out.println("Message read from " + responseQueueName + ": " + in);
//    }
//
//    @Bean
//    MessageListenerAdapter listenerAdapter(Receiver receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }
//
//
//    @Bean
//    public MessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
//        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//        return rabbitTemplate;
//    }
}
