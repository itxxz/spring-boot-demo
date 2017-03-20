package com.itxxz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.itxxz.entity.User;

@Mapper
public interface UserMapper {

	@Select("select * from itxxz_user where account=#{account}")
	User findUserByAccount(@Param("account") String account);
}
