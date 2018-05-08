package com.mrxu.cloud.user.kafka.consumer;

import org.apache.log4j.Logger;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;


/**
 * @author ifocusing-xuzhiwei
 * @since 2018/5/8
 */
public class ApplicationEventListener implements ApplicationListener{
    private static Logger LOG = Logger.getLogger(ApplicationEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ApplicationReadyEvent){
            //应用启动完成
            LOG.info("------------------应用启动完成，启动管理员消息记录监听-------------------");

        } else if(event instanceof ContextStoppedEvent){
            //应用停止
        } else if(event instanceof ContextClosedEvent){
            //应用关闭
        }
    }
}
