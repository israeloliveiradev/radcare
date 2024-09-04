package br.com.israeloliveira.user_api.resources.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.StandardException;

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
