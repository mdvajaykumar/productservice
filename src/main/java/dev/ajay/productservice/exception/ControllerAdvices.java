package dev.ajay.productservice.exception;

import dev.ajay.productservice.dto.NoDataFoundExceptionDto;
import dev.ajay.productservice.dto.NotFoundExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundExceptionDto> handleException(NotFoundException e) {

        return new ResponseEntity<>(new NotFoundExceptionDto(HttpStatus.NOT_FOUND, e.getMessage()), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(NoDatafoundException.class)
    public ResponseEntity<NoDataFoundExceptionDto> handleException(NoDatafoundException e) {

        return new ResponseEntity<>(new NoDataFoundExceptionDto(HttpStatus.NO_CONTENT, e.getMessage()), HttpStatus.NO_CONTENT

        );

    }

}
