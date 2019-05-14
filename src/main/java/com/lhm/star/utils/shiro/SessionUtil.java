package com.lhm.star.utils.shiro;

import com.lhm.star.entity.model.Member;
import com.lhm.star.enums.SessionEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Session 工具类
 *
 * @author zhaozhenyao
 * @date 2018/5/10
 */
public class SessionUtil {

    /**
     * 获取当前Session
     *
     * @return 当前Session
     */
    public static Session getCurrentSession() {
        Subject subject = SecurityUtils.getSubject();
        return subject == null ? null : subject.getSession();
    }

    /**
     * 获取当前Session的ID
     *
     * @return 当前Session的ID
     */
    public static String getCurrentSessionId() {
        return getCurrentSession() == null ? null : getCurrentSession().getId().toString();
    }

    /**
     * 获取当前的用户对象
     *
     * @return 当前用户
     */
    public static Member getCurrentUser() {
        return getCurrentSession() == null ? null : (Member) getCurrentSession().getAttribute(SessionEnum.CURRENT_USER);
    }

    /**
     * 获取当前用户的ID
     *
     * @return 当前用户的ID
     */
    public static String getCurrentUserId() {
        return getCurrentUser() == null ? null : getCurrentUser().getMemberUuid();
    }

    /**
     * 存储参数到Session
     *
     * @param key   存储的key
     * @param value 存储的value
     */
    public static void setAttribute(String key, Object value) {
        Session session = getCurrentSession();
        if (session != null) {
            session.setAttribute(key, value);
        }
    }

    /**
     * 存储参数到Session
     *
     * @param sessionEnum 存储的key（枚举）
     * @param value       存储的value
     */
    public static void setAttribute(SessionEnum sessionEnum, Object value) {
        setAttribute(sessionEnum, value);
    }

}
