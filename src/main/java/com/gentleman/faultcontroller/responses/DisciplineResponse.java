package com.gentleman.faultcontroller.responses;


import com.gentleman.faultcontroller.domain.Discipline;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DisciplineResponse {

    private int id;
    private String name;
    private String teacher;
    private Integer maxAbsence;
    private Integer absences;

    public static DisciplineResponse valueOf(Discipline discipline) {
        return DisciplineResponse.builder()
                .id(discipline.getId())
                .name(discipline.getName())
                .teacher(discipline.getTeacher())
                .absences(discipline.getAbsences())
                .maxAbsence(discipline.getMaxAbsences())
                .build();
    }

}
