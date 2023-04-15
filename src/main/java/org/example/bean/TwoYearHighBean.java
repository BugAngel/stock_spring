package org.example.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class TwoYearHighBean{
    private String tradeDate;
    private String tsCode;
    private String symbol;
    private String name;
    private String industry;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal vol;
    private BigDecimal amount;
    private Integer secondHighDate;
}
