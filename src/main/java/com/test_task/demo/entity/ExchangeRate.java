package com.test_task.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
public class ExchangeRate {

    public ExchangeRate(String currency, BigDecimal value, Timestamp changeData) {
        this.currency = currency;
        this.value = value;
        this.changeData = changeData;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "currency")
    private String currency;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "changeData")
    private Timestamp changeData;


}
