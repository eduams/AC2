package com.ac2.ac2.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(length = 200, nullable = true)
private String nome;
@Column(nullable = true)
private String cpf;
@Column(nullable = true)
private String rg;
@Column(nullable = true)
private String endereco;
@Column(nullable = true)
private String celular;
@ManyToOne
@JoinColumn(name = "curso_id")
private Curso curso;
}