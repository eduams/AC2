package com.ac2.ac2.models;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(length = 200, nullable = true)
private String cidade;

@Column(nullable = true)
private String estado;

@Column(nullable = true)
private String cep;

@Column(nullable = true)
private LocalDate datainicio;

@Column(nullable = true)
private LocalDate datafim;

@Column(nullable = true)
private LocalTime horarioinicio;

@Column(nullable = true)
private LocalTime horariofim;

@ManyToOne
@JoinColumn(name = "professor_id")
private Professor professor;

@ManyToOne
@JoinColumn(name = "curso_id")
private Curso curso;

}