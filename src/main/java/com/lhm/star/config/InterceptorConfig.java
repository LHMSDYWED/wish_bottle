package com.lhm.star.config;

import com.lhm.star.filter.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author lhm
 * @date 2019/4/30 11:55
 **/

/**
 * configuration 标明这个类是一个配置类 并且会将这个类作为一个springbean添加到ioc容器中
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    /**
     * InterceptorRegistry内的addInterceptor需要一个实现HandlerInterceptor接口的拦截器实例，addPathPatterns方法用于设置拦截器的过滤路径规则。
     * 这里我拦截所有请求，通过判断是否有@LoginRequired注解 决定是否需要登录
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
    }
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

}
