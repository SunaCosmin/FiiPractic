package com.example.demo.Services;

import com.example.demo.Entities.Discipline.Disciplina;
import com.example.demo.Repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {
    @Autowired
    private DisciplineRepository disciplineRepository;

    public Optional<Disciplina> findDisciplinaById(String COD) {
        return disciplineRepository.findById(COD);
    }

    public List<Disciplina> findAllDisciplina() {
        return disciplineRepository.findAll();
    }
    public List<String> findAllDisciplinabyTipAndCategorie(String tip,String categorie) {
        return disciplineRepository.findDisciplinabyTipAndCategorie(tip,categorie);
    }
}
