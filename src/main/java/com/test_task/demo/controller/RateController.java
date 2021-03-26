package com.test_task.demo.controller;

import com.test_task.demo.entity.ExchangeRate;
import com.test_task.demo.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class RateController {

    private final ExchangeRateService exchangeRateService;

    @Autowired
    public RateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/rate/{currency}")
    public Mono<ExchangeRate> findeOne(@PathVariable String currency){
        return exchangeRateService.findByCurrency(currency);
    }

    @GetMapping("/rate_like/{currency}")
    public Mono<List<ExchangeRate>> findeListByCur(@PathVariable String currency){
        return exchangeRateService.findByCurrLike(currency);
    }



}
