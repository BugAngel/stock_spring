package org.example.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockQuality {
    String trade_date;
    String ts_code;
    String close;
    BigDecimal next_day_close;
    BigDecimal next_2day_close;
    BigDecimal next_5day_close;
    BigDecimal next_10day_close;
    BigDecimal next_20day_close;
}
