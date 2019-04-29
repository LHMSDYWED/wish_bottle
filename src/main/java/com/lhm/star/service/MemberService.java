package com.lhm.star.service;

import com.lhm.star.entity.model.Member;
import com.lhm.star.utils.common.Result;

/**
 * @author lhm
 * @date 2019/4/29 9:55
 **/
public interface MemberService {
    /**
     * 用户登录
     * @param registerPhone
     * @return
     */
    Result loginMember(String registerPhone, String loginPassWord);

    /**
     * 用户注册
     * @param member
     * @return
     */
    Result insertMember(Member member);
}
