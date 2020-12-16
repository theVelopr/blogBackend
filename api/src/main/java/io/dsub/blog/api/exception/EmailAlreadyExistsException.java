package io.dsub.blog.api.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends BaseException {
    public EmailAlreadyExistsException(String reason, HttpStatus status) {
        super(reason, status);
    }
}
