package com.example.workproject.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillErrorResponse {
    private String message;
    private Long timestamp;

    public SkillErrorResponse(String message, Long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
