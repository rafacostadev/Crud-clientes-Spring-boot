package com.estudojava.crud_spring_clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudojava.crud_spring_clientes.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
