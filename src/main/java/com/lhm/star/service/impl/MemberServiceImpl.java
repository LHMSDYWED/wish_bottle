package com.lhm.star.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.lhm.star.entity.model.Member;
import com.lhm.star.mapper.MemberMapper;
import com.lhm.star.service.MemberService;
import com.lhm.star.utils.common.MD5Util;
import com.lhm.star.utils.common.Result;
import com.lhm.star.utils.common.StatusCode;
import com.lhm.star.utils.memberutil.MemberUtil;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        System.out.println(member);
        String pwd=member.getLogin_password();
        System.out.println(pwd);
        if(pwd!=null&&pwd.equals(loginPassWord)){
            return  new Result(true, StatusCode.OK,"登录成功" );
        }else {
            return new Result(false,StatusCode.LOGINERROR,"请重新登录");
        }
    }

    /**
     * 用户注册
     * @param member
     * @return
     */
    @Override
    public Result insertMember(Member member) {
        //插入一条数据  先判断此手机号是否存在  存在则登录 不存在 则注册
        String registerPhone=member.getRegister_phone();
        String pwd=member.getLogin_password();
        Member member1=memberMapper.selectByRegisterPhone(registerPhone);
        //说明此手机号已经注册
        if(member1!=null){
            return  new Result(false,StatusCode.ACCESSERROR,"此手机号已注册，请直接登录");
        }
        //直接注册
      else {
          member.setMember_uuid(MemberUtil.getMemberUuid());
          member.setLogin_password(MD5Util.getMD5(member.getLogin_password()));
            memberMapper.insertSelective(member);
            return new Result(true,StatusCode.OK,"注册成功");
        }

    }
}
