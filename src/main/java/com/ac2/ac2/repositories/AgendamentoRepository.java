package com.ac2.ac2.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ac2.ac2.models.Agendamento;
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}