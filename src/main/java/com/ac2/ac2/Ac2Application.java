package com.ac2.ac2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ac2.ac2.dtos.CategoriaCursoDTO;
import com.ac2.ac2.dtos.CursoDTO;
import com.ac2.ac2.dtos.ProfDTO;
import com.ac2.ac2.models.CategoriaCurso;
import com.ac2.ac2.models.Curso;
import com.ac2.ac2.models.Professor;
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
			@Autowired ProfessorRepository profRepository
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
			curso2.setCategoriaCurso(categoria); 
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
			prof1.setCurso(curso1);
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
			prof2.setCurso(curso1);
			prof2.setEndereco(prof2DTO.getEndereco());
			prof2.setNome(prof2DTO.getNome());
			prof2.setRg(prof2DTO.getRg());
			profRepository.save(prof2);

			System.out.println("lalilulelo");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac2Application.class, args);
	}


}
