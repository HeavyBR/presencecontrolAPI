package com.gentleman.faultcontroller.services;

import com.gentleman.faultcontroller.config.security.AuthTokenService;
import com.gentleman.faultcontroller.domain.Discipline;
import com.gentleman.faultcontroller.repositories.DisciplineRepository;
import com.gentleman.faultcontroller.requests.DisciplineRequest;
import com.gentleman.faultcontroller.responses.DisciplineResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DisciplineService {

    private final AuthTokenService authService;
    private final DisciplineRepository repository;

    public DisciplineResponse findDisciplineById(Integer id) throws ChangeSetPersister.NotFoundException {
        Optional<Discipline> obj = Optional.ofNullable(repository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new));

        return DisciplineResponse.valueOf(obj.get());
    }

    public List<DisciplineResponse> findMany(String token) {

        try {
            Integer loggedUser = authService.getUserId(token.substring(7));
            List < Discipline > disciplines = repository.findByUserId(loggedUser);
            System.out.println(disciplines);
            return disciplines.stream().map(DisciplineResponse::valueOf).collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public int createNewDiscipline(DisciplineRequest disciplineRequest) {
        Discipline disciplineCreated = repository.save(Discipline.valueOf(disciplineRequest));
        return disciplineCreated.getId();
    }

    public void deleteDisciplineById(Integer id) throws ChangeSetPersister.NotFoundException {
        repository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        repository.deleteById(id);
    }

    public void updateDiscipline(Integer id, DisciplineRequest disciplineRequest) throws ChangeSetPersister.NotFoundException {
        Optional<Discipline> discipline = Optional.ofNullable(repository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new));
        if(discipline.isPresent()) {
            Discipline newDiscipline = discipline.get();
            newDiscipline.setName(disciplineRequest.getName());
            newDiscipline.setAbsences(disciplineRequest.getAbcenses());
            newDiscipline.setMaxAbsences(disciplineRequest.getMaxAbcenses());
            newDiscipline.setTeacher(disciplineRequest.getTeacher());
            repository.save(newDiscipline);
        }
    }

}
