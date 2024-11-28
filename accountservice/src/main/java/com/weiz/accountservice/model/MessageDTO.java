package com.weiz.accountservice.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageDTO {

    String from;
    String to;
    String toName;
    String subject;
    String content;
}
