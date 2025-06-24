package com.estudojava.crud_spring_clientes.services.exceptions;

public class DbException extends RuntimeException {
	public DbException(String msg) {
		super(msg);
	}
}
