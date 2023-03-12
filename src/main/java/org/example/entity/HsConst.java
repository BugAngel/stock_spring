package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("hs_const")
@Data
public class HsConst {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String tsCode;

    private String hsType;

    private String inDate;

    private String outDate;

    private String isNew;
}