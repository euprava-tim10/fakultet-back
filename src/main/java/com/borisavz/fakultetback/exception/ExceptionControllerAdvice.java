package com.borisavz.fakultetback.exception;

import com.borisavz.fakultetback.exception.core.MalformedDataException;
import com.borisavz.fakultetback.exception.core.NotAllowedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotAllowedException.class)
    public ResponseEntity<Boolean> handleNotAllowedException() {
        log.error("Attempted to perform operation that is not allowed");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @ExceptionHandler(MalformedDataException.class)
    public ResponseEntity<Boolean> handleMalformedDataException() {
        log.error("Attempted to send malformed input data");
        return ResponseEntity.unprocessableEntity().build();
    }
}
