package com.gentleman.faultcontroller.services;

import com.gentleman.faultcontroller.domain.Discipline;
import com.gentleman.faultcontroller.repositories.DisciplineRepository;
import com.gentleman.faultcontroller.responses.DisciplineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplineService {

    @Autowired
    private DisciplineRepository repository;

    public DisciplineResponse findDisciplineById (Integer id) throws ChangeSetPersister.NotFoundException {
        Optional<Discipline> obj = Optional.ofNullable(repository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new));

        return DisciplineResponse.valueOf(obj.get());
    }

    public List<DisciplineResponse> findMany () {
        List<Discipline> disciplines = repository.findAll();

        return disciplines.stream().map(DisciplineResponse::valueOf).collect(Collectors.toList());
    }

}
