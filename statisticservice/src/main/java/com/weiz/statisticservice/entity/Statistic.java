package com.weiz.statisticservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Entity
@Table(name = "statistic")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "message")
    String message;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    Date createdDate;
}
