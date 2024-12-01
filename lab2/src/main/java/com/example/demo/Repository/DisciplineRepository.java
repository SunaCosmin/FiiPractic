package com.example.demo.Repository;

import com.example.demo.Entities.Discipline.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineRepository extends JpaRepository<Disciplina,String> {
    @Query(value = "select nume_disciplina from discipline where tip_disciplina = :tip and categorie_disciplina= :categorie ",nativeQuery = true)
    List<String> findDisciplinabyTipAndCategorie(String tip, String categorie);
}
