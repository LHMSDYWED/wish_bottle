package com.lhm.star.entity.model;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.swagger.annotations.ApiModel;
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
    private Integer id;

    private String memberUuid;

    private String memberName;

    private String memberNickname;

    private String loginName;

    private String loginPassword;

    private String registerPhone;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

//Algorithm.HMAC256():使用HS256生成token,密钥则是用户的密码，唯一密钥的话可以保存在服务端。
//withAudience()存入需要保存在token的信息，这里我把用户ID存入token中
    public String getToken(Member member){
        String token=" ";
        token= JWT.create().withAudience(member.getRegisterPhone()).sign(Algorithm.HMAC256(member.getLoginPassword()));
        return token;
    }
}