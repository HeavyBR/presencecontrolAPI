package com.gentleman.faultcontroller.resources;


import com.gentleman.faultcontroller.domain.Discipline;
import com.gentleman.faultcontroller.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/disciplines")
public class DisciplineResource {

    @Autowired
    private DisciplineService service;

    @GetMapping
    public ResponseEntity<?> getDisciplines() {

        List<Discipline> disciplines = service.findMany();

        return ResponseEntity.ok().body(disciplines);
    };

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
            Discipline obj = service.findOne(id);

            return ResponseEntity.ok().body(obj);
    }
}
