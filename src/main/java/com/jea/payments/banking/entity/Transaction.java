package com.jea.payments.banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class Transaction extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionType; // e.g., "TOP_UP", "TRANSFER", "PAYMENT"
    private double amount;

    @ManyToOne
    private Wallet wallet;

    private String remarks;
}
