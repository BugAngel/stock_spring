package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("stock_hfq_daily")
@Data
public class StockHfqDaily {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String tsCode;

    private String tradeDate;

    private BigDecimal open;

    private BigDecimal high;

    private BigDecimal low;

    private BigDecimal close;

    private BigDecimal preClose;

    private BigDecimal change;

    private BigDecimal pctChg;

    private BigDecimal vol;

    private BigDecimal amount;
}
