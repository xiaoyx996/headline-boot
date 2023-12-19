package com.phil.headline.exceptionhandler;

import com.phil.headline.common.Result;
import com.phil.headline.common.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Admin
 * @version 1.0
 * {@code @desc} TODO
 * {@code @create} 2023/12/19 15:41
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 违反了数据库的唯一约束条件，插入数据时。具有唯一约束条件的字段值重复。
     * @return
     */
    @ExceptionHandler(value = DuplicateKeyException.class)
    @ResponseBody
    public Object handlerDuplicateKeyException(DuplicateKeyException e){
        log.info("GlobalExceptionHandler.handlerDuplicateKeyException");
        log.error(e.getMessage());
        Result result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handlerException(Exception e){
        System.out.println("GlobalExceptionHandler.handlerException");
        e.printStackTrace();
        return Result.build(null, ResultCodeEnum.UNKNOW_ERROR);
    }
}
