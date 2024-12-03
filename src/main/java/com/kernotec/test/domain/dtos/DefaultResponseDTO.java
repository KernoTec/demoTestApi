package com.kernotec.test.domain.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class DefaultResponseDTO<T> {
    private HttpStatus httpStatus;
    private T response;
    private String message;
}
