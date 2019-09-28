package com.qf.bakinghelper.exception;

;
import com.qf.bakinghelper.common.JsonBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloablExceptionReslover {

    @ExceptionHandler(Exception.class)
    public JsonBean exception(Exception e){
        return new JsonBean(0,e.getMessage());
    }

}
