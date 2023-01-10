package com.jea.payments.banking.controller;

import org.springframework.web.bind.annotation.*;

import com.jea.payments.banking.dto.WalletTopUpRequest;
import com.jea.payments.banking.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/top-up")
    public String topUp(@RequestBody WalletTopUpRequest request) {
        walletService.topUp(request);
        return "Wallet topped up successfully!";
    }

}
