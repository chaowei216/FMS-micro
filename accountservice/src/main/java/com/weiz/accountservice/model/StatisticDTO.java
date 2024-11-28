package com.weiz.accountservice.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatisticDTO {

    Long id;

    @NonNull
    String message;

    @NonNull
    Date createdDate;
}
