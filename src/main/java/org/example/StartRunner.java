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
        System.out.println(">>>服务启动第一个开始执行的任务: 初始化 TradeDays<<<<");
        Constant.TRADE_DAYS = tradeDaysService.getTradeDays();
        System.out.println(">>>服务启动第一个开始执行的任务: 初始化 TradeDays 完成<<<<");
    }
}
