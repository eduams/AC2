package com.ac2.ac2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
			//variáveis para o tamanho dos arrays
			int cursoSize;
			int profSize;
			int agendaSize;

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

			//criação do array de cursos. Máximo de 5 cursos
			Curso[] curso = new Curso[99];
			int loop = 0;
			while(loop < 99){
				curso[loop] = new Curso();
				loop++;
			}
			curso[0].setNome(cursoDTO1.getNome());
			curso[0].setCargaHoraria(cursoDTO1.getCargaHoraria());
			curso[0].setCategoriaCurso(categoria); 
			cursoRepository.save(curso[0]);
			cursoSize = 1;

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

			ProfDTO profDTO = new ProfDTO();

			ProfDTO prof2DTO = new ProfDTO();
			prof2DTO.setId((long) 0);
			prof2DTO.setNome("Goku");
			prof2DTO.setCpf("000000000");
			prof2DTO.setRg("000000000");
			prof2DTO.setEndereco("Rua Saiyajin, Jardim Beerus, n-8000");
			prof2DTO.setCelular("000000000");

			Professor[] prof = new Professor[99];
			loop = 0;
			while(loop < 99){
				prof[loop] = new Professor();
				loop++;
			}
			prof[profSize].setId(prof2DTO.getId());
			prof[profSize].setCelular(prof2DTO.getCelular());
			prof[profSize].setCpf(prof2DTO.getCpf());
			prof[profSize].setCursos(new ArrayList<>(Arrays.asList(curso[0])));
			prof[profSize].getCursos().addAll(Arrays.asList(curso2));			
			prof[profSize].setNome(prof2DTO.getNome());
			prof[profSize].setRg(prof2DTO.getRg());
			profRepository.save(prof[profSize]);
			profSize = 1;

			//Cadastro de entrada 1 na agenda
			Agendamento agenda[] = new Agendamento[99];
			loop = 0;
			while(loop < 99){
				agenda[loop] = new Agendamento();
				loop++;
			}
			agenda[agendaSize].setId((long) 0);
			agenda[agendaSize].setCidade("Sorocaba");
			agenda[agendaSize].setEstado("São Paulo");
			agenda[agendaSize].setCep("000000000");
			agenda[agendaSize].setDatainicio(LocalDate.of(2023, 11, 13));
			agenda[agendaSize].setDatafim(LocalDate.of(2023, 11, 17));
			agenda[agendaSize].setHorarioinicio(LocalTime.of(8,0));
			agenda[agendaSize].setHorariofim(LocalTime.of(12,0));
			agenda[agendaSize].setCurso(prof[0].getCursos().get(0));
			agenda[agendaSize].setProfessor(prof[0]);
			agendamentoRepository.save(agenda[agendaSize]);
			agendaSize = 1;
		
			//inputs da secretária
			int dia;
			int mes;
			int ano;
			int horas;
			int minutos;
			int inputProf;
			int inputCurso;

			Scanner scan = new Scanner(System.in);
			int profInput;
			String inputString;
			boolean inputLoop = true;
		while (inputLoop == true){
			System.out.println("Digite qual operação deseja efetuar");
			System.out.println("1 - Cadastrar professor | 2 - Cadastrar curso | "+
			"3 - Cadastrar agenda | 4 - finalizar");
			int input = scan.nextInt();
			switch (input) {
				case 1:
					profDTO = new ProfDTO();
					profDTO.setId((long) 0);

					System.out.println("Insira um nome");
					scan.nextLine();
					inputString = scan.nextLine();
					profDTO.setNome(inputString);

					System.out.println("Insira um CPF");
					inputString = scan.nextLine();
					profDTO.setCpf(inputString);
					
					System.out.println("Insira um RG");
					inputString = scan.nextLine();
					profDTO.setRg(inputString);

					System.out.println("Insira um endereço");
					inputString = scan.nextLine();
					profDTO.setEndereco(inputString);

					System.out.println("Insira um número de celular");
					profDTO.setCelular(inputString);
			
					prof[profSize].setId(profDTO.getId());
					prof[profSize].setCelular(profDTO.getCelular());
					prof[profSize].setCpf(profDTO.getCpf());
					prof[profSize].setRg(profDTO.getRg());
					prof[profSize].setEndereco(profDTO.getEndereco());

					System.out.println("Atribuir cursos");
					input = scan.nextInt();
					prof[profSize].setCursos(new ArrayList<>(Arrays.asList(curso[input])));

					profRepository.save(prof[profSize]);
					profSize++;
					break;
				case 2:
					CursoDTO cursoDTO = new CursoDTO();
					cursoDTO.setId((long) 0);

					System.out.println("Insira um curso");
					scan.nextLine();
					inputString = scan.nextLine();
					cursoDTO.setNome(inputString);

					System.out.println("Insira a carga horária");
					input = scan.nextInt();
					cursoDTO.setCargaHoraria(input);
				
					System.out.println("Insira a categoria");
					input = scan.nextInt();
					cursoDTO.setCategoriaCursoId((long) input); 

					curso[cursoSize].setNome(cursoDTO.getNome());
					curso[cursoSize].setCargaHoraria(cursoDTO.getCargaHoraria());
					curso[cursoSize].setCategoriaCurso(categoria); 
					cursoRepository.save(curso[cursoSize]);
					cursoSize++;
					break;
				case 3:
					agenda[agendaSize].setId((long) 0);

					System.out.println("Digite a cidade");
					scan.nextLine();
					inputString = scan.nextLine();
					agenda[agendaSize].setCidade(inputString);

					System.out.println("Digite o estado");
					inputString = scan.nextLine();
					agenda[agendaSize].setEstado(inputString);

					System.out.println("Digite o CEP");
					inputString = scan.nextLine();
					agenda[agendaSize].setCep("000000000");

					System.out.println("Digite a data de início");
					System.out.println("Digite o dia");
					dia = scan.nextInt();
					System.out.println("Digite o mês");
					mes = scan.nextInt();
					System.out.println("Digite o ano");
					ano = scan.nextInt();
					agenda[agendaSize].setDatainicio(LocalDate.of(ano, mes, dia));


					System.out.println("Digite a data de fim");
					System.out.println("Digite o dia");
					dia = scan.nextInt();
					System.out.println("Digite o mês");
					mes = scan.nextInt();
					System.out.println("Digite o ano");
					ano = scan.nextInt();
					agenda[agendaSize].setDatafim(LocalDate.of(ano, mes, dia));

					System.out.println("Digite o horario de início");
					System.out.println("Digite a hora");
					horas = scan.nextInt();
					System.out.println("Digite os minutos");
					minutos = scan.nextInt();
					agenda[agendaSize].setHorarioinicio(LocalTime.of(horas,minutos));

					System.out.println("Digite o horario de fim");
					System.out.println("Digite a hora");
					horas = scan.nextInt();
					System.out.println("Digite os minutos");
					minutos = scan.nextInt();
					agenda[agendaSize].setHorariofim(LocalTime.of(horas,minutos));

					System.out.println("Digite o id do professor");
					inputProf = scan.nextInt();
					System.out.println("Digite o id do curso");
					inputCurso = scan.nextInt();
					agenda[agendaSize].setCurso(prof[inputProf].getCursos().get(inputCurso));
					agenda[agendaSize].setProfessor(prof[inputProf]);
					agendamentoRepository.save(agenda[agendaSize]);
					agendaSize ++;
					break;

				case 4:
					inputLoop = false;
					break;
			}
			System.out.println("lalilulelo");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac2Application.class, args);
	}


}
