package com.example.demo.Controllers;

import com.example.demo.Entities.Discipline.Disciplina;
import com.example.demo.Entities.Profesor.Profesor;
import com.example.demo.Services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/academia/discipline")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("")
    public List<String> getAllDisciplina(
            @RequestParam(name = "tip",required = true) String tip,
            @RequestParam(name="categorie",required = true) String categorie
    ){
        return disciplineService.findAllDisciplinabyTipAndCategorie(tip,categorie);
    }

    @GetMapping("/{COD}")
    public Optional<Disciplina> getDisciplinaById(@PathVariable String COD){
        return disciplineService.findDisciplinaById(COD);
    }
}
