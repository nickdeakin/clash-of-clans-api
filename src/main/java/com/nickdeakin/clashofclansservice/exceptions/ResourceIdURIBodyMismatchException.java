package com.nickdeakin.clashofclansservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceIdURIBodyMismatchException extends Exception {
    public ResourceIdURIBodyMismatchException(String message) {
        super(message);
    }
}

