package com.jea.payments.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jea.payments.banking.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
