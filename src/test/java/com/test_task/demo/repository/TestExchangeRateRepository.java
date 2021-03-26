package com.test_task.demo.repository;


import com.test_task.demo.component.ConnectMonitoring;
import com.test_task.demo.entity.ExchangeRate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveRedisOperations;

import java.math.BigDecimal;
import java.sql.Timestamp;

@SpringBootTest
public class TestExchangeRateRepository {

    @Autowired
    ConnectMonitoring connetctMonitoring;

    @Autowired
    ExchangeRateRepository exchangeRateRepository;

    @Autowired
    ReactiveRedisOperations<String, ExchangeRate> redisOperations;

   /* @Test
    void addRowsExchangeRate(){
        exchangeRateRepository.save(new ExchangeRate("EU",new BigDecimal(90.10), new Timestamp(System.currentTimeMillis())));
        exchangeRateRepository.save(new ExchangeRate("FU",new BigDecimal(120.00), new Timestamp(System.currentTimeMillis())));
        exchangeRateRepository.save(new ExchangeRate("BU",new BigDecimal(75.40), new Timestamp(System.currentTimeMillis())));
    }

    @Test
    void insertRedis(){
        redisOperations.opsForValue().set(exchangeRateRepository.findById(1).get().getCurrency(), exchangeRateRepository.findById(1).get()).subscribe();
        redisOperations.opsForValue().set(exchangeRateRepository.findById(2).get().getCurrency(), exchangeRateRepository.findById(2).get()).subscribe();
        redisOperations.opsForValue().set(exchangeRateRepository.findById(3).get().getCurrency(), exchangeRateRepository.findById(3).get()).subscribe();
    }*/



}
