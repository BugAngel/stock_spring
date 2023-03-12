package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("stock_basic")
@Data
public class StockBasic {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String tsCode;

    private String symbol;

    private String name;

    private String area;

    private String industry;

    private String fullname;

    private String enname;

    private String cnspell;

    private String market;

    private String exchange;

    private String currType;

    private String listStatus;

    private String listDate;

    private String delistDate;

    private String isHs;
}