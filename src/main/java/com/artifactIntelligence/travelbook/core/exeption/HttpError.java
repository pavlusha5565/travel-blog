package com.artifactIntelligence.travelbook.core.exeption;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HttpError {
    private String statusCode;
    private String message;

    public HttpError(String statusCode, String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }
}
