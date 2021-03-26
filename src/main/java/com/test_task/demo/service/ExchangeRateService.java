package com.test_task.demo.service;

import com.test_task.demo.component.ConnectMonitoring;
import com.test_task.demo.entity.ExchangeRate;
import com.test_task.demo.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class ExchangeRateService {

    private final ExchangeRateRepository repository;
    private final ReactiveRedisOperations<String, ExchangeRate> redisOperations;
    private final ConnectMonitoring connect;


    @Autowired
    public ExchangeRateService(ExchangeRateRepository repository, ReactiveRedisOperations<String, ExchangeRate> redisOperations, ConnectMonitoring connect) {
        this.repository = repository;
        this.redisOperations = redisOperations;
        this.connect = connect;
    }


    public Mono<ExchangeRate> findByCurrency(String currency) {
        if (connect.isConnect()) {
            try {
                return Mono.justOrEmpty(repository.findByCurrency(currency));
            } catch (DataAccessException e) {
                return redisOperations.opsForValue().get(currency);
            }
        } else {
            return redisOperations.opsForValue().get(currency);
        }

    }

    public Mono<List<ExchangeRate>> findByCurrLike(String currency) {
        if (connect.isConnect()) {
            try {
                return Mono.justOrEmpty(repository.findByCurLike(currency));
            } catch (DataAccessException e) {
                return redisOperations.keys("*" + currency + "*").flatMap(redisOperations.opsForValue()::get).collectList();
            }
        } else {
            return redisOperations.keys("*" + currency + "*").flatMap(redisOperations.opsForValue()::get).collectList();
        }
    }

}
