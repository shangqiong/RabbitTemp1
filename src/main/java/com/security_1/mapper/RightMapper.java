package com.security_1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security_1.dao.Right;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public
interface RightMapper extends BaseMapper<Right> {
    List<String> getRightsById(Long id);
}
