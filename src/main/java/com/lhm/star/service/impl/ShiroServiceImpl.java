package com.lhm.star.service.impl;

import com.lhm.star.entity.model.Member;
import com.lhm.star.mapper.MemberMapper;
import com.lhm.star.service.ShiroService;
import com.lhm.star.utils.shiro.PasswordUtil;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lhm
 * @date 2019/5/14 17:37
 **/
@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member login(String memberUuid, String registPhone, String loginPassword) {
       Member member=memberMapper.selectByRegisterPhone(registPhone);
       //校验密码
       this.validateUserPassword(member,member.getLoginPassword());
       //清除用户密码
        this.hidePassword(member);
       return member;
    }




    /**
     * 校验用户密码
     *
     * @param member     用户
     * @param password 需要校验的密码
     */
    private void validateUserPassword(Member member, String password) {
        if (member == null) {
            // 用户不存在
            throw new UnknownAccountException();
        }
        String passwordDb = member.getLoginPassword();
        if (!passwordDb.equals(PasswordUtil.encrypt(password, member.getSalt()))) {
            //密码不正确
            throw new IncorrectCredentialsException();
        }
    }

    /**
     * 隐藏密码
     * @param member
     */
    private  void hidePassword(Member member){
        member.setLoginPassword("");
    }
}
