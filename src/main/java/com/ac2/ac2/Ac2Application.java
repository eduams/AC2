package com.ac2.ac2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;

import com.ac2.ac2.dtos.CategoriaCursoDTO;
import com.ac2.ac2.dtos.CursoDTO;
import com.ac2.ac2.dtos.ProfDTO;
import com.ac2.ac2.models.CategoriaCurso;
import com.ac2.ac2.models.Curso;
import com.ac2.ac2.models.Professor;
import com.ac2.ac2.models.Agendamento;
import com.ac2.ac2.repositories.AgendamentoRepository;
import com.ac2.ac2.repositories.CategoriaRepository;
import com.ac2.ac2.repositories.CursoRepository;
import com.ac2.ac2.repositories.ProfessorRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@SpringBootApplication
public class Ac2Application {
			@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository,
			@Autowired CategoriaRepository categoriaRepository,
			@Autowired ProfessorRepository profRepository,
			@Autowired AgendamentoRepository agendamentoRepository
			) {
		return args -> {
			CategoriaCursoDTO catcursoDTO1 = new CategoriaCursoDTO();
			catcursoDTO1.setId((long) 0);
			catcursoDTO1.setNome("Biológicas");
			CategoriaCursoDTO catcursoDTO2 = new CategoriaCursoDTO();
			catcursoDTO2.setId((long) 0);
			catcursoDTO2.setNome("Exatas");
			CategoriaCursoDTO catcursoDTO3 = new CategoriaCursoDTO();
			catcursoDTO3.setId((long) 0);
			catcursoDTO3.setNome("Humanas");

			CategoriaCurso categoria = new CategoriaCurso();
			categoria.setNome(catcursoDTO1.getNome());
			categoriaRepository.save(categoria);
			CategoriaCurso categoria2 = new CategoriaCurso();
			categoria2.setNome(catcursoDTO2.getNome());
			categoriaRepository.save(categoria2);
			CategoriaCurso categoria3 = new CategoriaCurso();
			categoria3.setNome(catcursoDTO3.getNome());
			categoriaRepository.save(categoria3);

			CursoDTO cursoDTO1 = new CursoDTO();
			cursoDTO1.setId((long) 0);
			cursoDTO1.setNome("Ciências Biológicas");
			cursoDTO1.setCargaHoraria(320);
			cursoDTO1.setCategoriaCursoId((long) 0); 

			Curso curso1 = new Curso();
			curso1.setNome(cursoDTO1.getNome());
			curso1.setCargaHoraria(cursoDTO1.getCargaHoraria());
			curso1.setCategoriaCurso(categoria); 
			cursoRepository.save(curso1);

			CursoDTO cursoDTO2 = new CursoDTO();
			cursoDTO2.setId((long) 0);
			cursoDTO2.setNome("Engenharia da Computação");
			cursoDTO2.setCargaHoraria(320);
			cursoDTO2.setCategoriaCursoId((long) 0); 

			Curso curso2 = new Curso();
			curso2.setNome(cursoDTO2.getNome());
			curso2.setCargaHoraria(cursoDTO2.getCargaHoraria());
			curso2.setCategoriaCurso(categoria2); 
			cursoRepository.save(curso2);

			ProfDTO prof1DTO = new ProfDTO();
			prof1DTO.setId((long) 0);
			prof1DTO.setNome("Piccolo");
			prof1DTO.setCpf("000000000");
			prof1DTO.setRg("000000000");
			prof1DTO.setEndereco("Rua Namekusei, Jardim Kami-Sama, n-999");
			prof1DTO.setCelular("000000000");
			
			Professor prof1 = new Professor();
			prof1.setId(prof1DTO.getId());
			prof1.setCelular(prof1DTO.getCelular());
			prof1.setCpf(prof1DTO.getCpf());
			prof1.setCursos(Arrays.asList(curso1)); // adiciona curso ao professor (many to many)
			prof1.setEndereco(prof1DTO.getEndereco());
			prof1.setNome(prof1DTO.getNome());
			prof1.setRg(prof1DTO.getRg());
			profRepository.save(prof1);
			
			ProfDTO prof2DTO = new ProfDTO();
			prof2DTO.setId((long) 0);
			prof2DTO.setNome("Goku");
			prof2DTO.setCpf("000000000");
			prof2DTO.setRg("000000000");
			prof2DTO.setEndereco("Rua Saiyajin, Jardim Beerus, n-8000");
			prof2DTO.setCelular("000000000");

			Professor prof2 = new Professor();
			prof2.setId(prof2DTO.getId());
			prof2.setCelular(prof2DTO.getCelular());
			prof2.setCpf(prof2DTO.getCpf());
            prof2.setCursos(Arrays.asList(curso2)); // adiciona curso ao professor (many to many)
			prof2.setNome(prof2DTO.getNome());
			prof2.setRg(prof2DTO.getRg());
			profRepository.save(prof2);

			//Cadastro de entrada 1 na agenda
			Agendamento agenda1 = new Agendamento();
			agenda1.setId((long) 0);
			agenda1.setCidade("Sorocaba");
			agenda1.setEstado("São Paulo");
			agenda1.setCep("000000000");
			agenda1.setDatainicio(LocalDate.of(2023, 11, 13));
			agenda1.setDatafim(LocalDate.of(2023, 11, 17));
			agenda1.setHorarioinicio(LocalTime.of(8,0));
			agenda1.setHorariofim(LocalTime.of(12,0));
			agenda1.setCurso(prof1.getCursos().get(0));
			agenda1.setProfessor(prof1);
			agendamentoRepository.save(agenda1);

			//Cadastro de entrada 2 na agenda
			Agendamento agenda2 = new Agendamento();
			agenda2.setId((long) 0);
			agenda2.setCidade("Sorocaba");
			agenda2.setEstado("São Paulo");
			agenda2.setCep("000000000");
			agenda2.setDatainicio(LocalDate.of(2023, 11, 20));
			agenda2.setDatafim(LocalDate.of(2023, 11, 24));
			agenda2.setHorarioinicio(LocalTime.of(8,0));
			agenda2.setHorariofim(LocalTime.of(12,0));
			agenda2.setProfessor(prof2);
			agenda2.setCurso(prof2.getCursos().get(0));
			agendamentoRepository.save(agenda2);
		

			System.out.println("lalilulelo");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac2Application.class, args);
	}


}
