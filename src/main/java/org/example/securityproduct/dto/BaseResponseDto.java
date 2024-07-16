package org.example.securityproduct.dto;

import lombok.Data;

@Data
public class BaseResponseDto {
    private Object message;
    private Object date;

    public BaseResponseDto(Object message) {
        this.message = message;
    }

    public BaseResponseDto(Object message, Object date) {
        this.message = message;
        this.date = date;
    }
}
