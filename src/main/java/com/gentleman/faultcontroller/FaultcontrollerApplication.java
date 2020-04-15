package com.gentleman.faultcontroller;

import com.gentleman.faultcontroller.domain.Discipline;
import com.gentleman.faultcontroller.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class FaultcontrollerApplication implements CommandLineRunner {

    @Autowired
    DisciplineRepository disciplineRepository;

    public static void main(String[] args) {
        SpringApplication.run(FaultcontrollerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Discipline d1 = new Discipline(null, "Informática");
        Discipline d2 = new Discipline(null, "Esconomia");

        disciplineRepository.saveAll(Arrays.asList(d1,d2));
    }
}
