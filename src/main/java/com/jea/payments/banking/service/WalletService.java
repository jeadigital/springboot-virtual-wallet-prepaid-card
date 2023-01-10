package com.jea.payments.banking.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jea.payments.banking.dto.WalletTopUpRequest;
import com.jea.payments.banking.entity.Transaction;
import com.jea.payments.banking.entity.Wallet;
import com.jea.payments.banking.repository.TransactionRepository;
import com.jea.payments.banking.repository.WalletRepository;

@Service
public class WalletService {
    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    public WalletService(WalletRepository walletRepository, TransactionRepository transactionRepository) {
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public void topUp(WalletTopUpRequest request) {
        Wallet wallet = walletRepository.findById(request.getWalletId())
                .orElseThrow(() -> new RuntimeException("Wallet not found!"));

        wallet.setBalance(wallet.getBalance() + request.getAmount());
        walletRepository.save(wallet);

        Transaction transaction = new Transaction();
        transaction.setTransactionType("TOP_UP");
        transaction.setAmount(request.getAmount());
        transaction.setWallet(wallet);
        transaction.setRemarks("Wallet top-up");
        transactionRepository.save(transaction);
    }
}
