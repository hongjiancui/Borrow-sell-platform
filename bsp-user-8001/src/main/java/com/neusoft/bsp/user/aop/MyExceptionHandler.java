package com.neusoft.bsp.user.aop;

import com.neusoft.bsp.common.base.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R handleAllExceptions(Exception ex) {
        log.error("error occurs: ", ex);
        return R.isFail().msg(ex);
    }
}
