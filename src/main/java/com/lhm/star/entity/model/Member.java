package com.lhm.star.entity.model;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
@SuppressWarnings("serial")
@ApiModel(value = "会员表")
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("会员uuid")
    private String memberUuid;
    @ApiModelProperty("会员头像")
    private String memberImage;
    @ApiModelProperty("会员姓名")
    private String memberName;
    @ApiModelProperty("会员昵称")
    private String memberNickname;
    @ApiModelProperty("注册账号")
    private String loginName;
    @ApiModelProperty("密码")
    private String loginPassword;
    @ApiModelProperty("注册手机号")
    private String registerPhone;
    @ApiModelProperty("盐")
    private String salt;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;




    //Algorithm.HMAC256():使用HS256生成token,密钥则是用户的密码，唯一密钥的话可以保存在服务端。
//withAudience()存入需要保存在token的信息，这里我把用户ID存入token中
    public String getToken(Member member){
        String token=" ";
        token= JWT.create().withAudience(member.getRegisterPhone()).sign(Algorithm.HMAC256(member.getLoginPassword()));
        return token;
    }
}