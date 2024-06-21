package com.example.demo.entites;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.constants.Constants;
import com.example.demo.model.Rewards;
import com.example.demo.repositories.TransactionRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author Navneet Lalam
 * @version 1.0
 * @since 2024-06-20
 */
@Service
public class RewardsServiceImpl implements RewardsService {

    @Autowired
    TransactionRepository transactionRepository;

    /**
     * Calculate rewards for the given customer
     *
     * @param customerId
     * @return Rewards
     * @author Navneet Lalam
     */
    @NotNull
    public Rewards getRewardsByCustomerId(Long customerId) {

        Timestamp lastMonthTimestamp = getDateBasedOnOffSetDays(Constants.daysInMonths);
        Timestamp lastSecondMonthTimestamp = getDateBasedOnOffSetDays(2 * Constants.daysInMonths);
        Timestamp lastThirdMonthTimestamp = getDateBasedOnOffSetDays(3 * Constants.daysInMonths);

        List<Transaction> lastMonthTransactions = transactionRepository.findAllByCustomerIdAndTransactionDateBetween(
                customerId, lastMonthTimestamp, Timestamp.from(Instant.now()));
        List<Transaction> lastSecondMonthTransactions = transactionRepository
                .findAllByCustomerIdAndTransactionDateBetween(customerId, lastSecondMonthTimestamp, lastMonthTimestamp);
        List<Transaction> lastThirdMonthTransactions = transactionRepository
                .findAllByCustomerIdAndTransactionDateBetween(customerId, lastThirdMonthTimestamp,
                        lastSecondMonthTimestamp);

        Long lastMonthRewardPoints = getRewardsPerMonth(lastMonthTransactions);
        Long lastSecondMonthRewardPoints = getRewardsPerMonth(lastSecondMonthTransactions);
        Long lastThirdMonthRewardPoints = getRewardsPerMonth(lastThirdMonthTransactions);

        Rewards customerRewards = new Rewards();
        customerRewards.setCustomerId(customerId);
        customerRewards.setLastMonthRewardPoints(lastMonthRewardPoints);
        customerRewards.setLastSecondMonthRewardPoints(lastSecondMonthRewardPoints);
        customerRewards.setLastThirdMonthRewardPoints(lastThirdMonthRewardPoints);
        customerRewards.setTotalRewards(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

        return customerRewards;

    }

    /**
     * Get calculated Reward per Month
     *
     * @Param List of transactions
     * @Return Rewards
     */
    @NotBlank(message = "transactions can not be blanked !")
    private Long getRewardsPerMonth(List<Transaction> transactions) {
        return transactions.stream().map(transaction -> calculateRewards(transaction.getTransactionAmount()))
                .collect(Collectors.summingLong(r -> r.longValue()));
    }

    /**
     * Calulating total reward  by usiing transsaction & condition for each customer
     *
     * @param amount
     * @return Total reward
     */
    @NotNull
    @Min(value = 0L, message = "The value must be positive")
    public Long calculateRewards(double amount) {
        if (amount > Constants.firstRewardLimit && amount <= Constants.secondRewardLimit) {
            return Math.round(amount - Constants.firstRewardLimit);
        } else if (amount > Constants.secondRewardLimit) {
            return Math.round(amount - Constants.secondRewardLimit) * 2
                    + (Constants.secondRewardLimit - Constants.firstRewardLimit);
        } else
            return 0l;

    }

    /**
     * Subtracting the number of specified day from this LocalDate
     *
     * @param days
     * @return Timestamp
     */
    @Min(value = 0L, message = "The value must be positive")
    @NotNull
    private Timestamp getDateBasedOnOffSetDays(int days) {
        return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
    }

}
