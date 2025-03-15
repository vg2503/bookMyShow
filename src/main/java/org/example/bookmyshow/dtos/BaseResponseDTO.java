package org.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public abstract class BaseResponseDTO {
    private int code;
    private String message;
    private ResponseStatus responseStatus;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
