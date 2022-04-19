package com.example.mapset_10_04_22lesson_2_7.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeisNodAlphaException extends RuntimeException {
}
