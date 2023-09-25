package com.association.utils.rateLimit;

import java.lang.annotation.*;

/**
 * @author LUMING
 * @since 2022/7/13 10:26
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {

    /**
     * 限流key
     */
    String key() default "rateLimit";

    /**
     * 限流时间，单位秒
     */
    int time()default 5;

    /**
     * 限流次数
     */
    int count() default 20;

    /**
     * 限流类型 默认全局限流
     */
    LimitType limitType() default LimitType.ALL;

}
