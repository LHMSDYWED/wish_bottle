package com.lhm.star.mapper;

import com.lhm.star.entity.model.Member;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);


    /**
     * 通过注册手机号查询member
     * @param registerPhone
     * @return
     */
    Member selectByRegisterPhone(String registerPhone);
}