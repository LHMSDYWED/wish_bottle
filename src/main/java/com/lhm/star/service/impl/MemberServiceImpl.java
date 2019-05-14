package com.lhm.star.service.impl;



import com.lhm.star.entity.model.Member;
import com.lhm.star.mapper.MemberMapper;
import com.lhm.star.service.MemberService;
import com.lhm.star.utils.common.MD5Util;
import com.lhm.star.utils.common.Result;
import com.lhm.star.utils.common.StatusCode;
import com.lhm.star.utils.exception.RRException;
import com.lhm.star.utils.memberutil.MemberUtil;
import com.lhm.star.utils.shiro.PasswordUtil;
import com.lhm.star.utils.shiro.RandomUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author lhm
 * @date 2019/4/29 9:55
 **/
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;


    /**
     * 用户登录
     * @param registerPhone
     * @param loginPassWord
     * @return
     */
    @Override
    public Result loginMember(String registerPhone, String loginPassWord) {

        Member member= memberMapper.selectByRegisterPhone(registerPhone);
        if(member!=null){
            String pwd=member.getLoginPassword();
            String md5Password=MD5Util.getMD5(loginPassWord+member.getSalt());
            if(pwd.equals(md5Password)){
                String token=member.getToken(member);
                return  new Result(true, StatusCode.OK,"登录成功",token);
            }else {
                return new Result(false,StatusCode.LOGINERROR,"请重新登录");
            }
        }
        return  new Result(false,StatusCode.ACCESSERROR,"该手机号未注册，请先注册");

    }

    /**
     * 用户注册
     * @param member
     * @return
     */
    @Override
    public Result insertMember(Member member) {
        //插入一条数据  先判断此手机号是否存在  存在则登录 不存在 则注册
        validateMember(member);
        String salt= RandomUtil.getSalt();
        member.setSalt(salt);
        String loginPassword= PasswordUtil.encrypt(member.getLoginPassword(),salt);
        member.setLoginPassword(loginPassword);
        member.setCreateTime(new Date());
        memberMapper.insertSelective(member);
        return new Result(true,StatusCode.OK,"注册成功");

    }


    private  void validateMember(Member member){
        if(member==null){
            throw new RRException("用户不存在");
        }
        if(StringUtils.isBlank(member.getRegisterPhone())){
            throw  new RRException("注册手机不能为空");
        }
        if(StringUtils.isBlank(member.getLoginPassword())){
            throw new  RRException("登录密码不能为空");
        }
    }
}
