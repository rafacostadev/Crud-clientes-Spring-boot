package com.estudojava.crud_spring_clientes.dto;

import java.time.Instant;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NotBlank
@Getter
@Setter
public class CustomError {
	private Instant timestamp;
	private Integer status;
	private String error;
	private String path;
}
