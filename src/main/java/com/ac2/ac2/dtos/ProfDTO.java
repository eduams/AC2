package com.ac2.ac2.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfDTO {
private Long id;
private String nome;
private String cpf;
private String rg;
private String endereco;
private String celular;

}