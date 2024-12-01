package com.example.demo.Services;

import com.example.demo.Entities.Profesor.Profesor;
import com.example.demo.Repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public Optional<Profesor> findProfesorById(Long id) {
        return profesorRepository.findById(id);
    }

    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    public List<String>findProffesorLecturebyID(Long id){
        return profesorRepository.findProffesorLecturesByID(id);
    }

    public List<Object[]>findProfesorByRank(String rank){
        return profesorRepository.findProfesorbyGrad(rank);
    }

    public List<Object[]>findProfesorByName(String nume){
        return profesorRepository.findProfesorbyNume(nume);
    }
}
