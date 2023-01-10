package com.jea.payments.banking.service;

import org.springframework.stereotype.Service;

import com.jea.payments.banking.entity.VirtualCard;
import com.jea.payments.banking.entity.Wallet;
import com.jea.payments.banking.repository.VirtualCardRepository;
import com.jea.payments.banking.repository.WalletRepository;

import java.util.UUID;

@Service
public class VirtualCardService {
    private final VirtualCardRepository virtualCardRepository;
    private final WalletRepository walletRepository;

    public VirtualCardService(VirtualCardRepository virtualCardRepository, WalletRepository walletRepository) {
        this.virtualCardRepository = virtualCardRepository;
        this.walletRepository = walletRepository;
    }

    public VirtualCard generateVirtualCard(Long walletId, double limit) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found!"));

        VirtualCard card = new VirtualCard();
        card.setWallet(wallet);
        card.setCardLimit(limit);
        card.setCardNumber(UUID.randomUUID().toString());
        return virtualCardRepository.save(card);
    }
}
