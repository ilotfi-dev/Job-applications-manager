package com.example.workproject.util;

import lombok.*;


@Getter
@Setter
public class PersonErrorResponse {
    private String message;
    private Long timestamp;

    public PersonErrorResponse(String message, Long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
