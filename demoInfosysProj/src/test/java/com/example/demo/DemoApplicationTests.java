package com.example.demo;

import com.example.demo.entites.RewardsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Navneet Lalam
 * @version 1.0
 * @since 2024-06-20
 */
@SpringBootTest
class DemoApplicationTests {
    @Autowired
    RewardsServiceImpl rewardsServiceImpl;

    // negative test case
    //test all the methods
    @Test
    void contextLoads() {
        assertEquals(90, rewardsServiceImpl.calculateRewards(120.0));
    }


}
