package com.nickdeakin.clashofclansservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MemberNotFoundException extends ResponseStatusException {
    public static final String MESSAGE = "%s is not an identifier for a current member.";

    public MemberNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

    public MemberNotFoundException(HttpStatus httpStatus, String id) {
        super(httpStatus, String.format(MESSAGE, id));
    }
}
