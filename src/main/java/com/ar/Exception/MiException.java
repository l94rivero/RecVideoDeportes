package com.ar.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class MiException extends Exception{

    public MiException(String msg) {
        super(msg);
    }
}
