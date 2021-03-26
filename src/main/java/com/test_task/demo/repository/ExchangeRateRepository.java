package com.test_task.demo.repository;

import com.test_task.demo.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {

    ExchangeRate findByCurrency(String currency);



    @Query(value = "select * from exchange_rate  WHERE currency like %:cur%", nativeQuery = true)
    List<ExchangeRate> findByCurLike(@Param("cur")String cur);


}
