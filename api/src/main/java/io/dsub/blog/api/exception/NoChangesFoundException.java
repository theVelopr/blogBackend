package io.dsub.blog.api.exception;

import org.springframework.http.HttpStatus;

public class NoChangesFoundException extends BaseException {
    public NoChangesFoundException(String reason, HttpStatus status) {
        super(reason, status);
    }
}
