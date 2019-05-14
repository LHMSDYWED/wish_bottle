package com.lhm.star.service;

import com.lhm.star.entity.model.Member;

/**
 * shiro安全认证
 * @author lhm
 * @date 2019/5/14 17:35
 **/
public interface ShiroService {
    /**
     * shiro安全验证 进行密码及合法性校验
     * @param memberUuid
     * @param registPhone
     * @param loginPassword
     * @return
     */
    Member login(String memberUuid,String registPhone,String loginPassword);

}
