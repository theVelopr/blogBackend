package io.dsub.blog.api.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(String reason, HttpStatus status) {
        super(reason, status);
    }
}
