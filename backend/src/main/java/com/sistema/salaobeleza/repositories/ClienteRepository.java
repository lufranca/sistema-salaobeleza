package com.sistema.salaobeleza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.salaobeleza.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
