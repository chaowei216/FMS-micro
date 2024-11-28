package com.weiz.statisticservice.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatisticDTO {

    Long id;
    String message;
    Date createdDate;
}
