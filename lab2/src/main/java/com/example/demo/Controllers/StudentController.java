package com.example.demo.Controllers;

import com.example.demo.Entities.Student.Studenti;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/academia/studenti")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Studenti> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Studenti> getStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/{id}/discipline")
    public List<Object[]> getStudentByLectures(@PathVariable Long id) {
        return studentService.getStudentLecturesByUserId(id);
    }
}
