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
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "userId")
    private Long userId;

    @Column(nullable = false, length = 100, name = "firstName")
    private String firstName;

    @Column(nullable = false, length = 100, name = "middleName")
    private String middleName;

    @Column(nullable = false, length = 100, name = "lastName")
    private String lastName;

    @Column(nullable = false, unique = true, length = 100, name = "userName")
    private String userName;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "accessLevelId")
    private Long accessLevelId;

    @Column(nullable = false, name = "active")
    private Boolean active;

}
