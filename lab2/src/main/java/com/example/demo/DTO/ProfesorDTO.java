package com.example.demo.DTO;

import lombok.Data;

@Data

public class ProfesorDTO {
    String nume;
    String prenume;

    public ProfesorDTO(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }
}
