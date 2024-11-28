package com.weiz.accountservice.service;

import com.weiz.accountservice.model.MessageDTO;
import com.weiz.accountservice.service.impl.NotificationServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "notification-service",
        fallback = NotificationServiceImpl.class
)
@Primary
public interface NotificationService {

    @PostMapping("/send-notification")
    void sendNotification(@RequestBody MessageDTO messageDTO);
}
