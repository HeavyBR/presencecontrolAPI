package com.gentleman.faultcontroller.controller;


import com.gentleman.faultcontroller.repositories.DisciplineRepository;
import com.gentleman.faultcontroller.responses.DisciplineResponse;
import com.gentleman.faultcontroller.services.DisciplineService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
@RequiredArgsConstructor
public class DisciplineController {

    private final DisciplineService disciplineService;
    @GetMapping
    public ResponseEntity<List<DisciplineResponse>> getAllDisciplines () {
        return ResponseEntity.ok().body(disciplineService.findMany());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplineResponse> getDiscipline(@PathVariable int id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok().body(disciplineService.findDisciplineById(id));
    }
}
