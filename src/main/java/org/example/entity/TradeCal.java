package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("trade_cal")
@Data
public class TradeCal {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String exchange;

    private String calDate;

    private String isOpen;

    private String pretradeDate;
}