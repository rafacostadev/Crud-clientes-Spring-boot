package com.estudojava.crud_spring_clientes.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDTO {
	private Long id;
	@NotBlank(message = "O nome não pode ser vazio!")
	private String name;
	private String cpf;
	private Double income;
	@PastOrPresent(message = "A data de nascimento tem que estar no passado ou presente!")
	private LocalDate birthDate;
	private Integer children;
}
