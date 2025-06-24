package com.estudojava.crud_spring_clientes.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationError extends CustomError {
	private List<FieldError> errors = new ArrayList<>();

	public ValidationError(Instant timestamp, Integer status, String error, String path) {
		super(timestamp, status, error, path);
	}

	public void addError(String field, String error) {
		errors.add(new FieldError(field, error));
	}
}
