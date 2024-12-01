package com.example.demo.Entities.Discipline;

import com.example.demo.Entities.Profesor.Profesor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "discipline")
public class Disciplina {
    @Id
    @Column(name = "COD", length = 20)
    private String COD;

    @ManyToOne
    @JoinColumn(name = "ID_titular", nullable = false)
    private Profesor titular;

    @Column(name = "nume_disciplina", nullable = false, length = 100)
    private String nume_disciplina;

    @Column(name = "an_studiu", nullable = false)
    private int an_studiu;

    @Column(name = "tip_disciplina", nullable = false)
    @Enumerated(EnumType.STRING)
    private Tip_disciplina tip_disciplina;

    @Column(name = "categorie_disciplina", nullable = false)
    @Enumerated(EnumType.STRING)
    private Categorie_disciplina categorie_disciplina;

    @Column(name = "tip_examinare", nullable = false)
    @Enumerated(EnumType.STRING)
    private Tip_examinare tip_examinare;
}
