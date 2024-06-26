package io.github.LeonardoDelfinoA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.LeonardoDelfinoA.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
