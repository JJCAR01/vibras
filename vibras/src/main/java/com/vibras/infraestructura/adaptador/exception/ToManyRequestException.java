package com.vibras.infraestructura.adaptador.exception;

public class ToManyRequestException extends RuntimeException {

    public ToManyRequestException(Exception e) {
        super(e);
    }
}
