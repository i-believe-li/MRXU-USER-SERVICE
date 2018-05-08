package com.mrxu.cloud.user.kafka.consumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author ifocusing-xuzhiwei
 * @since 2018/5/8
 */
class ConsumerThread extends Thread{
    KafkaConsumer<String, String> consumer;
    final AtomicBoolean closed = new AtomicBoolean(false);
    int count = 0;
    public void shutdown(){
        count = 0;
        closed.set(true);
    }
}
