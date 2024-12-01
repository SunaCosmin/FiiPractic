package com.example.demo.Entities.Student;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "studenti")
public class Studenti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;

    @Column(name = "nume", nullable = false, length = 50)
    private String nume;

    @Column(name = "prenume", nullable = false, length = 50)
    private String prenume;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "ciclu_studii", nullable = false)
    @Enumerated(EnumType.STRING)
    private Ciclu_studii ciclu_studii;

    @Column(name = "an_studiu", nullable = false)
    private int an_studiu;

    @Column(name = "grupa", nullable = false)
    private int grupa;


}
