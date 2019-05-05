package com.lhm.star.controller;

import com.lhm.star.annotation.UserLoginToken;
import com.lhm.star.entity.model.Member;
import com.lhm.star.service.MemberService;
import com.lhm.star.utils.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lhm
 * @date 2019/4/29 9:58
 **/

@Api(tags = "会员")
@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @ApiOperation(httpMethod = "GET",value = "会员: 登录")
    @GetMapping(value = "/loginMember/{registerPhone}/{loginPassWord}")
    public Result loginMember(@ApiParam("registerPhone") @PathVariable String registerPhone, @ApiParam("loginPassWord") @PathVariable String loginPassWord){
        return memberService.loginMember(registerPhone,loginPassWord);
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
    @ApiOperation(httpMethod = "POST",value = "会员: 注册")
    @PostMapping("/insertMember")
    public Result insertMember(@ApiParam("会员") @RequestBody Member member){
        return memberService.insertMember(member);
    }

}
