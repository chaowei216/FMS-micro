package com.weiz.accountservice.service.impl;

import com.weiz.accountservice.model.MessageDTO;
import com.weiz.accountservice.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendNotification(MessageDTO messageDTO) {
        log.error("Notification is time out");
    }
}
