package com.ac2.ac2.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ac2.ac2.models.Professor;
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
List<Professor> findByNomeLike(String nome);
}