package com.barry.kafkaconsumer.consumers.errors;


import java.util.List;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;

public class EventErrorHandler extends DefaultErrorHandler{

    @Override
    public void handleBatch(Exception thrownException, ConsumerRecords<?, ?> data, Consumer<?, ?> consumer,
            MessageListenerContainer container, Runnable invokeListener) {
        System.out.println("Handle BATCH");
        super.handleBatch(thrownException, data, consumer, container, invokeListener);
    }

    @Override
    public <K, V> ConsumerRecords<K, V> handleBatchAndReturnRemaining(Exception thrownException,
            ConsumerRecords<?, ?> data, Consumer<?, ?> consumer, MessageListenerContainer container,
            Runnable invokeListener) {
        System.out.println("Handle BATCH and RETURN");
        return super.handleBatchAndReturnRemaining(thrownException, data, consumer, container, invokeListener);
    }

    @Override
    public boolean handleOne(Exception arg0, ConsumerRecord<?, ?> arg1, Consumer<?, ?> arg2,
            MessageListenerContainer arg3) {
        System.out.println("Handle ONE 1111111111");
        return super.handleOne(arg0, arg1, arg2, arg3);
    }

    @Override
    public void handleOtherException(Exception thrownException, Consumer<?, ?> consumer,
            MessageListenerContainer container, boolean batchListener) {
        System.out.println("Handle Other");
        super.handleOtherException(thrownException, consumer, container, batchListener);
    }

    @Override
    public void handleRemaining(Exception thrownException, List<ConsumerRecord<?, ?>> records, Consumer<?, ?> consumer,
            MessageListenerContainer container) {
        System.out.println("Handle Remaining");
        super.handleRemaining(thrownException, records, consumer, container);
    }

    @Override
    protected void doHandle(Exception thrownException, ConsumerRecords<?, ?> data, Consumer<?, ?> consumer,
            MessageListenerContainer container, Runnable invokeListener) {
        System.out.println("do Handle... do do do");
        super.doHandle(thrownException, data, consumer, container, invokeListener);
    }

 

}