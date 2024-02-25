package com.artifactIntelligence.travelbook.core.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User not found")
public class TravelbookException extends RuntimeException {
    public TravelbookException() {
        super();
    }
    public TravelbookException(String message, Throwable cause) {
        super(message, cause);
    }
    public TravelbookException(String message) {
        super(message);
    }
    public TravelbookException(Throwable cause) {
        super(cause);
    }
}
