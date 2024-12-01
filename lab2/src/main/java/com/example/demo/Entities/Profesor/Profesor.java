package com.example.demo.Entities.Profesor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "profesori")
public class Profesor {
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

    @Column(name = "grad_didactic", nullable = false)
    @Enumerated(EnumType.STRING)
    private Grad_didactic grad_didactic;

    @Column(name = "tip_asociere", nullable = false)
    @Enumerated(EnumType.STRING)
    private Tip_asociere tip_asociere;

    @Column(name = "afiliere", length = 100)
    private String afiliere;



}
