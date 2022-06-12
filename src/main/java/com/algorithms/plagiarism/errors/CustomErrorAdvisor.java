package com.algorithms.plagiarism.errors;

import com.algorithms.plagiarism.errors.types.EntityNotFoundException;
import com.algorithms.plagiarism.errors.types.FileConversionFailed;
import com.algorithms.plagiarism.errors.types.IncompleteArgumentsException;
import com.algorithms.plagiarism.errors.types.InternalErrorException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomErrorAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IncompleteArgumentsException.class)
    public ResponseEntity<Object> handleIncompleteArgumentsException(
            IncompleteArgumentsException ex, WebRequest request
    ) {
        CustomErrorResponse error = new CustomErrorResponse(400);
        error.addErrorMessage(ex.getMessage());
        return new ResponseEntity<>(error.getErrorObject(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileConversionFailed.class)
    public ResponseEntity<Object> handleFileConversionFailed(
            FileConversionFailed ex, WebRequest request
    ) {
        CustomErrorResponse error = new CustomErrorResponse(500);
        error.addErrorMessage(ex.getMessage());
        return new ResponseEntity<>(error.getErrorObject(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InternalErrorException.class)
    public ResponseEntity<Object> handleInternalErrorException(
            InternalErrorException ex, WebRequest request
    ) {
        CustomErrorResponse error = new CustomErrorResponse(500);
        error.addErrorMessage(ex.getMessage());
        return new ResponseEntity<>(error.getErrorObject(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(
            EntityNotFoundException ex, WebRequest request
    ) {
        CustomErrorResponse error = new CustomErrorResponse(404);
        error.addErrorMessage(ex.getMessage());
        return new ResponseEntity<>(error.getErrorObject(), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request
    ) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        CustomErrorResponse error = new CustomErrorResponse(status.value());
        error.setErrorMessage(errors);

        return new ResponseEntity<>(error.getErrorObject(), HttpStatus.BAD_REQUEST);
    }
}
