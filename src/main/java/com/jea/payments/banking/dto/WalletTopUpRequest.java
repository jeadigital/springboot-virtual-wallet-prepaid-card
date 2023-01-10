package com.jea.payments.banking.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WalletTopUpRequest {
    
    @NotNull(message = "Wallet ID is required.")
    private Long walletId;

    @Min(value = 1, message = "Top-up amount must be greater than 0.")
    private double amount;
}
