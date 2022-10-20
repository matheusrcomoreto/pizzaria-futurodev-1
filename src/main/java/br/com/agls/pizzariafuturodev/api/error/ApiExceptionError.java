package br.com.agls.pizzariafuturodev.api.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Locale;

@ControllerAdvice
public class ApiExceptionError extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entidadeNotFoundException(EntityNotFoundException e, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        DefaultError body = DefaultError
                .builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .message(e.getMessage())
                .build();

        return handleExceptionInternal(e,body, new HttpHeaders(), status,request);
    }
}
