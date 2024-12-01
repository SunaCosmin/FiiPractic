package com.example.demo.DTO;

import lombok.Data;

@Data

public class DisciplineDTO {
    private String numeDisciplina;
    private int anStudiu;
    private Tip_disciplina tipDisciplina;
    private Tip_examinare tipExaminare;


    public DisciplineDTO(String numeDisciplina, int anStudiu, Tip_disciplina tipDisciplina, Tip_examinare tipExaminare) {
        this.numeDisciplina = numeDisciplina;
        this.anStudiu = anStudiu;
        this.tipDisciplina = tipDisciplina;
        this.tipExaminare = tipExaminare;
    }
    private enum Tip_disciplina {
        impusa,
        optionala,
        liber_aleasa
    }

    private enum Tip_examinare {
        examen,
        colocviu
    }


}
