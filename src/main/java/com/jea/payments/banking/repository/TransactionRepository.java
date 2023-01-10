package com.jea.payments.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jea.payments.banking.entity.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByWalletIdOrderByCreatedDateDesc(Long walletId);
}
