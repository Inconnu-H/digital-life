package org.ping.life.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ping
 */
@Setter
@Getter
public class ApiResponse<T> {
    // Getter 和 Setter 方法
    private int code;
    private String message;
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 使用状态码枚举类的快捷方法
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ApiResponseCode.SUCCESS.getCode(), ApiResponseCode.SUCCESS.getMessage(), data);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(ApiResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ApiResponse<T> error(ApiResponseCode code) {
        return new ApiResponse<>(code.getCode(), code.getMessage(), null);
    }

    public static <T> ApiResponse<T> error(ApiResponseCode code, String message) {
        return new ApiResponse<>(code.getCode(), message, null);
    }

}
