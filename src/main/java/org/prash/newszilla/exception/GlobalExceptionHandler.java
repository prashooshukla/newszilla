package org.prash.newszilla.exception;

import lombok.extern.slf4j.Slf4j;
import org.prash.newszilla.dto.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Project: NewsZilla
 * Author: bittu
 * Date: 11-06-2024
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleVideoNotFoundException(VideoNotFound ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        log.error("Exception Occurred {}", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleNewsNotFoundException(NewsNotFound ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        log.error("Exception Occurred {}", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
