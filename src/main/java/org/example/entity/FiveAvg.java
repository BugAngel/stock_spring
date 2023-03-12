package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("five_avg")
@Data
public class FiveAvg {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String tsCode;

    private Integer tradeDate;

    private BigDecimal fiveAvgClose;
}