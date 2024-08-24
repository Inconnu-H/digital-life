package org.ping.life.common;

import lombok.Getter;

/**
 * @author Ping
 */

@Getter
public enum ApiResponseCode {
    SUCCESS(200, "成功"),
    BAD_REQUEST(400, "错误的请求"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "未找到"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用");

    private final int code;
    private final String message;

    ApiResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
