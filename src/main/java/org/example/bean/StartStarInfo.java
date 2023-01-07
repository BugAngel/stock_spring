package org.example.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class StartStarInfo {
    private String tradeDate;
    private String tsCode;
    private String symbol;
    private String name;
    private String industry;
    private BigDecimal amount;
    private BigDecimal close;
    private BigDecimal next_day_close;
    private BigDecimal next_2day_close;
    private BigDecimal next_5day_close;
    private BigDecimal next_10day_close;
    private BigDecimal next_20day_close;

    public StartStarInfo(StockDailyBasic stockDailyBasic,StockQuality stockQuality){
        this.tradeDate = stockDailyBasic.getTradeDate();
        this.tsCode = stockDailyBasic.getTsCode();
        this.symbol = stockDailyBasic.getSymbol();
        this.name = stockDailyBasic.getName();
        this.industry = stockDailyBasic.getIndustry();
        this.amount = stockDailyBasic.getAmount();
        this.close = stockDailyBasic.getClose();
        this.next_day_close = stockQuality.getNext_day_close();
        this.next_2day_close = stockQuality.getNext_2day_close();
        this.next_5day_close = stockQuality.getNext_5day_close();
        this.next_10day_close = stockQuality.getNext_10day_close();
        this.next_20day_close = stockQuality.getNext_20day_close();
    }
}
