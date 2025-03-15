package org.example.bookmyshow.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponseDTO {
    private int code;
    private String message;
    private ResponseStatus responseStatus;
}
