package com.vibras.infraestructura.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(ManejadorError.class);

    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR =  "Ocurrió un error favor contactar al administrador.";

    private static final ConcurrentHashMap<String,Integer> CODIGO_ESTADO = new ConcurrentHashMap<>();

    public ManejadorError(){
        CODIGO_ESTADO.put(IllegalStateException.class.getSimpleName(), HttpStatus.CONFLICT.value());
    }

    public final ResponseEntity<Error> handleAllExceptions(Exception exception){
        ResponseEntity<Error> resultado;

        String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = CODIGO_ESTADO.get(excepcionNombre);
        if (codigo!= null){
            Error error = new Error(excepcionNombre,mensaje);
            resultado = new ResponseEntity<>(error,HttpStatus.valueOf(codigo));

        }else{
            LOGGER_ERROR.error(excepcionNombre,exception);
            Error error = new Error(excepcionNombre,OCURRIO_UN_ERROR_FAVOR_CONTACTAR);
            resultado = new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resultado;
    }
}
