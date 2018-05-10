package com.mrxu.cloud.user.kafka.consumer;

import com.mrxu.cloud.user.comm.constants.UserConstants;
import com.mrxu.cloud.user.comm.uuid.IdWorkerService;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ifocusing-xuzhiwei
 * @since 2018/5/8
 */
@Component
public class ManagerConsumer {

    @Autowired
    IdWorkerService idWorkerService;

    @Autowired
    Map consumerConfigs;

    /**
     * 为每个服务器分配不同的clientID 这样才能保证每台服务器都能收到大屏推送的消息
     */
    private static String clientID = "";

    public void createManagerConsumer(){
        if(StringUtils.isEmpty(clientID)){
            clientID = idWorkerService.getNextId().toString();
        }
        consumerConfigs.put(ConsumerConfig.GROUP_ID_CONFIG, clientID);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(consumerConfigs);
        //加入监听
        consumer.subscribe(Arrays.asList(UserConstants.MANAGER_TOPIC));
        new ManagerConsumerThread(consumer).start();
    }

    class ManagerConsumerThread extends ConsumerThread{

        public ManagerConsumerThread(KafkaConsumer<String, String> consumer){
            this.consumer = consumer;
        }

        @Override
        public void run(){
            while (!closed.get()){
                ConsumerRecords<String, String> records = consumer.poll(9000);
                count ++;
                for(ConsumerRecord<String, String> record : records){
                    count = 0;
                    System.out.printf("offset = %d, value = %s", record.offset(), record.value());
                }
            }
        }
    }
}
