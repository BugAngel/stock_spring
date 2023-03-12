package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("ten_avg")
@Data
public class TenAvg {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String tsCode;

    private Integer tradeDate;

    private BigDecimal tenAvgClose;
}