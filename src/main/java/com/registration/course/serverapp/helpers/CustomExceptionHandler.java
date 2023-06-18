package com.registration.course.serverapp.helpers;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.registration.course.serverapp.api.dto.response.ResponseData;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ResponseData<String>> handleNoSuchElementException(NoSuchElementException ex) {
        ResponseData<String> responseData = new ResponseData<>();
        responseData.setStatus(false);
        responseData.getMessages().add("Data tidak ditemukan");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseData);
    }

    // Tambahkan penanganan exception lainnya jika diperlukan

    // ...
}