package com.mrxu.cloud.user.kafka.consumer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;


/**
 * @author ifocusing-xuzhiwei
 * @since 2018/5/8
 */
@Component
public class ApplicationEventListener implements ApplicationListener{
    private static Logger LOG = Logger.getLogger(ApplicationEventListener.class);

    @Autowired
    ManagerConsumer managerConsumer;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ApplicationReadyEvent){
            //应用启动完成
            LOG.info("------------------应用启动完成，启动管理员消费者进行消息记录监听-------------------");
            managerConsumer.createManagerConsumer();
        } else if(event instanceof ContextStoppedEvent){
            //应用停止
        } else if(event instanceof ContextClosedEvent){
            //应用关闭
        }
    }
}
