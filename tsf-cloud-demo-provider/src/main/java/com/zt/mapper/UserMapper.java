package com.zt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zt.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zt.赵童
 * @since 2019-01-14
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where u_name=#{name}")
    List<User> findByName(@Param("name") String name);

}
