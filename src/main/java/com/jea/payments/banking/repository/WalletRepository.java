package com.jea.payments.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jea.payments.banking.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
