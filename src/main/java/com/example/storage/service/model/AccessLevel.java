package com.example.storage.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "access_level")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccessLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "accessLevelId")
    private Long accessLevelId;

    @Column(nullable = false, length = 100, name = "accessLevelName")
    private String accessLevelName;

}
