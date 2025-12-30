package com.rong.rongdadabackendcommon.exception;


import com.rong.rongdadabackendcommon.common.BaseResponse;
import com.rong.rongdadabackendcommon.common.ErrorCode;
import com.rong.rongdadabackendcommon.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("BusinessException", e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

/**
 * 全局异常处理器 - 处理运行时异常
 * 当程序中抛出RuntimeException时，会被此方法捕获并处理
 *
 * @param e 运行时异常对象
 * @return 返回一个统一的错误响应对象，包含错误码和错误信息
 */
    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<?> runtimeExceptionHandler(RuntimeException e) {
    // 记录错误日志，包含异常堆栈信息
        log.error("RuntimeException", e);
    // 返回系统错误响应，错误码为SYSTEM_ERROR，错误信息为"系统错误"
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "系统错误");
    }
}
