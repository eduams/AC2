package com.ac2.ac2.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ac2.ac2.dtos.CursoDTO;
import com.ac2.ac2.dtos.DadosCursoDTO;
import com.ac2.ac2.models.Curso;
import com.ac2.ac2.services.CursoService;
import java.util.List;
@RestController
@RequestMapping("/api/curso")
public class CursoController {
private CursoService cursoService;
public CursoController(CursoService cursoService) {
this.cursoService = cursoService;
}
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Curso salvar(@RequestBody CursoDTO cursoDTO) {
Curso c = cursoService.salvar(cursoDTO);
return c;
}
@GetMapping("{id}")
public DadosCursoDTO getCursoPorId(@PathVariable Long id) {
return cursoService.obterCursoPorId(id);
}
@DeleteMapping("{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteCurso(@PathVariable Long id) {
cursoService.remover(id);
}
@PutMapping("{id}")
public void editCurso(@PathVariable Long id, @RequestBody CursoDTO dto) {
cursoService.editar(id, dto);
}
@GetMapping
public List<DadosCursoDTO> getCursos() {
return cursoService.obterTodos();
}
}