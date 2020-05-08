package com.gentleman.faultcontroller.repositories;

import com.gentleman.faultcontroller.domain.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {
    List<Discipline> findByUser_Id(Integer userId);
}
