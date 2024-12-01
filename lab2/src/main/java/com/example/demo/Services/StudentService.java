package com.example.demo.Services;

import com.example.demo.Entities.Student.Studenti;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Optional<Studenti> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Studenti> getAllStudents() {
        return studentRepository.findAll();
    }


    public List<Object[]> getStudentLecturesByUserId(Long id) {
        return studentRepository.findDisciplinaIDByStudentID(id);
    }


}