package com.ac2.ac2.services;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.ac2.ac2.dtos.CategoriaCursoDTO;
import com.ac2.ac2.dtos.CursoDTO;
import com.ac2.ac2.dtos.DadosCursoDTO;
import com.ac2.ac2.exceptions.RegraNegocioException;
import com.ac2.ac2.models.CategoriaCurso;
import com.ac2.ac2.models.Curso;
import com.ac2.ac2.repositories.CategoriaRepository;
import com.ac2.ac2.repositories.CursoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {
private final CursoRepository cursoRepository;
private final CategoriaRepository categoriaRepository;
@Override
@Transactional
public Curso salvar(CursoDTO cursoDTO) {
CategoriaCurso categ = categoriaRepository
.findById(cursoDTO.getCategoriaCursoId())
.orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));
Curso curso = new Curso();
curso.setNome(cursoDTO.getNome());
curso.setCargaHoraria(cursoDTO.getCargaHoraria());
curso.setCategoriaCurso(categ);
return cursoRepository.save(curso);
}

@Override
public DadosCursoDTO obterCursoPorId(Long id) {
return cursoRepository.findById(id).map((Curso c) -> {
return DadosCursoDTO.builder()
.id(c.getId())
.nome(c.getNome())
.cargaHoraria(c.getCargaHoraria())
.categoria(CategoriaCursoDTO.builder()
.id(c.getCategoriaCurso().getId())
.nome(c.getCategoriaCurso().getNome())
.build())
.build();
}).orElseThrow(() -> new RegraNegocioException("Curso não encontrado."));
}
@Override
@Transactional
public void remover(Long id) {
cursoRepository.deleteById(id);
}

@Override
@Transactional
public void editar(Long id, CursoDTO cursoDto) {
Curso curso = cursoRepository.findById(id)
.orElseThrow(() -> new RegraNegocioException("Curso não encontrado"));
CategoriaCurso categoria = categoriaRepository.findById(
cursoDto.getCategoriaCursoId())
.orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));
curso.setNome(cursoDto.getNome());
curso.setCargaHoraria(cursoDto.getCargaHoraria());
curso.setCategoriaCurso(categoria);
cursoRepository.save(curso);
}

@Override
public List<DadosCursoDTO> obterTodos() {
return cursoRepository.findAll().stream().map((Curso c) -> {
return DadosCursoDTO.builder()
.id(c.getId())
.nome(c.getNome())
.cargaHoraria(c.getCargaHoraria())
.categoria(CategoriaCursoDTO.builder()
.id(c.getCategoriaCurso().getId())
.nome(c.getCategoriaCurso().getNome())
.build())
.build();
}).collect(Collectors.toList());
}
}