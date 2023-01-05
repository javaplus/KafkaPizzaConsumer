package com.barry.kafkaconsumer.consumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.stereotype.Service;

import com.barry.kafkaconsumer.consumers.errors.EventErrorHandler;
import com.barry.kafkaconsumer.entities.PizzaOrderEvent;


@Service
public class OrderConsumer {

    @KafkaListener(topics = "input-topic", groupId = "pizza-order-app")    
    public void receiveOrderMessage(ConsumerRecord<String, PizzaOrderEvent> orderMessage) throws Exception{
        System.out.println("Partition:" + orderMessage.partition());
        System.out.println("Offset:" + orderMessage.offset());
        PizzaOrderEvent event = orderMessage.value();
        System.out.println("Pizza Size:" + event.getSize());
        if("SUPER SMALL".equalsIgnoreCase(event.getSize())){
            throw new Exception("No stinking Super Small Pizzas allowed");
        }
        System.out.println("Order Message Value:" + event);
    }

    @Bean
    public DefaultErrorHandler errorHandler(){
        System.out.println("Creating my error handler");
        DefaultErrorHandler errorHandler = new EventErrorHandler();
        return errorHandler;
    }
}