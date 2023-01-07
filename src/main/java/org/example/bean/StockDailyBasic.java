package org.example.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockDailyBasic {
    String tradeDate;
    String tsCode;
    String symbol;
    String name;
    String industry;
    BigDecimal amount;
}
