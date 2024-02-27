package com.example.storage.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storage.service.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
