package com.amigoscode.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudRepository;

    @Autowired
    public FraudCheckService(FraudCheckHistoryRepository fraudRepository) {
        this.fraudRepository = fraudRepository;
    }

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudRepository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build());
        return false;
    }
}
