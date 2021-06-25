package com.nevesoft.barberScheduling.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchedulingRespose {
    private int status;
    private String message;
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime timestamp;

    public SchedulingRespose(String message, int status) {
        //super(message);
        this.message=message;
        this.status = status;
        this.timestamp= LocalDateTime.now();
    }
}
