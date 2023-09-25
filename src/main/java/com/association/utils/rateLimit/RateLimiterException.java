package com.association.utils.rateLimit;

/**
 * @author LUMING
 * @since 2022/7/13 11:12
 */
public class RateLimiterException extends RuntimeException{
    public RateLimiterException(String message) {
        super(message);
    }
}
