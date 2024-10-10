package com.israeloliveiradev.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class StandardError {

    private LocalDateTime timeStamp;

    private String Error;

    private Integer status;

    private String path;
}
