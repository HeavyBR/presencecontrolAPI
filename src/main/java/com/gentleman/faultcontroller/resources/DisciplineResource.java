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
    public List<Discipline> getDisciplines() {
        Discipline d1 = new Discipline(1, "Estrutura de Dados");
        Discipline d2 = new Discipline (2, "Algoritmos e programação de computadores I");

        List<Discipline> disciplines = new ArrayList<>(Arrays.asList(d1,d2));

        return disciplines;
    };

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
            Discipline obj = service.findOne(id);

            return ResponseEntity.ok().body(obj);
    }
}
