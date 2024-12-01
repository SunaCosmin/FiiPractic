package com.example.demo.Controllers;

import com.example.demo.Entities.Profesor.Profesor;
import com.example.demo.Services.ProfesorService;
import jakarta.websocket.OnClose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/academia/profesori")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @GetMapping("/{id}")
    public Optional<Profesor> getProfesorById(@PathVariable Long id) {
        return profesorService.findProfesorById(id);
    }

    @GetMapping("/{id}/discipline")
    public List<String> getProfesorByDiscipline(@PathVariable Long id) {
        return profesorService.findProffesorLecturebyID(id);
    }
    @GetMapping("")
    public List<Object[]> getProfessors(
            @RequestParam(name = "acad_rank", required = false) String rank,
            @RequestParam(name = "nume", required = false) String nume) {
        if (rank != null) {
            return profesorService.findProfesorByRank(rank);
        } else if (nume != null) {
            return profesorService.findProfesorByName(nume);
        }
        return List.of();
    }
}
