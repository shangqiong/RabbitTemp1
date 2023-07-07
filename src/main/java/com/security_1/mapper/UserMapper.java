package com.security_1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security_1.dao.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
