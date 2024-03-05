package com.example.storage.service.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "logs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(nullable = false, name = "userId")
    private User user;

    @Column(nullable = false, length = 1000, name = "event")
    private String event;

    @CreationTimestamp
    @Column(nullable = false, name = "timeStamp")
    private LocalDate timeStamp;

}
