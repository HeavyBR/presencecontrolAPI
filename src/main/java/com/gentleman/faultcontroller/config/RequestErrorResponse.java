package com.gentleman.faultcontroller.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestErrorResponse {

    private String campo;
    private String erro;

}
