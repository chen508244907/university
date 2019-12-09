package com.qf.controller;

import com.qf.pojo.Discuss_User;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class Exeception {
    @ResponseBody
    @ExceptionHandler(value = AuthorizationException.class)
    public int exe(){
        return 1;
    }
}
