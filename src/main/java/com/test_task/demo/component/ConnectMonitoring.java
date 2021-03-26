package com.test_task.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
@EnableScheduling
public class ConnectMonitoring {

    private boolean isConnect;

    @Autowired
    DataSource dataSource;

    @Scheduled(fixedRate = 60000)
    public void checkConnectBD() {

        try (Connection connection = dataSource.getConnection()) {
            isConnect = true;
        } catch (SQLException e) {
            isConnect = false;
        } finally {
            System.out.println("Have connection DB: " + isConnect);
        }

    }

    public boolean isConnect() {
        return isConnect;
    }
}
