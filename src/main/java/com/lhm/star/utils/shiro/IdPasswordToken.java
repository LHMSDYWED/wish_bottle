package com.lhm.star.utils.shiro;

/**
 * @author lhm
 * @date 2019/5/14 17:20
 **/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.RememberMeAuthenticationToken;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdPasswordToken implements HostAuthenticationToken, RememberMeAuthenticationToken {

    /**
     * 用户ID
     */
    private String register;
    /**
     * 用户密码
     */
    private char[] password;
    /**
     * 是否记住
     */
    private boolean rememberMe;
    /**
     * IP
     */
    private String host;

    public IdPasswordToken(String register, String password, boolean rememberMe, String host) {
        this.register = register;
        this.password = password == null ? null : password.toCharArray();
        this.rememberMe = rememberMe;
        this.host = host;
    }

    /**
     * 获取身份
     *
     * @return 身份
     */
    @Override
    public Object getPrincipal() {
        return null;
    }

    /**
     * 获取凭证
     *
     * @return 凭证
     */
    @Override
    public Object getCredentials() {
        return null;
    }

    /**
     * 清除信息
     */
    public void clear() {
        this.register = null;
        this.host = null;
        this.rememberMe = false;
        if (this.password != null) {
            for (int i = 0; i < this.password.length; ++i) {
                this.password[i] = '\0';
            }
            this.password = null;
        }
    }

    @Override
    public String toString() {
        return "IdPasswordToken{" +
                "register='" + register + '\'' +
                ", rememberMe=" + rememberMe +
                ", host='" + host + '\'' +
                '}';
    }
}