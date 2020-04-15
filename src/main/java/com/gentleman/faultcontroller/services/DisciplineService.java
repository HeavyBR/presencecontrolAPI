package com.gentleman.faultcontroller.services;

import com.gentleman.faultcontroller.domain.Discipline;
import com.gentleman.faultcontroller.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {

    @Autowired
    private DisciplineRepository repository;

    public Discipline findOne (Integer id) {
        Optional<Discipline> obj = repository.findById(id);
        return obj.get();
    }

    public List<Discipline> findMany () {
        return repository.findAll();
    }
}
