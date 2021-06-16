package com.nevesoft.barberScheduling.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.Map;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ApiError {
    private int status;
    private String message;
    private long timestamp;
    private String path;
    Map<String, String> validationErrors;

    public ApiError(int status, String message, String path){
        super();
        this.timestamp=new Date().getTime();
        this.status = status;
        this.message = message;
        this.path = path;
    }

}
