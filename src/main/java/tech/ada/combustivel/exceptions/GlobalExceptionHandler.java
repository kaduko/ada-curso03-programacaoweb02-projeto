package tech.ada.combustivel.exceptions;

import jakarta.validation.ConstraintDefinitionException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UsuarioNaoEncontradoException.class, UsuarioNaoEncontradoException.class})
    public DefaultError handleNotFoundException(RuntimeException e) {
        DefaultError error = new DefaultError();
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return error;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<DefaultError> validationHandler(MethodArgumentNotValidException e) {
        DefaultError error = new DefaultError();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getFieldError().getDefaultMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConstraintViolationException.class, ConstraintDefinitionException.class})
    public ResponseEntity<DefaultError> validationHandler(ValidationException e) {
        DefaultError error = new DefaultError();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<DefaultError> genericHandler(Exception e) {
        DefaultError error = new DefaultError();
        error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
