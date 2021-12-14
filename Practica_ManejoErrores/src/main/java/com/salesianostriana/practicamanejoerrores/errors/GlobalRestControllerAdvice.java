package com.salesianostriana.practicamanejoerrores.errors;

import com.salesianostriana.practicamanejoerrores.errors.exceptions.EntityNotFoundException;
import com.salesianostriana.practicamanejoerrores.errors.model.ApiError;
import com.salesianostriana.practicamanejoerrores.errors.model.ApiSubError;
import com.salesianostriana.practicamanejoerrores.errors.model.ApiValidationSubErrors;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalRestControllerAdvice extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return this.buildApiError(ex, status, request, new ArrayList<>());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //return super.handleMethodArgumentNotValid(ex, headers, status, request);

        return buildApiError(ex, status,request, ex.getFieldErrors()
                .stream()
                .map(error -> ApiValidationSubErrors.builder()
                        .objeto(error.getObjectName())
                        .campo(error.getField())
                        .valorRechazado(error.getRejectedValue())
                        .mensaje(error.getDefaultMessage())
                        .build())
                .collect(Collectors.toList()));

    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(EntityNotFoundException exception, WebRequest request){

        return this.buildApiError(exception, HttpStatus.NOT_FOUND, request, new ArrayList<>());

    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<?> handleConstraintException(ConstraintViolationException ex, WebRequest request){

        return buildApiError(ex, HttpStatus.BAD_REQUEST, request,
                ex.getConstraintViolations()
                        .stream()
                        .map(cv -> ApiValidationSubErrors.builder()
                                .objeto(cv.getRootBeanClass().getSimpleName())
                                .campo(((PathImpl)cv.getPropertyPath()).getLeafNode().asString())
                                .valorRechazado(cv.getInvalidValue())
                                .mensaje(cv.getMessage())
                                .build())
                        .collect(Collectors.toList()));

    }



    private ResponseEntity<Object> buildApiError(Exception exception, HttpStatus status, WebRequest request, List<ApiSubError> subErrorList){

        ApiError error = ApiError.builder()
                .estado(status)
                .codigo(status.value())
                .ruta(((ServletWebRequest) request).getRequest().getRequestURI())
                .mensaje(exception.getMessage())
                .apiSubErrors(subErrorList)
                .build();

        return ResponseEntity.status(status).body(error);
    }

}
