package com.weiz.notificationservice.service;

import com.weiz.notificationservice.model.MessageDTO;

public interface EmailService {

    void sendEmail(MessageDTO messageDTO);
}
