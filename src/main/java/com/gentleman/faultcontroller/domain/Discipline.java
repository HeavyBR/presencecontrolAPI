package com.gentleman.faultcontroller.domain;


import com.gentleman.faultcontroller.requests.DisciplineRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_DISCIPLINE")
@Builder
public class Discipline implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @NotBlank
    private String name;

    @NotEmpty
    @NotBlank
    private String teacher;

    @NotNull
    private Integer absences;

    @NotNull
    private Integer maxAbsences;

    @ManyToOne
    private User user;


    public static Discipline valueOf (DisciplineRequest disciplineRequest) {
        return Discipline.builder()
                .name(disciplineRequest.getName())
                .teacher(disciplineRequest.getTeacher())
                .absences(disciplineRequest.getAbcenses())
                .maxAbsences(disciplineRequest.getMaxAbcenses())
                .build();
    }
}

