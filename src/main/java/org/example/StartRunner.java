package org.example;

import org.example.service.TradeDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class StartRunner implements CommandLineRunner {
    @Autowired
    private TradeDaysService tradeDaysService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>> The service start the first task: initialization TradeDays <<<<");
        Constant.TRADE_DAYS = tradeDaysService.getTradeDays();
        System.out.println(">>> The service complete the first task: initialization TradeDays <<<<");
    }
}
