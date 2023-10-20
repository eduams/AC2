package com.ac2.ac2.services;
import java.util.*;
import com.ac2.ac2.dtos.CursoDTO;
import com.ac2.ac2.dtos.DadosCursoDTO;
import com.ac2.ac2.models.Curso;
public interface CursoService {
Curso salvar(CursoDTO cursoDTO);
DadosCursoDTO obterCursoPorId(Long id);
void remover(Long id);
void editar(Long id, CursoDTO cursoDto);
List<DadosCursoDTO> obterTodos();
}