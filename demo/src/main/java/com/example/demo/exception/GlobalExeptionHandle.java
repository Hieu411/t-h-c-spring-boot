package com.example.demo.exception;


import com.example.demo.dto.request.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class GlobalExeptionHandle {
    @ExceptionHandler (value = Exception.class)
    ResponseEntity<ApiResponse> handlingRunTimeException(RuntimeException exception)
    {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(ErrorCode.USER_EXISTED.getMessage());


        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler (value = AppException.class)
    ResponseEntity<ApiResponse> handlingRunTimeException(AppException exception)
    {
        ErrorCode errorCode = exception.getErrorCode();

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());


        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingValidation(MethodArgumentNotValidException exception)
    {
        String enumkey=exception.getFieldError().getDefaultMessage();


        ErrorCode errorCode = ErrorCode.KEY_INVALID;
        errorCode = ErrorCode.valueOf(enumkey);

     try{
         errorCode = ErrorCode.valueOf(enumkey);
     }
     catch (IllegalArgumentException e){

     }

        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());



        return ResponseEntity.badRequest().body(Objects.requireNonNull(apiResponse));
    }
}
