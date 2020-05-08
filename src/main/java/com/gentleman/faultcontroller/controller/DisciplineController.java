package com.gentleman.faultcontroller.controller;


import com.gentleman.faultcontroller.domain.Discipline;
import com.gentleman.faultcontroller.requests.DisciplineRequest;
import com.gentleman.faultcontroller.responses.DisciplineResponse;
import com.gentleman.faultcontroller.services.DisciplineService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/disciplines")
@RequiredArgsConstructor
public class DisciplineController {

    private final DisciplineService disciplineService;

    @Cacheable(value = "DisciplinesCache")
    @GetMapping
    public ResponseEntity<List<DisciplineResponse>> getAllDisciplines(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok().body(disciplineService.findMany(token));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplineResponse> getDiscipline(@PathVariable int id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok().body(disciplineService.findDisciplineById(id));
    }


    @PostMapping
    public ResponseEntity<DisciplineResponse> postDiscipline(@RequestBody DisciplineRequest disciplineRequest, UriComponentsBuilder uriComponentsBuilder) {
        Integer disciplineCreated = disciplineService.createNewDiscipline(disciplineRequest);
        URI uri = uriComponentsBuilder.path("/disciplines/{id}").buildAndExpand(disciplineCreated).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDisciplineById(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        disciplineService.deleteDisciplineById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDiscipline(@PathVariable Integer id, @RequestBody DisciplineRequest disciplineRequest) throws ChangeSetPersister.NotFoundException {
        disciplineService.updateDiscipline(id, disciplineRequest);
        return ResponseEntity.noContent().build();
    }

}
