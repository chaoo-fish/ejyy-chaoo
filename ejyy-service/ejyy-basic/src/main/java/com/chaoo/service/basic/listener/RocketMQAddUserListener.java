package com.chaoo.service.basic.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费监听器
 */
@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "rocket-consumer-group", topic = "PetUpdate")
public class RocketMQAddUserListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String id) {
        // 当监听到有用户添加时就执行如下代码
        log.info("RocketMQ消息队列消费宠物更新,宠物id: "+id);
    }
}