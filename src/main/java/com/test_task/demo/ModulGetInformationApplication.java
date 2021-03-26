package com.test_task.demo;

import com.test_task.demo.repository.ExchangeRateRepository;
import io.lettuce.core.ScriptOutputType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModulGetInformationApplication {



    public static void main(String[] args) {
        SpringApplication.run(ModulGetInformationApplication.class, args);
    }

}
