package com.jea.payments.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jea.payments.banking.entity.VirtualCard;

public interface VirtualCardRepository extends JpaRepository<VirtualCard, Long> {
}
