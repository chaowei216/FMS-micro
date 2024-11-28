package com.weiz.notificationservice.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageDTO {

    String from;
    String to;
    String toName;
    String subject;
    String content;
}
