package com.nevesoft.barberScheduling.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BarberSchedulingRespose {
    private int status;
    private String message;
    private LocalDateTime timestamp;

    public BarberSchedulingRespose(String message, int status) {
        //super(message);
        this.message=message;
        this.status = status;
        this.timestamp= LocalDateTime.now();
    }
}
