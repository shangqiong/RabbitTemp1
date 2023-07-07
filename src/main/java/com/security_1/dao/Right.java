package com.security_1.dao;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "lr")
public class Right implements Serializable {
    private static final long serialVersionUID = 55784343457449428L;
    @TableId
    private int lid;
    private String lname;
}
