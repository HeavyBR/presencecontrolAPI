package com.gentleman.faultcontroller.requests;


import lombok.Data;

@Data
public class DisciplineRequest {

    private String name;
    private String teacher;
    private Integer abcenses;
    private Integer maxAbcenses;

}
