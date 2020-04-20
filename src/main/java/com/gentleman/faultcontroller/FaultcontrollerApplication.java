package com.gentleman.faultcontroller;

import com.gentleman.faultcontroller.domain.Discipline;
import com.gentleman.faultcontroller.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class FaultcontrollerApplication {


    public static void main(String[] args) {
        SpringApplication.run(FaultcontrollerApplication.class, args);
    }

}
