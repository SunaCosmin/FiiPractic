package com.example.demo.Repository;

import com.example.demo.Entities.Student.Studenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Studenti, Long> {

    //Adaptare disciplina dto aici
    @Query(value="select D.nume_disciplina, D.an_studiu, D.tip_disciplina, D.tip_examinare\n" +
            "from discipline D\n" +
            "join join_ds J on D.COD = J.DisciplinaID\n" +
            "where J.StudentID = :id",nativeQuery = true)
    List<Object[]> findDisciplinaIDByStudentID(@Param("id") Long id);


}

