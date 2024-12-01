package com.example.demo.Repository;

import com.example.demo.Entities.Profesor.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    @Query(value = "select d.nume_disciplina from discipline d\n" +
            "join profesori p\n" +
            "on d.ID_titular=p.ID\n" +
            "where d.ID_titular= :id",nativeQuery = true)
    List<String> findProffesorLecturesByID(@Param("id") Long id);

    //Adaptare dto profesor aici
    @Query(value = "select p.nume,p.prenume from profesori p where p.grad_didactic= :rank",nativeQuery = true)
    List<Object[]> findProfesorbyGrad(@Param("rank") String rank);

    //Adaptare dto profesor aici
    @Query(value = "select p.nume,p.prenume from profesori p where p.nume like '%' :nume '%' ",nativeQuery = true)
    List<Object[]> findProfesorbyNume(@Param("nume") String nume);
}
