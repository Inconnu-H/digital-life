package org.ping.life.common.exception;

import org.ping.life.common.ApiResponse;
import org.ping.life.common.ApiResponseCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Ping
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> handleException(Exception ex) {
        // 使用状态码枚举类来返回错误响应
        return ApiResponse.error(ApiResponseCode.INTERNAL_SERVER_ERROR, ApiResponseCode.INTERNAL_SERVER_ERROR.getMessage() + "：" + ex.getMessage());
    }

    // 可以添加更多的异常处理方法，使用不同的状态码
}
