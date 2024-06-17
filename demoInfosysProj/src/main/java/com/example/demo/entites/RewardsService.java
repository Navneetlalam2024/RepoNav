package com.example.demo.entites;

import com.example.demo.model.Rewards;

public interface RewardsService {
    public Rewards getRewardsByCustomerId(Long customerId);
}
