package com.lhm.star.service.impl;



import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
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
import org.springframework.web.bind.annotation.GetMapping;

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
            if(pwd.equals(loginPassWord)){
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
        String registerPhone=member.getRegisterPhone();
        String pwd=member.getLoginPassword();
        Member member1=memberMapper.selectByRegisterPhone(registerPhone);
        //说明此手机号已经注册
        if(member1!=null){
            return  new Result(false,StatusCode.ACCESSERROR,"此手机号已注册，请直接登录");
        }
        //直接注册
      else {
          member.setMemberUuid(MemberUtil.getMemberUuid());
          member.setLoginPassword(MD5Util.getMD5(member.getLoginPassword()));
            memberMapper.insertSelective(member);
            return new Result(true,StatusCode.OK,"注册成功");
        }

    }
}
