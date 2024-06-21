package com.example.demo.entites;

import com.example.demo.model.Rewards;
/**
 * @author Navneet Lalam
 * @version 1.0
 * @since 2024-06-20
 */
public interface RewardsService {
    public Rewards getRewardsByCustomerId(Long customerId);
}
