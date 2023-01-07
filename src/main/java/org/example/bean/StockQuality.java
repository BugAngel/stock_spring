package org.example.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class StockQuality {
    private String tradeDate;
    private String tsCode;
    private BigDecimal close;
    private BigDecimal next_day_close;
    private BigDecimal next_2day_close;
    private BigDecimal next_5day_close;
    private BigDecimal next_10day_close;
    private BigDecimal next_20day_close;
}
